package com.example.cuturehttp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    public static final String SPEC_JSON="https://raw.githubusercontent.com/chikoungoun/Scraping/master/Maroc%20Culture/TNM5/tnm5_records";

    private SpectacleRecyclerAdapter adapter;
    private RecyclerView mRecyclerView;
    private ArrayList<Spectacle> mSpectacleList;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fake_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mSpectacleList = new ArrayList<>();

        mRequestQueue = Volley.newRequestQueue(this);

        parseJSON();




    }


    private void parseJSON(){

        JsonArrayRequest request = new JsonArrayRequest(SPEC_JSON,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        try {

                            for(int i=0;i<jsonArray.length();i++){

                                JSONObject jObject = jsonArray.getJSONObject(i);

                                String nom = jObject.getString("noms");
                                String date = jObject.getString("date");
                                String heure = jObject.getString("heure");
                                String image = jObject.getString("image");
                                String webLien = jObject.getString("lien");
                                String lieu = jObject.getString("lieu");

                                Spectacle spectacle = new Spectacle(nom,date,heure,image,lieu,webLien);

                                mSpectacleList.add(spectacle);
                            }

                            adapter = new SpectacleRecyclerAdapter(MainActivity.this,mSpectacleList);
                            mRecyclerView.setAdapter(adapter);


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }



}
