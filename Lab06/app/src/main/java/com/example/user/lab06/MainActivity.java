package com.example.user.lab06;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    private static final int ADD_UPDATE_REQUEST = 0;
    private static final int SEND_MESSAGE_REQUEST = 1;

    TextView tvFriends;
    TextView tvMessages;
    ListView lvFriends;
    ListView lvMessages;
    LinearLayout llAdd;
    ImageView ivIcon;

    private boolean friend = true;

    public static List<Friend> friends;
    private FriendsAdapter friendsAdapter;
    String[] fr = new String[]{
            "Mr.A",
            "Mr.B",
            "Mr.C",
            "Mr.D",
            "Mr.E"
    };

    private List<Message> messages;
    private MessageAdapter messageAdapter;
    String[] from = new String[]{
            "Mr.C",
            "Mr.B",
            "Mr.E"
    };
    String[] content = new String[]{
            "Hello, how are you?",
            "Can you give me some money?",
            "Yes, I am"
    };
    boolean[] opened = new boolean[]{
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
        ivIcon = findViewById(R.id.iv_icon);

        tvFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!friend) {
                    ivIcon.setImageResource(R.drawable.ic_person_add_black_24dp);
                    friend = true;
                    lvFriends.setVisibility(View.VISIBLE);
                    lvMessages.setVisibility(View.INVISIBLE);
                }
            }
        });

        tvMessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (friend) {
                    ivIcon.setImageResource(R.drawable.ic_send_black_24dp);
                    friend = false;
                    lvMessages.setVisibility(View.VISIBLE);
                    lvFriends.setVisibility(View.INVISIBLE);
                }
            }
        });

        friends = new ArrayList<>();
        for (int i = 0; i < fr.length; i++) {
            Friend friend = new Friend(fr[i]);
            friends.add(friend);
        }
        friendsAdapter = new FriendsAdapter(this, friends);
        lvFriends.setAdapter(friendsAdapter);

        messages = new ArrayList<>();
        for (int i = 0; i < from.length; i++) {
            Message message = new Message(from[i], content[i], opened[i]);
            messages.add(message);
        }
        messageAdapter = new MessageAdapter(this, messages);
        lvMessages.setAdapter(messageAdapter);

        llAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (friend) {
                    Intent intent = new Intent(MainActivity.this, AddUpdateContactActivity.class);
                    intent.putExtra("new", true);
                    startActivityForResult(intent, ADD_UPDATE_REQUEST);
                } else {
                    final Intent intent = new Intent(MainActivity.this, SendMessageActivity.class);

                    PopupMenu popupMenu = new PopupMenu(MainActivity.this, llAdd);
                    popupMenu.getMenuInflater().inflate(R.menu.send_menu, popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem menuItem) {
                            if (menuItem.getItemId() == R.id.sms) {
                                intent.putExtra("sms", true);
                                startActivityForResult(intent, SEND_MESSAGE_REQUEST);
                            } else {
                                intent.putExtra("sms", false);
                                startActivityForResult(intent, SEND_MESSAGE_REQUEST);
                            }
                            return true;
                        }
                    });
                    popupMenu.show();
                }
            }
        });

        friendsAdapter.setItemContactHandler(new ItemContactHandler() {
            @Override
            public void onEditClick(View view, Friend friend, int id) {
                Intent intent = new Intent(MainActivity.this, AddUpdateContactActivity.class);
                intent.putExtra("new", false);
                intent.putExtra("current_friend", friend);
                intent.putExtra("index", id);
                startActivityForResult(intent, ADD_UPDATE_REQUEST);
            }

            @Override
            public void onSendClick(View view, Friend friend) {
                Intent intent = new Intent(MainActivity.this, SendMessageActivity.class);
                intent.putExtra("sms", true);
                intent.putExtra("friend", friend);
                startActivityForResult(intent, SEND_MESSAGE_REQUEST);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_CANCELED) return;

        switch (requestCode) {
            case ADD_UPDATE_REQUEST:
                Friend friend = (Friend) data.getSerializableExtra("friend");
                Boolean isNew = data.getBooleanExtra("new", true);
                if (isNew) {
                    friends.add(friend);
                } else {
                    int id = data.getIntExtra("index", 0);
                    friends.set(id, friend);
                }
                friendsAdapter.notifyDataSetChanged();
                break;
            case SEND_MESSAGE_REQUEST:
                Message message = (Message) data.getSerializableExtra("message");
                messages.add(message);
                messageAdapter.notifyDataSetChanged();
                break;
        }
    }
}
