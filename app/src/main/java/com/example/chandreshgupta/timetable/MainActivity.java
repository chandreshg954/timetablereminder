package com.example.chandreshgupta.timetable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //DatabaseHelper mydb;
    public Button button1;

    public void fac_activity(){
        button1= (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_fac = new Intent(MainActivity.this , FacultyActivity.class);
                startActivity(intent_fac);
            }
        });
    }

    public Button button2;

    public void student_activity(){
        button2= (Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_stud = new Intent(MainActivity.this , StudentActivity.class);
                startActivity(intent_stud);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        toolbar.setTitle("TimeTable Reminder");
        setSupportActionBar(toolbar);
        fac_activity();
        student_activity();
    }
}



