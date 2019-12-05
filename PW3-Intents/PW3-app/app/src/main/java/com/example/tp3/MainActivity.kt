package com.example.tp3

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState==null){
            var msg =intent.getStringExtra("msg")
            receivedMsg.setText(msg)
        }
        explicite.setOnClickListener{
            val intent= Intent(this@MainActivity, ExpliciteActivity::class.java)
            startActivity(intent)

        }
        implicite.setOnClickListener{
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com")))

        }


    }


}
