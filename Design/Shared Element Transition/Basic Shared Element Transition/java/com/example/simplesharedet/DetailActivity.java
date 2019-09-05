package com.example.simplesharedet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String tr = getIntent().getStringExtra("prime");

        TextView textView = (TextView)findViewById(R.id.detail);
        textView.setText(tr);
    }
}
