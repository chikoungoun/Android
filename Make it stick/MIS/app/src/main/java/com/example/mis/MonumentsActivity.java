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
        monuments.add(new Item("Oudaya"));
        monuments.add(new Item("Mausolée"));
        monuments.add(new Item("Hassan Tower"));
        monuments.add(new Item("Medina"));
        monuments.add(new Item("Bab el Had"));
        monuments.add(new Item("Bab Rouah"));
        monuments.add(new Item("Mellah"));

        ItemAdapter adapter = new ItemAdapter(this,monuments);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);


    }
}
