package com.example.cuturehttp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_page);

        //recevoir les infos à travers l'intent depuis MainActivity
        final Intent intent = getIntent();

        String nom = intent.getStringExtra("nom");
        String date = intent.getStringExtra("date");
        String heure = intent.getStringExtra("heure");
        String lieu = intent.getStringExtra("lieu");

        final String webLien = intent.getStringExtra("webLien");

        TextView textNom = (TextView)findViewById(R.id.spectacle);
        TextView textDate = (TextView)findViewById(R.id.date);
        TextView textHeure = (TextView)findViewById(R.id.heure);
        TextView textWebLien = (TextView)findViewById(R.id.webLien);
        TextView textLieu = (TextView)findViewById(R.id.lieu);



        textNom.setText(nom);
        textDate.setText(date);
        textHeure.setText(heure);
        textLieu.setText(lieu);
        //Traitement pour la forme du lien
        textWebLien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = webLien;
                Uri webpage = Uri.parse(url);
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, webpage);
                if (intentWeb.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentWeb);
                }



            }
        });

    }



}
