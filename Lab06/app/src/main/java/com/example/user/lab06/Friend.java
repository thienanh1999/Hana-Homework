package com.example.user.lab06;

import java.io.Serializable;

public class Friend implements Serializable {
    private String name;

    public Friend(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
