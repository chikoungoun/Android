package com.example.fragment_listview;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GameAdapter extends ArrayAdapter<Game> {

    public GameAdapter(Activity context, ArrayList<Game> games) {
        super(context, 0,games);
        Log.e("Game adapter","constructor");
    }


    @Override
    public View getView(int position,View convertView,ViewGroup parent) {


        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_game,parent,false);
        }

        Game currentGame = getItem(position);

        TextView firstName = (TextView)listItemView.findViewById(R.id.first_name);
        firstName.setText(currentGame.getFname());
        Log.e("Game Adapter","First Name");

        TextView lastName = (TextView)listItemView.findViewById(R.id.last_name);
        lastName.setText(currentGame.getLname());



        return listItemView;
    }
}
