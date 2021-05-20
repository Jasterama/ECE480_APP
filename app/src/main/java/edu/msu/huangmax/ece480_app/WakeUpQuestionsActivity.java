package edu.msu.huangmax.ece480_app;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class WakeUpQuestionsActivity extends AppCompatActivity {

    private Spinner[] spinners = new Spinner[3];
    private String[] responses = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wake_up_questions);

        spinners[0] = (Spinner) findViewById(R.id.wakeupSpinnerOne);
        spinners[1] = (Spinner) findViewById(R.id.wakeupSpinnerTwo);
        spinners[2] = (Spinner) findViewById(R.id.wakeupSpinnerThree);
        /*
         * Set up the spinner
         */

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.wakeupOptionsSpinner, android.R.layout.simple_spinner_item);

        // Apply the adapter to the spinner
        for (int i = 0; i < spinners.length; i++) {
            getSpinner(i).setAdapter(adapter);
        }
        Button submitButton = findViewById(R.id.submitButtonWakeup);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmit();
            }
        });
    }

    private Spinner getSpinner(int i) {
        return spinners[i];
    }

    public void onSubmit() {
        DatabaseTool databaseTool = new DatabaseTool(getSharedPreferences("preferences", MODE_PRIVATE));
        if (!databaseTool.isValidUser()) {
            Intent intent = new Intent(this, ReEnterActivity.class);
            startActivity(intent);
            return;
        }

        EditText wakeUpTimeGet = findViewById(R.id.editTextTime);
        responses[0] = wakeUpTimeGet.getText().toString();
        for (int i = 0; i < spinners.length; i++) {
            responses[i + 1] = spinners[i].getSelectedItem().toString();
        }
        databaseTool.writeWakeUpQuestions(responses);

        Intent intent = new Intent(this, ThankYouActivity.class);
        startActivity(intent);
    }

    public void onPressBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}