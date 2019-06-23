package com.example.cuturehttp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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

        return convertView;
    }


}
