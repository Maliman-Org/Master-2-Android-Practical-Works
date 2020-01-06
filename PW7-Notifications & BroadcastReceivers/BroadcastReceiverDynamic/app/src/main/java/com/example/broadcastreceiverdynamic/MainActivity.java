package com.example.broadcastreceiverdynamic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import android.content.IntentFilter;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LocalBroadcastManager mBroadcastManager=LocalBroadcastManager.getInstance(getApplicationContext());
        mBroadcastManager.registerReceiver(new Receiver(), new IntentFilter("com.example.broadcastreceiverdynamic.ACTION"));

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBroadcastManager.sendBroadcast(new Intent("com.example.broadcastreceiverdynamic.ACTION"));


            }
        });
    }
}
