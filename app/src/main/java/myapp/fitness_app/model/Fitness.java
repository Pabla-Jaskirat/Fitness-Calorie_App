package myapp.fitness_app.model;

public class Fitness {
    private int cal;
    private int weight;
    private int height;
    private int age;
    private String gender;
    private String activity;
    private double bmr;
    private double mainCal;
    private double targetCal;

    // constructor
    public Fitness(int weight, int height, int age, String gender, String activity){
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
        this.activity = activity;

    }

    public double getCal(){
        // apply the Mifflin St. Jeor Formulas based on the selected gender
        if(this.gender.equals("Male")){
            this.bmr = (10 * this.weight) + (6.25 * this.height) - (5 * this.age) + 5;
        }
        else {
            this.bmr = (10 * this.weight) + (6.25 * this.height) - (5 * this.age) - 161;
        }

        // account for the activity level
        if(this.activity.equals("Not Active")){
            this.mainCal = this.bmr * 1.2;
        }
        else if(this.activity.equals("Lightly Active: exercise 1–2 times/week")){
            this.mainCal = this.bmr * 1.375;
        }
        else if(this.activity.equals("Moderately Active: exercise 2–3 times/week")){
            this.mainCal = this.bmr * 1.55;
        }
        else if(this.activity.equals("Very Active: exercise 3–5 times/week")){
            this.mainCal = this.bmr * 1.725;
        }
        else if(this.activity.equals("Extra Active: exercise 6–7 times/week")){
            this.mainCal = this.bmr * 1.9;
        }


        return this.mainCal;
    }

    public double getTarget(String goal){

        // add or subtract according to the goal selected
        if(goal.equals("Lose 0.5 lbs per week")){
            this.targetCal = this.mainCal - 250;
        }
        else if(goal.equals("Lose 1 lbs per week")){
            this.targetCal = this.mainCal - 500;
        }
        else if(goal.equals("Maintain weight")){
            this.targetCal = this.mainCal;
        }
        else if(goal.equals("Gain 0.5 lbs per week")){
            this.targetCal = this.mainCal + 250;
        }
        else if(goal.equals("Gain 1 lbs per week")){
            this.targetCal = this.mainCal + 500;
        }

        return this.targetCal;
    }


}
