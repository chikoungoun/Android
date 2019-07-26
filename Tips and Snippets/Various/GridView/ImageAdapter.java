package com.example.mygridview;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ImageAdapter extends ArrayAdapter<Integer> {


    public ImageAdapter(Context context, ArrayList<Integer> images) {
        super(context, 0,images);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Integer img = getItem(position);


        if(convertView == null){

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }



        ImageView imageView = convertView.findViewById(R.id.grid_img);
        imageView.setImageResource(img);

        TextView textView = (TextView) convertView.findViewById(R.id.grid_text);
        textView.setText(imageView.getResources().getResourceEntryName(img));



        return convertView;
    }
}
