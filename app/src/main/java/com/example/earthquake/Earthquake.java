package com.example.earthquake;

public class Earthquake {
    private String mLocation, mMagnitude;
    private long mTimeinMillisec;

    Earthquake(String magnitude, String loc, long time) {
        this.mMagnitude = magnitude;
        this.mLocation = loc;
        this.mTimeinMillisec = time;
    }

    public String getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public long getTimeInMilliseconds() {
        return mTimeinMillisec;
    }
}
