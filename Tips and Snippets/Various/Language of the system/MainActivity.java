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
        TextView txt2 = findViewById(R.id.text_view2);

        language = Resources.getSystem().getConfiguration().locale.getLanguage();

        txt.setText(language);

        if (language == "nl"){

            txt2.setText("This is the Nederlandish version");
        }
        else if(language=="fr"){
            txt2.setText("This is the French version");

        }else{
            txt2.setText("This is Another Language than the belgian ones");
        }
    }
}
