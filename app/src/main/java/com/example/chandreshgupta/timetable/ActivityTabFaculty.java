package com.example.chandreshgupta.timetable;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;
import java.util.List;

public class ActivityTabFaculty extends AppCompatActivity {
    private ViewPager viewPager;
    private TabLayout tablayout;
    public int fac_id;
    public static String[] s = new String[6];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout);

        fac_id = getIntent().getExtras().getInt("teacherid" , 1);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbar.setTitle("TimeTable Reminder");
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        addTabs(viewPager);

        tablayout = (TabLayout) findViewById(R.id.tabs);
        tablayout.setupWithViewPager(viewPager);
    }

    private void addTabs(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new DisplayFacultyTimetable(fac_id , 1), "MON");
        adapter.addFrag(new DisplayFacultyTimetable(fac_id , 2), "TUE");
        adapter.addFrag(new DisplayFacultyTimetable(fac_id , 3), "WED");
        adapter.addFrag(new DisplayFacultyTimetable(fac_id , 4), "THU");
        adapter.addFrag(new DisplayFacultyTimetable(fac_id , 5), "FRI");
        adapter.addFrag(new DisplayFacultyTimetable(fac_id , 6), "SAT");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
