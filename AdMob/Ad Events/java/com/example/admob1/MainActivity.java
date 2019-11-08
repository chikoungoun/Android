package com.example.admob1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mInterstitial.isLoaded()){
                    mInterstitial.show();
                }

            }
        });

        mInterstitial = new InterstitialAd(this);
        mInterstitial.setAdUnitId("ca-app-pub-3940256099942544/8691691433");
        AdRequest request = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mInterstitial.loadAd(request);

        mInterstitial.setAdListener(new AdListener(){


            // When the ad is clicked
            @Override
            public void onAdClicked() {
                Log.e("Clicked","La pub a été cliquée");
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
            }

            // When the AD is displayed
            @Override
            public void onAdOpened() {
                Log.e("Opened","La pub est chargée");
            }

            // When we quit the app
            @Override
            public void onAdLeftApplication() {
                Log.e("Left","La pub a été quittée");
            }

            //when the app is closed


            @Override
            public void onAdClosed() {
                Log.e("Opened","La pub a été Fermée");
            }
        });
    }
}
