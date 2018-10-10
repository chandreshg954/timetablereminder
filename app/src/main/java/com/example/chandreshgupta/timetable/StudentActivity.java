package com.example.chandreshgupta.timetable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class StudentActivity extends AppCompatActivity {
    private String[] sem_array;
    private ListView lv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        Toolbar toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        toolbar.setTitle("TimeTable Reminder");
        setSupportActionBar(toolbar);
        sem_array = getResources().getStringArray(R.array.semester_array);
        lv2 = (ListView)findViewById(R.id.lv_student);
        SimpleAdapter sa1 = new SimpleAdapter();
        lv2.setAdapter(sa1);
        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Intent i = new Intent(StudentActivity.this , DisplaySemesterTimetable.class);
                //Intent i = new Intent(StudentActivity.this , ActivityTab.class);
                //i.putExtra("semesterid" , position+1);
                //Intent i = new Intent(StudentActivity.this , DayActivityStudent.class);
                Intent i = new Intent(StudentActivity.this , ActivityTabSemester.class);
                i.putExtra("semesterid" , position+1);
                startActivity(i);
            }
        });
    }
    class SimpleAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return sem_array.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.customlistviews_student_day, null);
            TextView semester = (TextView) view.findViewById(R.id.tv_sem);
            //TextView see = (TextView) view.findViewById(R.id.tv_see);
            semester.setText(sem_array[i]);
            return view;
        }
    }
}
