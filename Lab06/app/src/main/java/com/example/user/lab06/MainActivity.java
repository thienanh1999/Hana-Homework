package com.example.user.lab06;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    private static final int ADD_UPDATE_REQUEST = 0;

    TextView tvFriends;
    TextView tvMessages;
    ListView lvFriends;
    ListView lvMessages;
    LinearLayout llAdd;

    private boolean friend = true;

    private List<Friend> friends;
    private FriendsAdapter friendsAdapter;
    String[] fr = new String[] {
            "Mr.A",
            "Mr.B",
            "Mr.C",
            "Mr.D",
            "Mr.E"
    };

    private List<Message> messages;
    private MessageAdapter messageAdapter;
    String[] from = new String[] {
            "Mr.C",
            "Mr.B",
            "Mr.E"
    };
    String[] content = new String[] {
            "Hello, how are you?",
            "Can you give me some money?",
            "Yes, I am"
    };
    boolean[] opened = new boolean[] {
            true, false, true
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupUI() {
        tvFriends = findViewById(R.id.tv_friends);
        tvMessages = findViewById(R.id.tv_messages);
        lvFriends = findViewById(R.id.lv_friends);
        lvMessages = findViewById(R.id.lv_messages);
        llAdd = findViewById(R.id.ll_add);

        tvFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!friend)
                {
                    friend = true;
                    lvFriends.setVisibility(View.VISIBLE);
                    lvMessages.setVisibility(View.INVISIBLE);
                }
            }
        });

        tvMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (friend)
                {
                    friend = false;
                    lvMessages.setVisibility(View.VISIBLE);
                    lvFriends.setVisibility(View.INVISIBLE);
                }
            }
        });

        friends = new ArrayList<>();
        for (int i = 0; i < fr.length; i++)
        {
            Friend friend = new Friend(fr[i]);
            friends.add(friend);
        }
        friendsAdapter = new FriendsAdapter(this, friends);
        lvFriends.setAdapter(friendsAdapter);

        messages = new ArrayList<>();
        for (int i = 0; i < from.length; i++)
        {
            Message message = new Message(from[i], content[i], opened[i]);
            messages.add(message);
        }
        messageAdapter = new MessageAdapter(this, messages);
        lvMessages.setAdapter(messageAdapter);

        llAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddUpdateContactActivity.class);
                startActivityForResult(intent, ADD_UPDATE_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (resultCode)
        {
            case ADD_UPDATE_REQUEST:
                break;
        }
    }
}
