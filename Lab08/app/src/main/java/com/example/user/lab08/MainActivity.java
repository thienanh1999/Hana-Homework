package com.example.user.lab08;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    private static final String USER_DATA = "user_data";

    public static List<User> users;

    Button btSignIn;
    EditText etUserName;
    EditText etPassword;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupUI() {
        users = new ArrayList<>();
        users.add(new User("Mr.A", "mr_a", "123456"));
        users.add(new User("Mr.B", "mr_b", "1234"));
        users.add(new User("Khoa Hoang", "khoaha", "6969"));

        btSignIn = findViewById(R.id.bt_sign_in);
        etUserName = findViewById(R.id.et_user_name);
        etPassword = findViewById(R.id.et_password);

        checkUser();

        btSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = etUserName.getText().toString();
                String password = etPassword.getText().toString();

                if (checkValid(userName, password)) {
                    SharedPreferences.Editor editor = getSharedPreferences(USER_DATA, MODE_PRIVATE).edit();
                    editor.putString("userName", userName).commit();

                    User user1 = users.get(0);
                    for (User user : users)
                    {
                        if (user.getUserName().equals(userName) && user.getPassword().equals(password))
                        {
                            user1 = user;
                            break;
                        }
                    }
                    Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                    intent.putExtra("user", user1);
                    startActivity(intent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Wrong ID or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void checkUser() {
        SharedPreferences sharedPreferences = getSharedPreferences(USER_DATA, MODE_PRIVATE);
        String userName = sharedPreferences.getString("userName", null);

        if (userName != null) {
            User user1 = users.get(0);
            for (User user : users)
            {
                if (user.getUserName().equals(userName))
                {
                    user1 = user;
                    break;
                }
            }
            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            intent.putExtra("user", user1);
            startActivity(intent);
        }
    }

    public static boolean checkValid(String userName, String password) {

        for (User user : users) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password))
                return true;
        }
        return false;
    }
}
