package com.example.functionalities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*

        Listening on android views to check if they were clicked
 */

public class MainActivity extends AppCompatActivity {

    private EditText ev1;

    private EditText ev2;

    private TextView tv1;

    // Value changes with state (touched /not touched)
    private boolean hasChanged = false;

    // initializing the listener
    private View.OnTouchListener mTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            hasChanged = true;
            // Showing up the change in the Log Error
            Log.e("Touch Listener",""+((TextView)v).getText().toString());
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing the views to be tested
        tv1 = (TextView)findViewById(R.id.tv1);
        ev1 = (EditText)findViewById(R.id.ev1);
        ev2 = (EditText)findViewById(R.id.ev2);

        // Setting up the listener to each view
        tv1.setOnTouchListener(mTouchListener);
        ev1.setOnTouchListener(mTouchListener);
        ev2.setOnTouchListener(mTouchListener);
    }



}
