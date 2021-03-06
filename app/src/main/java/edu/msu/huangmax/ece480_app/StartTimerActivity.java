package edu.msu.huangmax.ece480_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StartTimerActivity extends AppCompatActivity {

    private String START = "START TIMER";
    private String PAUSE = "PAUSE TIMER";

    private TextView countdownText;
    private Button stopButton;
    private Button endButton;
    private CountDownTimer timer;
    private long timeLeftInMilliseconds = 1800000; //30 minutes
     // 5000 for demo
    private boolean running = false;
    private final SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    private String startTime;
    private String endTime;
    private DatabaseTool databaseTool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        databaseTool = new DatabaseTool(getSharedPreferences("preferences", MODE_PRIVATE));
        if (!databaseTool.isValidUser()) {
            Intent intent = new Intent(this, ReEnterActivity.class);
            startActivity(intent);
            return;
        }

        countdownText = findViewById(R.id.timer);
        stopButton = findViewById(R.id.startStop);
        endButton = findViewById(R.id.endButton);
        startTime = formatter.format(new Date());
        startTimer();

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startStop();
            }
        });
        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                end(v);
            }
        });

    }
    public void startStop() {
        if (running) {
            stopButton.setText(START);
            stopTimer();
        } else {
            stopButton.setText(PAUSE);
            startTimer();
        }
    }
    public void startTimer() {
        timer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMilliseconds = millisUntilFinished;
                updateTimerText();
            }

            @Override
            public void onFinish() {
                thankYou();
            }
        }.start();
        running = true;

    }
    public void stopTimer() {
        timer.cancel();
        running = false;
    }
    public void updateTimerText() {
        int secondsLeft = (int) timeLeftInMilliseconds / 1000;
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft % 60;

        String timeLeft = "" + minutes + ':';
        if (seconds < 10) {
            timeLeft += '0';
        }
        timeLeft += seconds;
        countdownText.setText(timeLeft);
    }
    public void end(View view) {
        stopTimer();
        if (timeLeftInMilliseconds > 0) {
            // The puzzle is done
            // Instantiate a dialog box builder
            AlertDialog.Builder builder =
                    new AlertDialog.Builder(view.getContext());

            // Parameterize the builder
            builder.setTitle(R.string.warning);
            builder.setMessage(R.string.incomplete);
            builder.setPositiveButton(R.string.cont, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startTimer();
                }
            });
            builder.setNegativeButton(R.string.endTherapy, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    thankYou();
                }
            });

            // Create the dialog box and show it
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }
    public void thankYou() {
        endTime = formatter.format(new Date());
        String[] responses = new String[2];
        responses[0] = startTime;
        responses[1] = endTime;
        databaseTool.writeTimerUse(responses);

        Intent intent = new Intent(this, ThankYouActivity.class);
        startActivity(intent);
    }
}
