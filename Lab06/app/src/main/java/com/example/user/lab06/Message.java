package com.example.user.lab06;

public class Message {
    private String from;
    private String content;
    private boolean opened;

    public Message(String from, String content, boolean opened) {
        this.from = from;
        this.content = content;
        this.opened = opened;
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
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }
}
