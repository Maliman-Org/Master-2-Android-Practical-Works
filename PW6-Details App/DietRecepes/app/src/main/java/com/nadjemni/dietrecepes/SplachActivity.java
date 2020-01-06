package com.nadjemni.dietrecepes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SplachActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splach);
    }

    public void goToMain(View view) {
        startActivity(new Intent(SplachActivity.this,MainActivity.class));
    }
}
