package com.example.gmaps_sample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        // Setting up the coordinates
        double latitude = 34.006708;
        double longitude = -6.820793;

        // creating the markers and setting a title
        MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude,longitude)).title("M-Wayne");

        // Adding the marker to the map
        googleMap.addMarker(marker);

        googleMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(latitude,longitude)));

    }
}
