package com.example.functionalities;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/*
        SwipeRefresh functionality tutorial. Adding a pokemon to the list at each refresh
 */

public class MainActivity extends Activity {



    String url ="https://i.imgur.com/jp2n5qj.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrim_layout);

        ImageView imageView = (ImageView) findViewById(R.id.img);

        Picasso.with(this).load(url).resize(600,200).into(imageView);


    }



}
