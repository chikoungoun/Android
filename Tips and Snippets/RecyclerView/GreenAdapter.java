package com.example.udacity_recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class GreenAdapter extends RecyclerView.Adapter<GreenAdapter.NumberViewHolder> {

    private static final String TAG = GreenAdapter.class.getSimpleName();

    private static int viewHolderCount;

    private int numberItems;

    public GreenAdapter(int numberItems) {
        this.numberItems = numberItems;
        viewHolderCount =0;
    }


    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean attachToParent = false;

        View view = inflater.inflate(R.layout.number_list_item,viewGroup,attachToParent);
        NumberViewHolder viewHolder = new NumberViewHolder(view);

        viewHolder.viewHolderIndex.setText("ViewHolder index :"+viewHolderCount);

        // Get the color from the ColorUtils and set it
       int backgroundColorForViewHolder = ColorUtils.getViewHolderBackgroundColorFromInstance(context,viewHolderCount);

       viewHolder.itemView.setBackgroundColor(backgroundColorForViewHolder);

       // increment the viewHolderCount
        viewHolderCount++;
        Log.d(TAG,"onCreateViewHolder : number of ViewHolders created: "+viewHolderCount);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NumberViewHolder holder, int position) {
        Log.d(TAG,"#"+position);
        holder.bind(position);
    }


    @Override
    public int getItemCount() {
        return numberItems;
    }



    /*
    *
    View Holder Part
    *
     */
    class NumberViewHolder extends RecyclerView.ViewHolder{

        TextView listItemNumberView;

        TextView viewHolderIndex;

        public NumberViewHolder( View itemView) {
            super(itemView);

            listItemNumberView = (TextView)itemView.findViewById(R.id.tv_item_number);

           viewHolderIndex =(TextView)itemView.findViewById(R.id.tv_view_holder_instance);
        }

        void bind(int listIndex){
            listItemNumberView.setText(String.valueOf(listIndex));
        }





    }


}
