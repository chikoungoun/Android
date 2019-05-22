package com.example.mis;

public class Item {

    private String mName;
    private int mColor;

    public  Item(String i,int c){
        mName = i;
        mColor = c;
    }

    public String getName() {
        return mName;
    }

    public int getColor() {
        return mColor;
    }
}
