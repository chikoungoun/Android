package com.example.cuturehttp;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.squareup.picasso.Picasso;

import static com.example.cuturehttp.MainActivity.EXTRA_DATE;
import static com.example.cuturehttp.MainActivity.EXTRA_DESCRIPTION;
import static com.example.cuturehttp.MainActivity.EXTRA_HEURE;
import static com.example.cuturehttp.MainActivity.EXTRA_IMAGE;
import static com.example.cuturehttp.MainActivity.EXTRA_LIEU;
import static com.example.cuturehttp.MainActivity.EXTRA_NOM;
import static com.example.cuturehttp.MainActivity.EXTRA_WEBLIEN;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_page);

        //recevoir les infos à travers l'intent depuis MainActivity
        final Intent intent = getIntent();

        String nom = intent.getStringExtra(EXTRA_NOM);
        String date = intent.getStringExtra(EXTRA_DATE);
        String heure = intent.getStringExtra(EXTRA_HEURE);
        String lieu = intent.getStringExtra(EXTRA_LIEU);
        final  String webLien = intent.getStringExtra(EXTRA_WEBLIEN);
        String imageUrl = intent.getStringExtra(EXTRA_IMAGE);
        String description = intent.getStringExtra(EXTRA_DESCRIPTION);



        TextView textNom = (TextView)findViewById(R.id.spectacle_detail);
        TextView textDate = (TextView)findViewById(R.id.date_detail);
        TextView textHeure = (TextView)findViewById(R.id.heure_detail);
        TextView textWebLien = (TextView)findViewById(R.id.webLien_detail);
        TextView textLieu = (TextView)findViewById(R.id.lieu_detail);
        TextView textDescription = (TextView)findViewById(R.id.description_detail);



        // Input the picture
        ImageView imageView = findViewById(R.id.image_detail);
        Picasso.with(this).load(imageUrl).fit().centerInside().into(imageView);



        textNom.setText(nom);
        textDate.setText(date);
        textHeure.setText(heure);
        textLieu.setText(lieu);
        textDescription.setText(formatDescription(description));
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


        // Collapsing Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(" ");

    }

    public String formatDescription(String desc ){

        return desc.replace("[","").replace("]","").replace(",","\n").replace("\"","");
    }



}
