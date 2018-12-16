package com.example.user.lab06;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.List;

public class FriendsAdapter extends BaseAdapter {
    private Context context;
    private List<Friend> friends;

    ItemContactHandler itemContactHandler;

    public FriendsAdapter(Context context, List<Friend> friends) {
        this.context = context;
        this.friends = friends;
    }

    @Override
    public int getCount() {
        return friends.size();
    }

    @Override
    public Object getItem(int i) {
        return friends.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        view = layoutInflater.inflate(R.layout.item_friend, viewGroup, false);

        final Friend friend = friends.get(i);

        TextView tvName = view.findViewById(R.id.tv_name);
        tvName.setText(friend.getName());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                PopupMenu popupMenu = new PopupMenu(context, view);
                popupMenu.getMenuInflater().inflate(R.menu.friend_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.send_sms) {
                            itemContactHandler.onSendClick(view, friend);
                        }
                        if (menuItem.getItemId() == R.id.edit) {
                            itemContactHandler.onEditClick(menuItem.getActionView(), friend,i);

                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        return view;
    }

    public void setItemContactHandler(ItemContactHandler itemContactHandler) {
        this.itemContactHandler = itemContactHandler;
    }
}
