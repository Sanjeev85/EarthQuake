package com.example.earthquake;

public class Earthquake {
    private String mLocation, mDate, mMagnitude;

    Earthquake(String magnitude, String loc, String date) {
        this.mMagnitude = magnitude;
        this.mLocation = loc;
        this.mDate = date;
    }

    public String getmMagnitude() {
        return mMagnitude;
    }

    public String getmLocation() {
        return mLocation;
    }

    public String getmDate() {
        return mDate;
    }
}
