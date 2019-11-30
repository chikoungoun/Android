package com.example.swipeintent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
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



                // call the dial intent
                startActivity(call_button);



                // repopulate the recyclerview not to dismiss the data
                rvContacts.setAdapter(adapter);
            }

            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {


                View itemView = viewHolder.itemView;
                int itemHeight = itemView.getHeight();

                // Setting up the background
                final ColorDrawable background = new ColorDrawable(Color.RED);
                background.setBounds(16,itemView.getTop(),itemView.getLeft() + (int) dX, itemView.getBottom());
                background.draw(c);

                // Setting up the icon image
                final Drawable dial_icon = ContextCompat.getDrawable(MainActivity.this,R.drawable.call_white_24dp);
                int intrinsicWidth = 0;
                int intrinsicHeight = 0;

                intrinsicWidth = dial_icon.getIntrinsicWidth();
                intrinsicHeight = dial_icon.getIntrinsicHeight();

                int dial_iconTop = itemView.getTop() + (itemHeight - intrinsicHeight) / 2;
                int dial_iconMargin = (itemHeight - intrinsicHeight) / 2;

                int dial_iconLeft = itemView.getRight() - dial_iconMargin - intrinsicWidth;
                Log.e("ItemView.Right",""+itemView.getRight());
                int dial_iconRight = itemView.getRight() - dial_iconMargin;

                int dial_iconBottom = dial_iconTop + intrinsicHeight;


                dial_icon.setBounds(itemView.getLeft()+16, dial_iconTop, itemView.getLeft() + intrinsicWidth, dial_iconBottom);
                dial_icon.draw(c);
                


                viewHolder.itemView.setAlpha(0.7f);

                Paint p = new Paint();
                p.setColor(Color.WHITE);
                p.setAntiAlias(true);
                p.setTextSize(34);
                p.setTextAlign(Paint.Align.CENTER);
                float textWidth = p.measureText("Appeler");

                c.drawText("Appeler", itemView.getRight() - 200, itemView.getHeight()/2, p);

                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

            }

            // limit at which the call to intent gets triggered
            @Override
            public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
                return 0.6f;
            }
        }).attachToRecyclerView(rvContacts);
    }
}
