package edu.msu.huangmax.ece480_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MyInfoActivity extends AppCompatActivity {

    private String[] responses = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);

        // Initialize
        Intent intent = getIntent();
        TextView namePatient = (TextView) findViewById(R.id.insertName);

        TextView nameDoctor = (TextView) findViewById(R.id.insertDoctor);


    }

    public void onSubmit() {
        Intent intent = new Intent(this, ThankYouActivity.class);
        startActivity(intent);
    }
}
