package com.example.mis;

public class Item {

    private String mName;
    private int mColor;
    private int mPage;

    public  Item(String i,int c,int p){
        mName = i;
        mColor = c;
        mPage = p;
    }

    public String getName() {

        return mName;
    }

    public int getColor() {
        return mColor;
    }

    public int getmPage() {
        return mPage;
    }
}
