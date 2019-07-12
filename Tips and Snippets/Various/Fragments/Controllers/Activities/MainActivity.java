package com.example.myfragments.Controllers.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myfragments.Controllers.Fragments.MainFragment;
import com.example.myfragments.R;

public class MainActivity extends AppCompatActivity implements
        MainFragment.OnButtonClickedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // CallBack from the Fragment
    @Override
    public void onButtonClicked(View v) {

        Log.e(getClass().getSimpleName(),"Button clicked !");
        startActivity(new Intent(this,DetailActivity.class));

    }
}
