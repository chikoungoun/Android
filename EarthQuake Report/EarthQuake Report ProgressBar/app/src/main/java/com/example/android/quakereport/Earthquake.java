package com.example.android.quakereport;

import java.util.Date;

public class Earthquake {

    private double magnitude;

    private  String location;

    private long timeStamp;

    private String url;





    public Earthquake( String c, double m, long d,String u){

        magnitude = m;
        location = c;
        timeStamp = d;
        url = u;
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

    public String getUrl() {
        return url;
    }
}
