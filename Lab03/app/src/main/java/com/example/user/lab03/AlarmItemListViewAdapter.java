package com.example.user.lab03;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AlarmItemListViewAdapter extends BaseAdapter {
    private static final String TAG = "AlarmItemListViewAdapte";
    private List<AlarmItem> alarmItems;
    Context context;

    public AlarmItemListViewAdapter(List<AlarmItem> alarmItems, Context context) {
        this.alarmItems = alarmItems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return alarmItems.size();
    }

    @Override
    public Object getItem(int i) {
        return alarmItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        view = layoutInflater.inflate(R.layout.item_alarm,viewGroup, false);

        AlarmItem alarmItem = alarmItems.get(i);
        ImageView ivIcon = view.findViewById(R.id.iv_icon);
        TextView tvTime = view.findViewById(R.id.tv_time);
        TextView tvFrequency = view.findViewById(R.id.tv_frequency);

        if (alarmItem.getType() == 0) ivIcon.setImageResource(R.drawable.ic_donut);
        if (alarmItem.getType() == 1) ivIcon.setImageResource(R.drawable.ic_gift_box);
        if (alarmItem.getType() == 2) ivIcon.setImageResource(R.drawable.ic_party_hat);

        tvTime.setText(alarmItem.getTime().toString());

        tvFrequency.setText(alarmItem.getFrequency());

        return view;
    }
}
