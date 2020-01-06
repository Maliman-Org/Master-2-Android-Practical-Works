package com.example.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.util.Log;
import android.widget.Toast;

public class Receiver extends BroadcastReceiver {
    private final String TAG="Receive";
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG,"Intent received");
        Vibrator v= (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(500);
        Toast.makeText(context,"Intent received by receiver",Toast.LENGTH_SHORT).show();



    }
}

