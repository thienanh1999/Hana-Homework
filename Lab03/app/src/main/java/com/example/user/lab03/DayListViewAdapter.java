package com.example.user.lab03;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class DayListViewAdapter extends BaseAdapter{
    private static final String TAG = "DayListViewAdapter";

    private List<AlarmDayItem> alarmDayItems;
    private Context context;

    public DayListViewAdapter(List<AlarmDayItem> alarmDayItems, Context context) {
        this.alarmDayItems = alarmDayItems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return alarmDayItems.size();
    }

    @Override
    public Object getItem(int i) {
        return alarmDayItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        view = layoutInflater.inflate(R.layout.item_alarm_day, viewGroup, false);

        AlarmDayItem alarmDayItem = alarmDayItems.get(i);

        TextView tvDate = view.findViewById(R.id.tv_date);
        ListView listView = view.findViewById(R.id.lv_alarm_item);

        tvDate.setText(alarmDayItem.day);

        AlarmItemListViewAdapter alarmItemListViewAdapter = new AlarmItemListViewAdapter(alarmDayItem.alarmItems,context);
        listView.setAdapter(alarmItemListViewAdapter);

        return view;
    }
}
