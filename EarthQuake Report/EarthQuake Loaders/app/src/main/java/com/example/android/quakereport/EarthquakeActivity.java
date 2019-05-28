/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity implements LoaderCallbacks<List<Earthquake>> {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();

    /**
     * Constant value for the earthquake loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    private static final int EARTHQUAKE_LOADER_ID = 1;

    // Adapter for the earthquake list
    private EarthQuakeAdapter adapter;


    // URL for earthquake data
    public static  final String USGS_REQUEST_URL ="https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";


    // TextView when the list is empty
    private TextView emptyStateTextView;



    /***
     * Implementing Loaders functionality
     *
     */

    @Override
    public Loader<List<Earthquake>> onCreateLoader(int i,Bundle bundle) {
        Log.e("Activity","oncreatingLoader()");

        return new EarthquakeLoader(this,USGS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Earthquake>> loader, List<Earthquake> data) {
        Log.e("Activity","onLoadFinished()");

        // Loading Progress bar
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        //Set empty state for when we can't retrieve the data
        emptyStateTextView.setText(R.string.no_earthquakes);



        // clear the adapter of previous earthquake data
        adapter.clear();

        // update the listview if there is a valid list of earthquakes
        if(data != null && !data.isEmpty()){
            adapter.addAll(data);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Earthquake>> loader) {
        Log.e("Activity","onLoaderReset()");

        adapter.clear();
    }

    /*
            Loader End
     */



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);





        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);




        // Create a textview for when the fetch doesnt get
        emptyStateTextView = findViewById(R.id.empty_view);
        earthquakeListView.setEmptyView(emptyStateTextView);

        // Create a new {@link ArrayAdapter} of earthquakes
        adapter = new EarthQuakeAdapter(this, new ArrayList<Earthquake>());


        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Earthquake currentEarthquake = adapter.getItem(position);

                // Convert the string into a URI object
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());


                Intent i = new Intent(Intent.ACTION_VIEW,earthquakeUri);
                startActivity(i);
            }
        });



        LoaderManager loaderManager = getLoaderManager();

        loaderManager.initLoader(EARTHQUAKE_LOADER_ID,null,this);



    }


}
