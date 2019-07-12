package com.example.functionalities;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;

import android.support.v7.widget.Toolbar;
import android.widget.Toast;



/*
        SwipeRefresh functionality tutorial. Adding a pokemon to the list at each refresh
 */

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {



    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //configuring toolbar
        toolbar =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Drawer Layout
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //Navigation View
        navigationView = (NavigationView)findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(this);



    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.drawer_news:
                Toast.makeText(this,"News Page",Toast.LENGTH_SHORT).show();
                break;
            case R.id.drawer_profile:
                Toast.makeText(this,"Profile Page",Toast.LENGTH_SHORT).show();
                break;
            case R.id.drawer_settings:
                Toast.makeText(this,"Settings Page",Toast.LENGTH_SHORT).show();
                break;
                default:
                    break;
        }

        //Exit the Navigation View after the choice
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}





