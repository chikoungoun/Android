package com.example.myset_recyclerview;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ContactsAdapter.OnItemClickListener {

    ArrayList<Contact> contacts;

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvContacts = (RecyclerView) findViewById(R.id.rvContacts);

        contacts = Contact.createContactList(20);

        imageView = findViewById(R.id.images);

        // Create adapter passing in the sample user data
        ContactsAdapter adapter = new ContactsAdapter(contacts);
        // Attach the adapter to the recyclerview to populate items
        rvContacts.setAdapter(adapter);
        // Set layout manager to position the items
        rvContacts.setLayoutManager(new LinearLayoutManager(this));




    }

    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(this,DetailActivity.class);
        Contact clickedItem = contacts.get(position);

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                MainActivity.this,
                imageView,
                ViewCompat.getTransitionName(imageView));
        startActivity(intent,options.toBundle());

    }
}
