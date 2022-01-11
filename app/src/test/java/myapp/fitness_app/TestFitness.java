package myapp.fitness_app;

import org.junit.Test;

import static org.junit.Assert.*;

import myapp.fitness_app.model.Fitness;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TestFitness {
    @Test
    public void test_Fitness_1() {
        Fitness c = new Fitness(78, 183, 19, "Male", "Moderately Active: exercise 2–3 times/week");

        assertEquals(2842.3125, c.getCal(),0.1);

        assertEquals(2842.3125-250, c.getTarget("Lose 0.5 lbs per week"),0.1);

    }
    @Test
    public void test_Fitness_2() {
        Fitness c = new Fitness(78, 183, 19, "Male", "Not Active");

        assertEquals(2200.5, c.getCal(),0.1);

        assertEquals(2200.5-500, c.getTarget("Lose 1 lbs per week"),0.1);
    }

    @Test
    public void test_Fitness_3() {
        Fitness c = new Fitness(78, 183, 19, "Male", "Lightly Active: exercise 1–2 times/week");

        assertEquals(2521.40625, c.getCal(),0.1);

        assertEquals(2521.40625, c.getTarget("Maintain weight"),0.1);

    }

    @Test
    public void test_Fitness_4() {
        Fitness c = new Fitness(78, 183, 19, "Male", "Very Active: exercise 3–5 times/week");

        assertEquals(3163.21875, c.getCal(),0.1);

        assertEquals(3163.21875+250, c.getTarget("Gain 0.5 lbs per week"),0.1);

    }

    @Test
    public void test_Fitness_5() {
        Fitness c = new Fitness(78, 183, 19, "Male", "Extra Active: exercise 6–7 times/week");

        assertEquals(3484.125, c.getCal(),0.1);

        assertEquals(3484.125+500, c.getTarget("Gain 1 lbs per week"),0.1);

    }

    @Test
    public void test_Fitness_6() {
        Fitness c = new Fitness(59, 163, 25, "Female", "Not Active");

        assertEquals(1322.75 * 1.2, c.getCal(),0.1);

        assertEquals((1322.75 * 1.2)-250, c.getTarget("Lose 0.5 lbs per week"),0.1);

    }
    @Test
    public void test_Fitness_7() {
        Fitness c = new Fitness(59, 163, 25, "Female", "Lightly Active: exercise 1–2 times/week");

        assertEquals(1322.75*1.375, c.getCal(),0.1);

        assertEquals((1322.75 * 1.375)-500, c.getTarget("Lose 1 lbs per week"),0.1);

    }

    @Test
    public void test_Fitness_8() {
        Fitness c = new Fitness(59, 163, 25, "Female", "Moderately Active: exercise 2–3 times/week");

        assertEquals(1322.75*1.55, c.getCal(),0.1);

        assertEquals(1322.75*1.55, c.getTarget("Maintain weight"),0.1);

    }

    @Test
    public void test_Fitness_9() {
        Fitness c = new Fitness(59, 163, 25, "Female", "Very Active: exercise 3–5 times/week");

        assertEquals(1322.75*1.725, c.getCal(),0.1);

        assertEquals((1322.75*1.725)+250, c.getTarget("Gain 0.5 lbs per week"),0.1);

    }

    @Test
    public void test_Fitness_10() {
        Fitness c = new Fitness(59, 163, 25, "Female", "Extra Active: exercise 6–7 times/week");

        assertEquals(1322.75*1.9, c.getCal(),0.1);

        assertEquals((1322.75*1.9)+500, c.getTarget("Gain 1 lbs per week"),0.1);

        assertEquals((1322.75*1.9)-500, c.getTarget("Lose 1 lbs per week"),0.1);

        assertEquals((1322.75*1.9)-250, c.getTarget("Lose 0.5 lbs per week"),0.1);

        assertEquals(1322.75*1.9, c.getTarget("Maintain weight"),0.1);

    }
}