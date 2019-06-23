package com.example.cuturehttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Extraire les données du JSON
        ArrayList<Spectacle> spectacles = QueryUtils.extractSpectacles();

        ListView listView = (ListView)findViewById(R.id.list);

        SpectacleAdapter adapter = new SpectacleAdapter(this,spectacles);

        listView.setAdapter(adapter);
    }
}
