package com.example.user.lab06;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MessageAdapter extends BaseAdapter {
    private Context context;
    private List<Message> messages;

    public MessageAdapter(Context context, List<Message> messages) {
        this.context = context;
        this.messages = messages;
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int i) {
        return messages.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        view = layoutInflater.inflate(R.layout.item_message, viewGroup, false);

        Message message = messages.get(i);

        TextView tvFrom = view.findViewById(R.id.tv_from);
        TextView tvContent = view.findViewById(R.id.tv_content);
        ImageView ivMessage = view.findViewById(R.id.iv_message);

        tvFrom.setText(message.getFrom());
        tvContent.setText(message.getContent());
        if (message.isOpened())
        {
            ivMessage.setImageResource(R.drawable.ic_message_black_24dp);
        }
        else
        {
            ivMessage.setImageResource(R.drawable.ic_mail_black_24dp);
        }
        return view;
    }
}
