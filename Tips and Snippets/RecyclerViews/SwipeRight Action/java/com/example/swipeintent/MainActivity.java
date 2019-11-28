package com.example.swipeintent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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


        }).attachToRecyclerView(rvContacts);
    }
}
