package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    /** Tag for log messages */
    private static final String LOG_TAG = EarthquakeLoader.class.getName();

    private String url;

    public EarthquakeLoader(Context context, String u){
        super(context);
        url = u;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }



    @Override
    public List<Earthquake> loadInBackground() {
        if(url == null){
            return null;
        }

        List<Earthquake> earthquakes = QueryUtils.fetchEarthquakeData(url);
        return  earthquakes;
    }


}
