package com.example.mis;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdapter extends ArrayAdapter<Item> {

    public ItemAdapter(Context context, ArrayList<Item> items){

        super(context,0,items);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // get the item data for this position
        Item currentItem = getItem(position);

        // check if an existing view is being reused, otherf=wise inflate the view
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        // View id for data population
        TextView itemName = convertView.findViewById(R.id.item_name);
        // populate the data
        itemName.setText(currentItem.getName());

        return convertView;
    }
}
