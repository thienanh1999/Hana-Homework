package com.example.user.lab03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btEx1;
    Button btEx2;
    Button btEx3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btEx1 = findViewById(R.id.bt_ex_1);
        btEx1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Exercise1.class);
                startActivity(intent);
            }
        });

        btEx2 = findViewById(R.id.bt_ex_2);
        btEx2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Exercise2.class);
                startActivity(intent);
            }
        });

        btEx3 = findViewById(R.id.bt_ex_3);
        btEx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Exercise3.class);
                startActivity(intent);
            }
        });
    }
}
