package com.example.tp3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_explicite.*

class ExpliciteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explicite)
        send.setOnClickListener{
            var message= sendMsg.text.toString()
            val intent= Intent(this@ExpliciteActivity, MainActivity::class.java)
            intent.putExtra("msg",message)
            startActivity(intent)


        }
    }
}
