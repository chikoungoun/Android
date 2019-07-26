package com.example.transferdatauri;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResponseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.response);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        TextView textResponse = (TextView)findViewById(R.id.answer);
        textResponse.setText(message);

    }
}
