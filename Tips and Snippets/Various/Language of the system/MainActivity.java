package com.pharma.applanguage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    String language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView txt = findViewById(R.id.text_view);

        language = Resources.getSystem().getConfiguration().locale.getLanguage();


        txt.setText(language);
    }
}
