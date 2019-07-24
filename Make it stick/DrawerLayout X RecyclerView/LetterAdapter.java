package com.example.drawerxrecycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class LetterAdapter extends RecyclerView.Adapter<LetterAdapter.ViewHolder> {

    /*
        LetterAdapter class
     */
    private List<Character> mLetter;


    public LetterAdapter(List<Character> mLetter) {
        this.mLetter = mLetter;
    }


    // Setting up the ViewHolder
    @Override
    public LetterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.list_item,viewGroup,false);

        ViewHolder viewHolder = new ViewHolder(contactView);

        return viewHolder;
    }


    // filling in each textview
    @Override
    public void onBindViewHolder(LetterAdapter.ViewHolder viewHolder, int i) {

        Character letter = mLetter.get(i);

        TextView textView = viewHolder.nameTextView;
        textView.setText(letter.toString());

    }

    // return the total number of elements
    @Override
    public int getItemCount() {
        return mLetter.size();
    }


    /**
     *      ViewHolder class
     */
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nameTextView;


        // Associating the View
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = (TextView)itemView.findViewById(R.id.letter);

        }



    }
}
