package com.example.android.quakereport;

import java.util.Date;

public class Earthquake {

    private double magnitude;

    private  String location;

    private long timeStamp;





    public Earthquake( String c, double m, long d){

        magnitude = m;
        location = c;
        timeStamp = d;
    }



    public long getTimeStamp() {
        return timeStamp;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getLocation() {
        return location;
    }
}
