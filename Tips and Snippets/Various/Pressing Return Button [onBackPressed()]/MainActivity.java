package com.example.functionalities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //Showing a Toast message when pressing on the return button
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Toast.makeText(this," Pressing on the phone return button",Toast.LENGTH_LONG).show();
    }
}
