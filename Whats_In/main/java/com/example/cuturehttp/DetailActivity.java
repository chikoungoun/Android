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

        Intent intent = getIntent();
        String nom = intent.getStringExtra("nom");//recevoir le nom à travers l'intent depuis MainActivity

        TextView textNom = (TextView)findViewById(R.id.spectacle);


        textNom.setText(nom);



    }
}
