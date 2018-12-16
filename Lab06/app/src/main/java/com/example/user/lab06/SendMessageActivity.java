package com.example.user.lab06;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class SendMessageActivity extends BaseActivity {

    Button btSend;
    RelativeLayout rlChooseFriend;
    EditText etContent;
    TextView tvName;

    private List<Friend> friends;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_send_message;
    }

    @Override
    protected void setupUI() {
        btSend = findViewById(R.id.bt_send);
        rlChooseFriend = findViewById(R.id.rl_choose_friend);
        etContent = findViewById(R.id.et_content);
        tvName = findViewById(R.id.tv_name);

        rlChooseFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = etContent.getText().toString();
            }
        });
    }
}
