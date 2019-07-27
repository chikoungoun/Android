package com.example.cuturehttp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_page);

        //recevoir les infos à travers l'intent depuis MainActivity
        Intent intent = getIntent();
        String nom = intent.getStringExtra("nom");
        String date = intent.getStringExtra("date");
        String heure = intent.getStringExtra("heure");

        TextView textNom = (TextView)findViewById(R.id.spectacle);
        TextView textDate = (TextView)findViewById(R.id.date);
        TextView textHeure = (TextView)findViewById(R.id.heure);


        textNom.setText(nom);
        textDate.setText(date);
        textHeure.setText(heure);



    }
}
