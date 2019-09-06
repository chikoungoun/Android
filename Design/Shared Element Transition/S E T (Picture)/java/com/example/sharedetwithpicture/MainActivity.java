package com.example.sharedetwithpicture;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Main Activity");

        // Adding a fading effect and avoid flashing effect
        Fade fade = new Fade();
        View decor = getWindow().getDecorView();
        fade.excludeTarget(decor.findViewById(R.id.action_bar_container),true);
        fade.excludeTarget(android.R.id.statusBarBackground,true);
        fade.excludeTarget(android.R.id.navigationBarBackground,true);

        getWindow().setEnterTransition(fade);
        getWindow().setExitTransition(fade);

        final ImageView imageView = findViewById(R.id.img_act1);

       imageView.setOnClickListener(new View.OnClickListener(){

           @Override
           public void onClick(View v){

               Intent intent = new Intent(MainActivity.this,DetailActivity.class);

               ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                       MainActivity.this,
                       imageView,
                       ViewCompat.getTransitionName(imageView));
               startActivity(intent,options.toBundle());

           }
       });
    }
}
