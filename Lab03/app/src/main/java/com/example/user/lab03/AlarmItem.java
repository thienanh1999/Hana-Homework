package com.example.user.lab03;

public class AlarmItem {
    private int type;
    private Time time;
    private String frequency;
    private boolean isOn;

    public AlarmItem(int type, Time time, String frequency, boolean isOn) {
        this.type = type;
        this.time = time;
        this.frequency = frequency;
        this.isOn = isOn;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
