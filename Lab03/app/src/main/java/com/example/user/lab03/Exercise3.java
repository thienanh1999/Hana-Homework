package com.example.user.lab03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.github.clans.fab.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class Exercise3 extends AppCompatActivity {
    private static final String TAG = "Exercise3";

    private List<AlarmDayItem> alarmDayItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise3);

        List<AlarmItem> alarmItems = new ArrayList<>();
        Time time = new Time(7,0);
        AlarmItem alarmItem = new AlarmItem(0, time, "Every Day", true);
        alarmItems.add(alarmItem);
        Time time1 = new Time(18,15);
        AlarmItem alarmItem1 = new AlarmItem(1, time1, "One Time", true);
        alarmItems.add(alarmItem1);

        List<AlarmItem> alarmItems1 = new ArrayList<>();
        Time time2 = new Time(8,30);
        AlarmItem alarmItem2 = new AlarmItem(2,time2, "Sat, Sun", true);
        alarmItems1.add(alarmItem2);

        alarmDayItems = new ArrayList<>();
        AlarmDayItem alarmDayItem = new AlarmDayItem(alarmItems);
        alarmDayItem.day = "Tomorrow";
        AlarmDayItem alarmDayItem1 = new AlarmDayItem(alarmItems1);
        alarmDayItem1.day = "Saturday";
        alarmDayItems.add(alarmDayItem);
        alarmDayItems.add(alarmDayItem1);

        ListView lvItem = findViewById(R.id.lv_alarm_day);
        DayListViewAdapter dayListViewAdapter = new DayListViewAdapter(alarmDayItems, this);
        AlarmItemListViewAdapter alarmItemListViewAdapter = new AlarmItemListViewAdapter(alarmItems, this);
        lvItem.setAdapter(dayListViewAdapter);

        //----------------------------------------
        FloatingActionButton fabAdd = findViewById(R.id.fab_add);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exercise3.this, AddNewAlarmActivity.class);
                startActivity(intent);
            }
        });
    }
}
