package com.example.recyclerjson;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    // Define Context and Arraylist
    private Context mContext;
    private ArrayList<ExampleItem> mExampleItem;

    public ExampleAdapter(Context mContext, ArrayList<ExampleItem> mExampleItem) {
        this.mContext = mContext;
        this.mExampleItem = mExampleItem;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.list_item,viewGroup,false);

        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {

        ExampleItem currentItem = mExampleItem.get(position);

        String imageUrl = currentItem.getImageUrl();
        String creatorName = currentItem.getCreator();
        int likeCount = currentItem.getLikes();

        holder.textViewName.setText(creatorName);
        holder.textViewLike.setText("Likes : "+likeCount);
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mExampleItem.size();
    }


    /**
     * View Holder Class
     */
    public class ExampleViewHolder extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView textViewName;
        public TextView textViewLike;


        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_view);
            textViewName = itemView.findViewById(R.id.text_view_name);
            textViewLike = itemView.findViewById(R.id.text_view_like);




        }
    }
}
