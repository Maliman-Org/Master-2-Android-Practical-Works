package com.nadjemni.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.PaintDrawable;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    LinearLayout l1,l2,l3,l4,l5;
    SeekBar seekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        l1=findViewById(R.id.l1);
        l2=findViewById(R.id.l2);
        l3=findViewById(R.id.l3);
        l4=findViewById(R.id.l4);
        l5=findViewById(R.id.l5);
        l1.setBackground(new PaintDrawable(Color.argb(254,200,0,0)));
        l2.setBackground(new PaintDrawable(Color.argb(154,20,30,50)));
        l3.setBackground(new PaintDrawable(Color.argb(200,120,200,100)));
        l4.setBackground(new PaintDrawable(Color.argb(50,70,200,200)));
        l5.setBackground(new PaintDrawable(Color.argb(80,180,50,2)));

        //l1.setBackgroundColor(20);
        seekBar=findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                l1.setBackground(new PaintDrawable(Color.argb(254,200,0,progress*5)));
                l2.setBackground(new PaintDrawable(Color.argb(154,20,10+progress*5,50)));
                l3.setBackground(new PaintDrawable(Color.argb(200,120+progress*5,200,100)));
                l4.setBackground(new PaintDrawable(Color.argb(50,70,200+progress*5,250)));
                l5.setBackground(new PaintDrawable(Color.argb(80,180,50,2+progress*5)));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.moreId) {
            new AlertDialog.Builder(this)
                    .setTitle("More Information")
                    .setNegativeButton("Not now", null)
                    .setPositiveButton("Go to Youtube", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com")));
                        }
                    })
                    .setMessage("see more detail in youtube")
                    .setCancelable(true)
                    .show();

            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
