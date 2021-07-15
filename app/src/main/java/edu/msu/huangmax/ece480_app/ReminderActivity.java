package edu.msu.huangmax.ece480_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.Calendar;

public class ReminderActivity extends AppCompatActivity {

    Button setNotifButton;
    private AlarmManager alarmMgr;
    private PendingIntent alarmIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);

        setNotifButton = findViewById(R.id.set_button);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("Light Therapy Notification",
                    "Light Therapy Notification", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        setNotifButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                Calendar alertCalender = Calendar.getInstance();

                CheckBox pmCheck = findViewById(R.id.checkBox);

                EditText text = findViewById(R.id.reminder_time);
                String userInput = text.getText().toString();

                int colon = userInput.indexOf(':');

                String hour = userInput.substring(0, colon);
                int hourInt = 0;
                if (pmCheck.isChecked()) {
                    hourInt = Integer.parseInt(hour);
                    hourInt += 12;
                    hour = Integer.toString(hourInt);
                }

                String minute = userInput.substring(colon + 1);

                System.out.println(hour + ":" + minute);

                calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
                calendar.set(Calendar.MINUTE, Integer.parseInt(minute));
                calendar.set(Calendar.SECOND, 0);

                alertCalender.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
                alertCalender.set(Calendar.MINUTE, Integer.parseInt(minute));
                alertCalender.set(Calendar.SECOND, 0);
                alertCalender.add(Calendar.MINUTE, 20);

                Intent intent = new Intent(getApplicationContext(), NotificationReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),
                        1, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                Intent alertIntent = new Intent(getApplicationContext(), NotificationReceiver.class);
                PendingIntent pendingAlertIntent = PendingIntent.getBroadcast(getApplicationContext(),
                        1, alertIntent, PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                        AlarmManager.INTERVAL_DAY, pendingIntent);
                alarmManager.set(AlarmManager.RTC_WAKEUP, alertCalender.getTimeInMillis(),
                        pendingAlertIntent);
                onSubmit();
            }
        });
    }

    public void onSubmit() {
        Intent intent = new Intent(this, ThankYouActivity.class);
        startActivity(intent);
    }

    public void onPressBack(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}