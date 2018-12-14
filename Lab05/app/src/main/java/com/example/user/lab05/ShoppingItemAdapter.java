package com.example.user.lab05;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class ShoppingItemAdapter extends BaseAdapter {
    private static final String TAG = "ShoppingItemAdapter";

    private static final String SHOPPING_CART = "shopping_cart";

    private Context context;
    private List<ShoppingItemModel> shoppingItemModels;

    private TextView tvPrice;
    private TextView tvTotal;

    public ShoppingItemAdapter(Context context, List<ShoppingItemModel> shoppingItemModels)
    {
        this.context = context;
        this.shoppingItemModels = shoppingItemModels;
    }

    public void updateUI(TextView tvPrice, TextView tvTotal)
    {
        this.tvPrice = tvPrice;
        this.tvTotal = tvTotal;
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

        final ShoppingItemModel shoppingItemModel = shoppingItemModels.get(position);

        TextView tvItemName = convertView.findViewById(R.id.tv_item_name);
        tvItemName.setText(shoppingItemModel.getName());

        final SharedPreferences sharedPreferences = context.getSharedPreferences(SHOPPING_CART,MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //update current item
                int amount = sharedPreferences.getInt(shoppingItemModel.getName(),0);
//                Log.d(TAG, "onClick: " + shoppingItemModel.getName() + " " + amount);
                amount++;
                editor.putInt(shoppingItemModel.getName(),amount).commit();

                //update total item
                int total = sharedPreferences.getInt("total_item", 0);
                total++;
                editor.putInt("total_item", total).commit();
                tvTotal.setText(Integer.toString(total));

                //update total price
                int price = sharedPreferences.getInt("total_price", 0);
                price += shoppingItemModel.getPrice();
                editor.putInt("total_price", price).commit();
                tvPrice.setText(Integer.toString(price));

//                Log.d(TAG, "onClick: " + total + " " + price);
            }
        });

        return convertView;
    }
}
