package com.example.chandreshgupta.timetable;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class FacultyActivity extends AppCompatActivity {
    private ListView lv;
    String[] faculty_name;
    String[] designation_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);
        Toolbar toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        toolbar.setTitle("TimeTable Reminder");
        setSupportActionBar(toolbar);
        faculty_name = getResources().getStringArray(R.array.faculty_array);
        designation_name = getResources().getStringArray(R.array.designation_array);
        lv = (ListView)findViewById(R.id.lv_faculty);
        SimpleAdapter sa = new SimpleAdapter();
        lv.setAdapter(sa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Intent i = new Intent(FacultyActivity.this , DayActivityFaculty.class);
                Intent i = new Intent(FacultyActivity.this , ActivityTabFaculty.class);
                i.putExtra("teacherid" , position+1);
                startActivity(i);
            }
        });
    }
    class SimpleAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return faculty_name.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.customlistviews_faculty, null);
            TextView fac_name = (TextView) view.findViewById(R.id.tv_faculty);
            TextView designation = (TextView) view.findViewById(R.id.tv_designation);
            TextView see = (TextView) view.findViewById(R.id.tv_see);
            ImageView imageView = (ImageView) view.findViewById(R.id.iv_faculty);

            fac_name.setText(faculty_name[i]);
            designation.setText(designation_name[i]);
            switch (i) {
                case 0:
                    imageView.setImageResource(R.drawable.fac_1);
                    break;
                case 1:
                    imageView.setImageResource(R.drawable.fac_2);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.fac_3);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.fac_4);
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.fac_5);
                    break;
                case 5:
                    imageView.setImageResource(R.drawable.fac_6);
                    break;
                case 6:
                    imageView.setImageResource(R.drawable.fac_7);
                    break;
                case 7:
                    imageView.setImageResource(R.drawable.fac_8);
                    break;
                case 8:
                    imageView.setImageResource(R.drawable.fac_9);
                    break;
                case 9:
                    imageView.setImageResource(R.drawable.fac_10);
                    break;
                case 10:
                    imageView.setImageResource(R.drawable.fac_11);
                    break;
                case 11:
                    imageView.setImageResource(R.drawable.fac_12);
                    break;
                case 12:
                    imageView.setImageResource(R.drawable.fac_13);
                    break;
                case 13:
                    imageView.setImageResource(R.drawable.fac_14);
                    break;
                case 14:
                    imageView.setImageResource(R.drawable.fac_15);
                    break;
                case 15:
                    imageView.setImageResource(R.drawable.fac_16);
                    break;
                case 16:
                    imageView.setImageResource(R.drawable.fac_17);
                    break;
                case 17:
                    imageView.setImageResource(R.drawable.fac_18);
                    break;
                case 18:
                    imageView.setImageResource(R.drawable.fac_19);
                    break;
                case 19:
                    imageView.setImageResource(R.drawable.fac_21);
                    break;
                case 20:
                    imageView.setImageResource(R.drawable.fac_22);
                    break;
            }
            return view;
        }
    }
}
