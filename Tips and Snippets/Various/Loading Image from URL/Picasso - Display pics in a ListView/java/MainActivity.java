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


    StuffAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.list);

        ArrayList<Stuff> stuffArrayList = new ArrayList<Stuff>();

        stuffArrayList.add(new Stuff("scarabrute","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTELOETEFdEFNTSyhEbpR6eWwFM1ezkXZs4WQ29TDfk1uf9SbKt"));
        stuffArrayList.add(new Stuff("gecko","https://cdn.bulbagarden.net/upload/4/41/PCP252.png"));
        stuffArrayList.add(new Stuff("akwakwak","https://www.media.pokekalos.fr/img/pokemon/pokego/akwakwak.png"));

        adapter = new StuffAdapter(this, stuffArrayList);

        listView.setAdapter(adapter);



    }



}
