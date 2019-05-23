package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class EarthQuakeAdapter extends ArrayAdapter<Earthquake> {


    public EarthQuakeAdapter(Context context, ArrayList<Earthquake> earthquakes){
        super(context,0,earthquakes);
    }


    @Override
    public View getView(int position,View convertView, ViewGroup parent) {

        Earthquake currentEQ = getItem(position);



        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item,parent,false);
        }




        TextView magnitudeTextView = convertView.findViewById(R.id.magnitude);
        TextView cityTextView = convertView.findViewById(R.id.city);
        TextView dateTextView = convertView.findViewById(R.id.date);

        magnitudeTextView.setText(currentEQ.getMagnitude());
        cityTextView.setText(currentEQ.getCity());
        dateTextView.setText(currentEQ.getDate());






        return convertView;
    }
}
