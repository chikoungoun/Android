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
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/*
        SwipeRefresh functionality tutorial. Adding a pokemon to the list at each refresh
 */

public class MainActivity extends Activity {

    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    ArrayList<String> arrayList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipreRefresh);
        listView = (ListView)findViewById(R.id.listView);


        arrayList.add("Bulbizarre");
        arrayList.add("Carapuce");
        arrayList.add("Salameche");
        arrayList.add("Nidoran");
        arrayList.add("Ronflex");

        //swipeRefreshLayout.setColorSchemeResources(getResources(R.color.colorAccent));

        final ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(adapter);



        //Adding a new Pokemon each time we refresh the page by swiping
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                arrayList.add("Pokemon n° "+(arrayList.size()+1));


                listView.setAdapter(adapter);

                swipeRefreshLayout.setRefreshing(false);
            }
        });





    }
}
