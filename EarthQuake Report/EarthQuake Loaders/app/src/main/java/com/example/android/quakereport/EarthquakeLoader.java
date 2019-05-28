package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    /** Tag for log messages */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    private String url;

    public EarthquakeLoader(Context context, String u){

        super(context);
        url = u;
        Log.e("Loader","EarthquakeLoader constructor");
    }

    @Override
    protected void onStartLoading() {
        Log.e("Loader","onStartLoading()");
        forceLoad();
    }



    @Override
    public List<Earthquake> loadInBackground() {
        Log.e("Loader","LoadInBackground()");
        if(url == null){
            return null;
        }


        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(url);
        return  earthquakes;
    }


}
