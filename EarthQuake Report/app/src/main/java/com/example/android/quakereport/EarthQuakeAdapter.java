package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
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
        magnitudeTextView.setText(formatMagnitude(currentEQ.getMagnitude()));


        // Spliting the city and the offset
        String location = new String(currentEQ.getLocation());

        String p1 = "";
        String p2 = "";

        if (location.contains(",")){
            String[] parts = location.split(",");
            p1 = parts[0];
            p2 = parts[1];
        }else{
            p1 = "Near of ";
            p2 = location;
        }


        TextView offsetTextView = convertView.findViewById(R.id.offset);
        offsetTextView.setText(p1);

        TextView cityTextView = convertView.findViewById(R.id.location);
        cityTextView.setText(p2);

        // Formatting the data from long to String
        Date dateObject = new Date(currentEQ.getTimeStamp());

        // Formatting the Date
        TextView dateTextView = convertView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        dateTextView.setText(formattedDate);

        // Formatting the Time
        TextView timeView = convertView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);



        return convertView;
    }

    private String formatDate(Date dateObject){
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject){
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatMagnitude(double d){
        DecimalFormat formatter = new DecimalFormat("0.0");
        return formatter.format(d);

    }
}
