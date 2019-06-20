package com.example.functionalities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
         Building an AlertDialog Box
          */
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Alert Dialog message
        builder.setMessage("Alert Dialog");
        // Building the positive message action when clicked on
        builder.setPositiveButton("Positive Button", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.e("AlertDialog","PositiveButton");// Log message to track the activation
            }
        });
        // Building the negative message action when clicked on
        builder.setNegativeButton("Negative Button", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.e("AlertDialog","NegativeButton");
            }
        });
        // Mounting the build into the alertDialog Object and show it
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }



}
