package myapp.fitness_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import myapp.fitness_app.model.Fitness;

public class MainActivity extends AppCompatActivity {

    Fitness c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /* this mutator sets the output label */
    private void setContentsOfTextView(int id, String newContents) {
        View view = findViewById(id);
        TextView textView = (TextView) view;
        textView.setText(newContents);
    }

    /* this accessor retrieves input entered on the text view  */
    private String getInputOfTextField(int id) {
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;
    }

    /* this accessor retrieves input chosen from some spinner (drop-down menu) */
    private String getItemSelected(int id) {
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        String string = spinner.getSelectedItem().toString();
        return string;
    }

    // 2 control methods for the 2 buttons
    public void computeButtonCalculateMainCalClicked(View view){
        // get the values from the required fields
        // weight
        String textW = getInputOfTextField(R.id.inputWeight);
        int w = Integer.parseInt(textW);

        //height
        String textH = getInputOfTextField(R.id.inputHeight);
        int h = Integer.parseInt(textH);

        // age
        String textAge = getInputOfTextField(R.id.inputAge);
        int age = Integer.parseInt(textAge);

        // gender
        String textGender = getItemSelected(R.id.optionGenders);

        // Activity level
        String textActivity = getItemSelected(R.id.optionsAct);

        // call Fitness constructor with retrieved values
        c = new Fitness(w, h, age, textGender, textActivity);

        // call the appropriate method
        double mainCal = c.getCal();
        String outMainCal = String.format("%.0f", mainCal);

        // desired output
        String outputCal = "Your maintenance calories are " + outMainCal;

        // display the result from c.getCal(...);
        setContentsOfTextView(R.id.labelOutput, outputCal);

    }


    public void computeButtonCalculateTargetCalClicked(View view){
        // get the values from the required fields
        // goal
        String textGoal = getItemSelected(R.id.optionsGoal);

        // call the appropriate method
        double targetCal = c.getTarget(textGoal);
        String outTargetCal = String.format("%.0f", targetCal);

        // desired output
        String outputTarget = "Your target calories per day are " + outTargetCal;

        // display the result from c.getTarget(...);
        setContentsOfTextView(R.id.labelTarget, outputTarget);

    }

}