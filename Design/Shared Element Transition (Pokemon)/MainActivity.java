package com.journaldev.sharedelementtransition;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final ArrayList<String[]> values = new ArrayList<String[]>();
        values.add(new String[]{"Pikachu", "Electric", getString(R.string.pikachu),'#' + Integer.toHexString(getResources().getColor(R.color.pikachu))});
        values.add(new String[]{"Charmander", "Fire", getString(R.string.charmander),'#' + Integer.toHexString(getResources().getColor(R.color.charmander))});
        values.add(new String[]{"Squirtle", "Water",getString(R.string.squirtle),'#' + Integer.toHexString(getResources().getColor(R.color.squirtle))});
        values.add(new String[]{"Bulbasaur", "leaf",getString(R.string.bulbasaur),'#' + Integer.toHexString(getResources().getColor(R.color.bulbasaur))});


        ListView listView = (ListView) findViewById(R.id.list_view);
        CustomAdapter adapter = new CustomAdapter(this, values);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("array",values.get(position));
                // Get the transition name from the string
                String transitionName = getString(R.string.transition);

                ActivityOptionsCompat options =

                        ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this,
                                view,   // Starting view
                                transitionName    // The String
                        );

                ActivityCompat.startActivity(MainActivity.this, intent, options.toBundle());
            }
        });
    }
}
