package edu.msu.huangmax.ece480_app;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class AlertReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String mEmail = "WuStudy@msu.edu";
        String mSubject = "Therapy Session Tardy Alert";
        String mMessage = "A patient is late to their light therapy session by at least 20 minutes";

        JavaMailAPI javaMailAPI = new JavaMailAPI(context, mEmail, mSubject, mMessage);

        javaMailAPI.execute();

    }
}
