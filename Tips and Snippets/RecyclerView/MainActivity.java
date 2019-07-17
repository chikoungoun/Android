package com.example.udacity_recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    // TODO (1) Create a private static final int called NUM_LIST_ITEMS and set it equal to 100
    private static final int NUM_LIST_ITEMS = 100;

    // TODO (2) Create a GreenAdapter variable called mAdapter
    private GreenAdapter mAdapter;

    // TODO (3) Create a RecyclerView variable called mNumbersList
    private RecyclerView mNumberList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO (4) Use findViewById to store a reference to the RecyclerView in mNumbersList
        mNumberList = (RecyclerView)findViewById(R.id.rv_numbers);

        // TODO (5) Create a LinearLayoutManager variable called layoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        // TODO (6) Use setLayoutManager on mNumbersList with the LinearLayoutManager we created above
        mNumberList.setLayoutManager(layoutManager);

        // TODO (7) Use setHasFixedSize(true) to designate that the contents of the RecyclerView won't change an item's size
        mNumberList.setHasFixedSize(true);

        // TODO (8) Store a new GreenAdapter in mAdapter and pass it NUM_LIST_ITEMS
        mAdapter = new GreenAdapter(NUM_LIST_ITEMS);

        // TODO (9) Set the GreenAdapter you created on mNumbersList
        mNumberList.setAdapter(mAdapter);
    }
}
