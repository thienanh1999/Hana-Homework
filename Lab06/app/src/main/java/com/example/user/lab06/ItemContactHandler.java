package com.example.user.lab06;

import android.view.View;

public interface ItemContactHandler {

    void onEditClick(View view, Friend friend, int id);

    void onSendClick(View view, Friend friend);

}
