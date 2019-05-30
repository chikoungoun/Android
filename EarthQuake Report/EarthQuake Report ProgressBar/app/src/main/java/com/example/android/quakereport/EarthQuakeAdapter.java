package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
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

        // Setting the background corresponding to the adequate magnitude
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        int magnitudeColor = getMagnitudeColor(currentEQ.getMagnitude());

        magnitudeCircle.setColor(magnitudeColor);




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

    // Coloring the magnitudes
    private int getMagnitudeColor(double magnitude){
        int magnitudeColorResourceId;
        int magnitudeFloor = (int)Math.floor(magnitude);

        switch (magnitudeFloor){
            case 0:
            case 1 :
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(),magnitudeColorResourceId);
    }
}
