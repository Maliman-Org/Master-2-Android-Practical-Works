package com.example.testapp

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val CREATE="CREATE"
    val RESTART="RESTART"
    val START="START"
    val RESUME="RESUME"
    val PAUSE="PAUSE"
    val DESTROY="DESTROY"
    val STOP="STOP"
    val NUM="NUM"
    var activity_num=0
    var createCounter=0
    var stopCounter=0
    var resumeCounter=0
    var startCounter=0
    var restartCounter=0
    var destroyCounter=0
    var pauseCounter=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState!=null) {
            createCounter=savedInstanceState.getInt(CREATE)
            stopCounter=savedInstanceState.getInt(STOP)
            resumeCounter=savedInstanceState.getInt(RESUME)
            startCounter=savedInstanceState.getInt(START)
            restartCounter=savedInstanceState.getInt(RESTART)
            destroyCounter=savedInstanceState.getInt(DESTROY)
            pauseCounter=savedInstanceState.getInt(PAUSE)
            activity_num=savedInstanceState.getInt(NUM)

        }else{
            activity_num = intent.getIntExtra(
                "num", 0)}
             setContentView(R.layout.activity_main)
            activity_name.text = "Activity " + (activity_num)
            activity_onCreate.text = (++createCounter).toString()
            activity_onPause.text=(pauseCounter).toString()
            activity_onStop.text=(stopCounter).toString()
            activity_onRestart.text=(restartCounter).toString()

    }

    override fun onStop() {
        super.onStop()
        activity_onStop.text=(++stopCounter).toString()
    }

    override fun onRestart() {
        super.onRestart()
        activity_onRestart.text=(++restartCounter).toString()

    }

    override fun onStart() {
        super.onStart()
        activity_onStart.text=(++startCounter).toString()

    }

    override fun onPause() {
        super.onPause()
        activity_onPause.text=(++pauseCounter).toString()

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy():",(++destroyCounter).toString())
    }

    override fun onResume() {
        super.onResume()
        activity_onResume.text=(++resumeCounter).toString()

    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        savedInstanceState.putInt(CREATE, createCounter)
        savedInstanceState.putInt(RESTART, restartCounter)
        savedInstanceState.putInt(START, startCounter)
        savedInstanceState.putInt(RESUME, resumeCounter)
        savedInstanceState.putInt(PAUSE, pauseCounter)
        savedInstanceState.putInt(DESTROY, destroyCounter)
        savedInstanceState.putInt(STOP, stopCounter)
        savedInstanceState.putInt(NUM,activity_num )
    }

    fun goToSecond(view: View) {
        val mintent= Intent(this@MainActivity, MainActivity::class.java)
        mintent.putExtra("num",++activity_num)
        startActivity(mintent)
    }
    fun goBack(view: View) {
        onBackPressed()
    }

}
