package com.example.chandreshgupta.timetable;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class SplashActivity extends AppCompatActivity{
    Handler h;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        Toolbar toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        toolbar.setTitle("TimeTable Reminder");
        setSupportActionBar(toolbar);
        h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this , MainActivity.class);
                startActivity(i);
                finish();
            }
        } , 1500);
    }
}
