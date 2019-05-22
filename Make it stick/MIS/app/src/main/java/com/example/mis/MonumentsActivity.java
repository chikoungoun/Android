package com.example.mis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MonumentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_list);

        ArrayList<Item> monuments = new ArrayList<Item>();
        monuments.add(new Item("Oudaya",R.color.box_monuments));
        monuments.add(new Item("Mausolée",R.color.box_gardens));
        monuments.add(new Item("Hassan Tower",R.color.box_transportation));
        monuments.add(new Item("Medina",R.color.box_restos));
        monuments.add(new Item("Bab el Had",R.color.box_secrets));
        monuments.add(new Item("Bab Rouah",R.color.box_monuments));
        monuments.add(new Item("Mellah",R.color.box_gardens));

        ItemAdapter adapter = new ItemAdapter(this,monuments);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);


    }
}
