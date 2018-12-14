package com.example.user.lab06;

import android.app.Activity;
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

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_update_contact;
    }

    @Override
    protected void setupUI() {
        etName = findViewById(R.id.et_name);
        btOK = findViewById(R.id.bt_save_update);

        btOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                Friend friend = new Friend(name);
                Log.d(TAG, "onClick: " + name);
            }
        });
    }

    @Override
    public void onBackPressed() {
        setResult(Activity.RESULT_CANCELED);
        super.onBackPressed();
    }
}
