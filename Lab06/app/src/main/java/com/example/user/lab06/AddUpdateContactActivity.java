package com.example.user.lab06;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddUpdateContactActivity extends BaseActivity {
    private static final String TAG = "AddUpdateContactActivit";

    Button btOK;
    EditText etName;

    Friend friend;
    int index;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_update_contact;
    }

    @Override
    protected void setupUI() {
        etName = findViewById(R.id.et_name);
        btOK = findViewById(R.id.bt_save_update);

        final boolean isNew = getIntent().getExtras().getBoolean("new");

        if (!isNew) {
            friend = (Friend) getIntent().getExtras().getSerializable("current_friend");
            etName.setText(friend.getName());
            index = getIntent().getExtras().getInt("index");
        }

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();

                Intent data = new Intent();
                if (isNew) {
                    friend = new Friend(name);
                } else {
                    friend.setName(etName.getText().toString());
                    data.putExtra("index", index);
                }
                data.putExtra("friend", friend);
                data.putExtra("new", isNew);
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        setResult(Activity.RESULT_CANCELED);
        super.onBackPressed();
    }
}
