package com.example.android.quakereport;

import java.util.Date;

public class Earthquake {

    private String magnitude;

    private  String city;

    private String date;





    public Earthquake( String c, String m, String d){

        magnitude = m;
        city = c;
        date = d;
    }



    public String getDate() {
        return date;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public String getCity() {
        return city;
    }
}
