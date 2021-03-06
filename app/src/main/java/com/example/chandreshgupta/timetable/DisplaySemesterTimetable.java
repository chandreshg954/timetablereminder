package com.example.chandreshgupta.timetable;

import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static android.content.Intent.getIntent;

@SuppressLint("ValidFragment")
public class DisplaySemesterTimetable extends /*AppCompatActivity*/ Fragment {

    private String[] timing_array , column_array;
    private ListView lv3;
    int col = 2;
    public int sem_id , d_id;
    public String data_url , line , result;
    public DisplaySemesterTimetable(int a , int b){
        sem_id = a;
        d_id = b;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_display_timetable);
        Toolbar toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        toolbar.setTitle("TimeTable Reminder");
        setSupportActionBar(toolbar);
        timing_array = getResources().getStringArray(R.array.time_array);
        column_array = getResources().getStringArray(R.array.column_array);
        sem_id = getIntent().getExtras().getInt("semesterid" , 1);
        d_id = getIntent().getExtras().getInt("dayid" , 1);
        lv3 = (ListView)findViewById(R.id.lv_timetable);
        Backgroungtask bk = new Backgroungtask(this);
        bk.execute();*/
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_display_timetable2, container, false);
        timing_array = getResources().getStringArray(R.array.time_array);
        column_array = getResources().getStringArray(R.array.column_array);
        /*TextView tv = (TextView)v.findViewById(R.id.listview_name);
        tv.setText("Semester" + sem_id);*/
        lv3 = (ListView)v.findViewById(R.id.lv_timetable);
        Backgroungtask bk = new Backgroungtask(this);
        bk.execute();
        return v;
    }

    class Backgroungtask extends AsyncTask<Void , Void , String>{
        InputStream inputStream;
        ProgressDialog mprogress=null;
        DisplaySemesterTimetable mcontext;
        public Backgroungtask(DisplaySemesterTimetable context){
            mcontext = context;
        }
        @Override
        protected void onPreExecute() {
            data_url = "https://timetablezhcet.000webhostapp.com/get_semester_data.php?semesterid="+sem_id+"&dayid="+d_id;
            mprogress = new ProgressDialog(getActivity());
            mprogress.setMessage("Loading Data...");
            mprogress.setTitle("TimeTable Reminder");
            mprogress.setCanceledOnTouchOutside(true);
            mprogress.setCancelable(false);
            mprogress.show();
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(data_url);
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                inputStream = new BufferedInputStream(con.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();

                while ((line = bufferedReader.readLine()) != null){
                    stringBuilder.append(line + "\n");
                }
                bufferedReader.close();
                inputStream.close();
                con.disconnect();
                result = stringBuilder.toString();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mprogress.dismiss();
            loadlistviews(s);
        }
    }

    public void loadlistviews(String json){
        JSONObject jsonObject;
        JSONArray jsonArray;
        try {
            jsonObject = new JSONObject(json);
            jsonArray = jsonObject.getJSONArray("result");
            final JSONObject obj = jsonArray.getJSONObject(0);
            class SimpleAdapter extends BaseAdapter {
                String data;

                @Override
                public int getCount() {
                    return 9;
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
                    view = getLayoutInflater().inflate(R.layout.customlistview_timetable, null);
                    TextView timing = (TextView) view.findViewById(R.id.tv_timing);
                    TextView coursename = (TextView) view.findViewById(R.id.tv_coursename);
                    timing.setText(timing_array[i]);
                    if(i == 6)
                        coursename.setText("Lunch");
                    else{
                        try {
                            data = obj.getString(column_array[i]);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        coursename.setText(data);
                    }
                    return view;
                }
            }
            SimpleAdapter sa2 = new SimpleAdapter();
            lv3.setAdapter(sa2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
