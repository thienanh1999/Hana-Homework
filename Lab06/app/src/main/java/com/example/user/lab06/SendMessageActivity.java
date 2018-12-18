package com.example.user.lab06;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SendMessageActivity extends BaseActivity {
    private static final String TAG = "SendMessageActivity";

    Button btSend;
    EditText etContent;
    Spinner spChooseFriend;

    private List<Friend> friends;
    Friend friend;

    ArrayAdapter<String> arrayAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_send_message;
    }

    @Override
    protected void setupUI() {
        btSend = findViewById(R.id.bt_send);
        etContent = findViewById(R.id.et_content);
        spChooseFriend = findViewById(R.id.sp_choose_friend);

        friends = MainActivity.friends;

        List<String> names = new ArrayList<>();
        for (Friend friend : friends)
        {
            names.add(friend.getName());
        }
        arrayAdapter = new ArrayAdapter<String>(SendMessageActivity.this, android.R.layout.simple_spinner_item, names);
        spChooseFriend.setAdapter(arrayAdapter);

        final boolean sms = getIntent().getExtras().getBoolean("sms");
        friend = (Friend)getIntent().getExtras().getSerializable("friend");

        if (friend == null)
        {
            friend = friends.get(0);
        }

        int index ;
        for (index = 0; index < friends.size(); index++)
        {
            if (friends.get(index).getName().equals(friend.getName()))
            {
                break;
            }
        }

        spChooseFriend.setSelection(index);

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = etContent.getText().toString();
                Toast.makeText(SendMessageActivity.this, "Message sent", Toast.LENGTH_SHORT).show();

                Intent data = new Intent();
                Message message = new Message(spChooseFriend.getSelectedItem().toString(), content, sms);
                data.putExtra("message", message);
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
