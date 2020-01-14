package com.nadjemni.alarmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static class AlarmLogerReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("TAGME", "The current Time is "+System.currentTimeMillis());
        }
    }
    public static class AlarmNotificationReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(
                    context,
                    "The current Time is "+System.currentTimeMillis(),
                    Toast.LENGTH_SHORT
            ).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        final Intent notificationIntent = new Intent(this, AlarmNotificationReceiver.class);

        final PendingIntent notificationReceiverPendingIntent =
                PendingIntent.getBroadcast(this, 0, notificationIntent, 0);

        final Intent loggerIntent = new Intent(this, AlarmLogerReceiver.class);

        final  PendingIntent loggerReceiverPendingIntent = PendingIntent.getBroadcast(this, 0, loggerIntent, 0);

        ((Button) findViewById(R.id.singleAlarm)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            alarmManager.set(
                    AlarmManager.RTC_WAKEUP,
                    System.currentTimeMillis() + 5000,
                    notificationReceiverPendingIntent);
                alarmManager.set(
                        AlarmManager.RTC_WAKEUP,
                        System.currentTimeMillis() + 7000,
                        loggerReceiverPendingIntent
                );
            }
        });

        ((Button) findViewById(R.id.repeatingAlarm)).setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            alarmManager.setRepeating(
                    AlarmManager.ELAPSED_REALTIME,
                    SystemClock.elapsedRealtime() + 5000,
                    3000,
                    notificationReceiverPendingIntent
            );

            alarmManager.setRepeating(
                    AlarmManager.ELAPSED_REALTIME,
                    SystemClock.elapsedRealtime() + 5000,
                    7000,
                    loggerReceiverPendingIntent
            );


    }
        });

        ((Button) findViewById(R.id.inxactAlarm)).setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            alarmManager.setInexactRepeating(
                    AlarmManager.ELAPSED_REALTIME,
                    SystemClock.elapsedRealtime() + 5000,
                    3000,
                    notificationReceiverPendingIntent
            );

            alarmManager.setInexactRepeating(
                    AlarmManager.ELAPSED_REALTIME,
                    SystemClock.elapsedRealtime() + 5000,
                    3_000,
                    loggerReceiverPendingIntent
            );
        }
    });

        ((Button) findViewById(R.id.cancelAlarm)).setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            alarmManager.cancel(
                    notificationReceiverPendingIntent
            );

            alarmManager.cancel(
                    loggerReceiverPendingIntent
            );
            }
        });
    }

}
