package com.example.cuturehttp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

// Préparer l'affichage dans une ListView

public class SpectacleAdapter extends ArrayAdapter<Spectacle> {


    public SpectacleAdapter(Context context, ArrayList<Spectacle> spectacles) {
        super(context, 0, spectacles);
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {

        Spectacle spec = getItem(position);

        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        TextView nomTextview = convertView.findViewById(R.id.noms);
        nomTextview.setText(spec.getNom());

        TextView dateTextview = convertView.findViewById(R.id.dates);
        dateTextview.setText(spec.getDate());

        TextView heureTextview = convertView.findViewById(R.id.heures);
        heureTextview.setText(spec.getHeure());

        ImageView imageView = convertView.findViewById(R.id.images);
        Picasso.with(getContext()).load(spec.getImage()).resize(300,300).into(imageView);

        //test url
        //Log.e("test url",spec.getImage());

        return convertView;
    }


}
