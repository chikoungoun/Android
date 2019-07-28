package com.example.cuturehttp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SpectacleRecyclerAdapter extends RecyclerView.Adapter<SpectacleRecyclerAdapter.ViewHolder> {


    private List<Spectacle> mSpectacles;
    private Context mContext;
    private OnItemClickListener mListener;

    public SpectacleRecyclerAdapter(Context mContext,List<Spectacle> spectacles) {
        this.mContext = mContext;
        mSpectacles = spectacles;
    }


    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }


    @Override
    public SpectacleRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {



        View v = LayoutInflater.from(mContext).inflate(R.layout.list_item,viewGroup,false);

        return new ViewHolder(v);
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

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

}
