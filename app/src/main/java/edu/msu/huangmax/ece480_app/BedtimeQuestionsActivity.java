package edu.msu.huangmax.ece480_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class BedtimeQuestionsActivity extends AppCompatActivity {

    private String[] responses = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bedtime_questions);

        Button submitButton = findViewById(R.id.submitButtonBedtime);
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
        getter = findViewById(R.id.bedtimeEntry);
        responses[0] = getter.getText().toString();
        getter = findViewById(R.id.fatigueLevel);
        responses[1] = getter.getText().toString();
        getter = findViewById(R.id.sleepinessLevel);
        responses[2] = getter.getText().toString();

        databaseTool.writeBedtimeQuestions(responses);

        Intent intent = new Intent(this, ThankYouActivity.class);
        startActivity(intent);
    }

    public void onPressBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}