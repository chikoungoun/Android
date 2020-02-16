package com.example.tablayouttutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<List_Data>list_data;
    private Context context;

    public MyAdapter(List<List_Data> list_data, Context context) {
        this.list_data = list_data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.list_data,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final List_Data listData=list_data.get(position);
        Picasso.with(context)
                .load(listData.getImageurl())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img=(ImageView)itemView.findViewById(R.id.image_view);
        }
    }
}
