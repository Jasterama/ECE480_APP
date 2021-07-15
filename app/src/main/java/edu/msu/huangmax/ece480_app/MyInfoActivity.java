package edu.msu.huangmax.ece480_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MyInfoActivity extends AppCompatActivity {

    private final static String PREFERENCES = "preferences";

    private SharedPreferences settings;


    private String[] responses = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myinfo);

        settings = getSharedPreferences(PREFERENCES, MODE_PRIVATE);

        TextView textView = (TextView) findViewById(R.id.user_id);
        textView.setText(settings.getString("ID", ""));
    }

    public void onSetID(View view) {
        Intent intent = new Intent(this, SetIDActivity.class);
        startActivity(intent);
    }
    public void onReturnHome(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

