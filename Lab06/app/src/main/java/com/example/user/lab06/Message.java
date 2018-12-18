package com.example.user.lab06;

import java.io.Serializable;

public class Message implements Serializable{
    private String from;
    private String content;
    private boolean sms;

    public Message(String from, String content, boolean sms) {
        this.from = from;
        this.content = content;
        this.sms = sms;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isOpened() {
        return sms;
    }

    public void setOpened(boolean opened) {
        this.sms = opened;
    }
}
