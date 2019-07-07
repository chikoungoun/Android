package com.example.functionalities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class StuffAdapter extends ArrayAdapter<Stuff> {

    public StuffAdapter(Context context, List<Stuff> objects) {
        super(context, 0, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Stuff currentStuff = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        TextView nameTextView = convertView.findViewById(R.id.name_view);
        nameTextView.setText(currentStuff.getName());

        ImageView imageView = convertView.findViewById(R.id.img_view);
        Picasso.with(getContext()).load(currentStuff.getImg()).into(imageView);

        return  convertView;
    }
}
