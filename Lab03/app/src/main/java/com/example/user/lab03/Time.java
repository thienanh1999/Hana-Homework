package com.example.user.lab03;

public class Time {
    private int hour;
    private int minute;

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    @Override
    public String toString() {
        String h = Integer.toString(hour);
        String m = Integer.toString(minute);
        if (hour < 10) h = "0" + h;
        if (minute < 10) m = "0" + m;
        return (h + ":" + m);
    }
}
