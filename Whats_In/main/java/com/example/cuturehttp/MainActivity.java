package com.example.cuturehttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView noms = (TextView)findViewById(R.id.noms);
        TextView dates = (TextView)findViewById(R.id.dates);

        ArrayList<Spectacle> spectacles = QueryUtils.extractSpectacles();

        String names = "";
        String ddates = "";

        for (Spectacle i : spectacles) {
            names = names + i.getNom();
            ddates = ddates + i.getDate();
        }

        noms.setText(names);
        dates.setText(ddates);
    }
}
