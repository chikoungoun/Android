package com.example.mygridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;

    ImageAdapter adapter;

    ArrayList<Integer> pokemons = new ArrayList<Integer>();

    static final String[] letters = new String[] {
            "A", "B", "C", "D", "E",
            "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T",
            "U", "V", "W", "X", "Y", "Z"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView =(GridView) findViewById(R.id.gridview);
        gridView.setNumColumns(3);

        pokemons.add(R.drawable.pikachu);
        pokemons.add(R.drawable.squirtle);
        pokemons.add(R.drawable.charmander);
        pokemons.add(R.drawable.bulbasaur);
        pokemons.add(R.drawable.huitre);
        pokemons.add(R.drawable.gengar);



        adapter = new ImageAdapter(this,pokemons);

        gridView.setAdapter(adapter);



    }
}
