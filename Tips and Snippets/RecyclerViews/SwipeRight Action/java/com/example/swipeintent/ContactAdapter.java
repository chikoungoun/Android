package com.example.swipeintent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView firstNameTxt;
        public TextView lastNameTxt;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            firstNameTxt = itemView.findViewById(R.id.first_name);
            lastNameTxt = itemView.findViewById(R.id.last_name);
        }

    }

    private List<Contact> mContacts;

    public ContactAdapter(List<Contact> mContacts) {
        this.mContacts = mContacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View contactView = inflater.inflate(R.layout.cardview_row,parent,false);

        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ViewHolder holder, int position) {

        Contact contact = mContacts.get(position);

        TextView tv1 = holder.firstNameTxt;
        tv1.setText(contact.getFirstName());

        TextView tv2 = holder.lastNameTxt;
        tv2.setText(contact.getLastName());

    }

    @Override
    public int getItemCount() {
        return mContacts.size();
    }
}
