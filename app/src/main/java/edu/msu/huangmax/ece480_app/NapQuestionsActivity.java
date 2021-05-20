package edu.msu.huangmax.ece480_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class NapQuestionsActivity extends AppCompatActivity {

    private Spinner spinner;

    private String[] responses = new String[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nap_questions);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.napOptionsSpinner, android.R.layout.simple_spinner_item);

        spinner = findViewById(R.id.napSpinnerOne);
        spinner.setAdapter(adapter);

        Button submitButton = findViewById(R.id.submitButtonNap);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmit();
            }
        });
    }

    public void onSubmit() {
        DatabaseTool databaseTool = new DatabaseTool(getSharedPreferences("preferences", MODE_PRIVATE));
        if (!databaseTool.isValidUser()) {
            Intent intent = new Intent(this, ReEnterActivity.class);
            startActivity(intent);
            return;
        }

        EditText getter;
        responses[0] = spinner.getSelectedItem().toString();
        getter = findViewById(R.id.firstNapStart);
        responses[1] = getter.getText().toString();
        getter = findViewById(R.id.firstNapEnd);
        responses[2] = getter.getText().toString();
        getter = findViewById(R.id.secondNapStart);
        responses[3] = getter.getText().toString();
        getter = findViewById(R.id.secondNapEnd);
        responses[4] = getter.getText().toString();
        getter = findViewById(R.id.thirdNapStart);
        responses[5] = getter.getText().toString();
        getter = findViewById(R.id.thirdNapEnd);
        responses[6] = getter.getText().toString();

        databaseTool.writeNapQuestions(responses);

        Intent intent = new Intent(this, ThankYouActivity.class);
        startActivity(intent);
    }

    public void onPressBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}