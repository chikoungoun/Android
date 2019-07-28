package com.example.cuturehttp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SpectacleRecyclerAdapter extends RecyclerView.Adapter<SpectacleRecyclerAdapter.ViewHolder> {


    private List<Spectacle> mSpectacles;
    private Context mContext;

    public SpectacleRecyclerAdapter(Context mContext,List<Spectacle> spectacles) {
        this.mContext = mContext;
        mSpectacles = spectacles;
    }



    @Override
    public SpectacleRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View spectacleView = inflater.inflate(R.layout.list_item,viewGroup,false);

        ViewHolder viewHolder = new ViewHolder(spectacleView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SpectacleRecyclerAdapter.ViewHolder viewHolder, int position) {

        Context context = viewHolder.imageView.getContext();

        Spectacle spectacle = mSpectacles.get(position);

        TextView nomTextView = viewHolder.nomTextview;
        nomTextView.setText(spectacle.getNom());

        TextView dateTextView = viewHolder.dateTextview;
        dateTextView.setText(spectacle.getDate());

        TextView heureTextView = viewHolder.heureTextview;
        heureTextView.setText(spectacle.getHeure());

        ImageView imageView = viewHolder.imageView;
        Picasso.with(context).load(spectacle.getImage()).resize(300,300).into(imageView);




    }

    @Override
    public int getItemCount() {
        return (mSpectacles == null) ? 0 : mSpectacles.size();
    }


    /**
     *   ViewHolder Class
     */
    public class ViewHolder extends  RecyclerView.ViewHolder{

        TextView nomTextview;
        TextView dateTextview;
        TextView heureTextview;
        ImageView imageView;


        public ViewHolder(View itemView) {
            super(itemView);

            nomTextview = itemView.findViewById(R.id.noms);
            dateTextview = itemView.findViewById(R.id.dates);
            heureTextview = itemView.findViewById(R.id.heures);
            imageView = itemView.findViewById(R.id.images);
        }
    }

}
