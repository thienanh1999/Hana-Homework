package com.example.user.lab05;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OrderListActivity extends AppCompatActivity {
    private static final String TAG = "OrderListActivity";

    private static final String SHOPPING_CART = "shopping_cart";

    private List<ShoppingItemModel> shoppingItemModels;
    private OrderListAdapter orderListAdapter;

    ImageView ivBack;
    ListView lvOrder;
    TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);

        setupUI();
    }

    private void setupUI()
    {
        ivBack = findViewById(R.id.iv_back);
        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        SharedPreferences sharedPreferences = this.getSharedPreferences(SHOPPING_CART, MODE_PRIVATE);
        String[] items = MainActivity.item;
        shoppingItemModels = new ArrayList<>();
        for (int i = 0; i < items.length; i++)
        {
            int amount = sharedPreferences.getInt(items[i], 0);
            if (amount != 0)
            {
                ShoppingItemModel shoppingItemModel = new ShoppingItemModel(items[i], 10);
                shoppingItemModel.buy(amount);
                shoppingItemModels.add(shoppingItemModel);
            }
        }
        orderListAdapter = new OrderListAdapter(this, shoppingItemModels);
        lvOrder = findViewById(R.id.lv_order);
        lvOrder.setAdapter(orderListAdapter);

        tvTotal = findViewById(R.id.tv_total);
        int price = sharedPreferences.getInt("total_price", 0);
        tvTotal.setText(Integer.toString(price));
    }
}
