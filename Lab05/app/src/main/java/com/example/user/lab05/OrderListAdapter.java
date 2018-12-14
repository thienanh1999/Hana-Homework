package com.example.user.lab05;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class OrderListAdapter extends BaseAdapter {
    List<ShoppingItemModel> shoppingItemModels;
    Context context;

    public OrderListAdapter(Context context, List<ShoppingItemModel> shoppingItemModels)
    {
        this.context = context;
        this.shoppingItemModels = shoppingItemModels;
    }

    @Override
    public int getCount() {
        return shoppingItemModels.size();
    }

    @Override
    public Object getItem(int position) {
        return shoppingItemModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        convertView = layoutInflater.inflate(R.layout.item_shopping_item, parent, false);

        ShoppingItemModel shoppingItemModel = shoppingItemModels.get(position);

        TextView tvItem = convertView.findViewById(R.id.tv_item_name);
        tvItem.setText(shoppingItemModel.getName() + " (" + shoppingItemModel.getInCart() + ")");

        return convertView;
    }
}
