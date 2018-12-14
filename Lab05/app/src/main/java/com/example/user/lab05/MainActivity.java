package com.example.user.lab05;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String SHOPPING_CART = "shopping_cart";

    private ShoppingItemAdapter shoppingItemAdapter;
    private List<ShoppingItemModel> shoppingItemModels;

    public static String[] item = new String[] {
            "Pizza Panda",
            "KFC Super",
            "Bread Eggs",
            "Coca Cola",
            "Chicken Super",
            "Cup Cake"
    };

    ListView lvShoppingItem;
    TextView tvNumOfItem;
    TextView tvPrice;
    ImageView ivCart;
    Button btOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
    }

    private void setupUI()
    {
        tvNumOfItem = findViewById(R.id.tv_num_of_item);
        tvPrice = findViewById(R.id.tv_price);
        SharedPreferences sharedPreferences = getSharedPreferences(SHOPPING_CART, MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        int total = sharedPreferences.getInt("total_item", 0);
        int price = sharedPreferences.getInt("total_price", 0);
        tvPrice.setText(Integer.toString(price));
        tvNumOfItem.setText(Integer.toString(total));

        lvShoppingItem = findViewById(R.id.lv_shopping_item);
        shoppingItemModels = new ArrayList<>();

        for (int i = 0; i < item.length; i++)
        {
            ShoppingItemModel shoppingItemModel = new ShoppingItemModel(item[i], 10);
            shoppingItemModels.add(shoppingItemModel);
        }
        shoppingItemAdapter = new ShoppingItemAdapter(this, shoppingItemModels);
        shoppingItemAdapter.updateUI(tvPrice, tvNumOfItem);
        lvShoppingItem.setAdapter(shoppingItemAdapter);


        ivCart = findViewById(R.id.iv_cart);
        ivCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, OrderListActivity.class);
                startActivity(intent);
            }
        });
        
        btOrder = findViewById(R.id.bt_order);
        btOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Thank you! Your order is sent to restaurant", Toast.LENGTH_SHORT).show();

                //clear sharedPreferences
                editor.putInt("total_item", 0).commit();
                editor.putInt("total_price", 0).commit();
                for (int i = 0; i < item.length; i++)
                {
                    editor.putInt(item[i], 0).commit();
                }
                tvPrice.setText("0");
                tvNumOfItem.setText("0");
            }
        });
    }
}
