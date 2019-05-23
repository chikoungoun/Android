package com.example.mis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MonumentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_list);

        final ArrayList<Item> monuments = new ArrayList<Item>();
        monuments.add(new Item("Oudaya",R.color.box_monuments,R.layout.monument));
        monuments.add(new Item("Mausolée",R.color.box_gardens,R.layout.garden));
//        monuments.add(new Item("Hassan Tower",R.color.box_transportation));
//        monuments.add(new Item("Medina",R.color.box_restos));
//        monuments.add(new Item("Bab el Had",R.color.box_secrets));
//        monuments.add(new Item("Bab Rouah",R.color.box_monuments));
//        monuments.add(new Item("Mellah",R.color.box_gardens));

        ItemAdapter adapter = new ItemAdapter(this,monuments);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Item item = monuments.get(position);

                Intent i = new Intent(MonumentsActivity.this,testActivity.class);
                startActivity(i);
            }
        });


    }
}
