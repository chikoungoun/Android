package com.example.swipeintent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<Contact> contacts = new ArrayList<>();
    RecyclerView rvContacts;
    ContactAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        contacts.add(new Contact("Jean","Kul"));
        contacts.add(new Contact("Marcel","Pascool"));
        contacts.add(new Contact("Georges","Sand"));
        contacts.add(new Contact("Alfred","de Musclay"));
        contacts.add(new Contact("Brendan","Trax"));

        adapter = new ContactAdapter((contacts));
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

        // Swipable part
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            // Swipe movement
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                Intent call_button = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:007"));

                startActivity(call_button);

                rvContacts.setAdapter(adapter);
            }

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

                View itemView = viewHolder.itemView;
                int itemHeight = itemView.getHeight();
                final ColorDrawable background = new ColorDrawable(Color.RED);

                background.setBounds(0,itemView.getTop(),itemView.getLeft() + (int) dX, itemView.getBottom());

                background.draw(c);
            }
        }).attachToRecyclerView(rvContacts);
    }
}
