package com.example.fragments_mis;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    FragmentPagerAdapter adapterViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Définir le ViewPager qui permettra de scroller entre les pages

        ViewPager viewPager = (ViewPager)findViewById(R.id.view_pager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewPager);


        // Ajouter un menu TabLayout
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        // Mettre un Listener sur les changements d'état des pages
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int i, float v, int i1) {



            }

            // Afficher un message Toast à chaque changement de page
            @Override
            public void onPageSelected(int i) {

                Toast.makeText(MainActivity.this,"Selected page position : "+i,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }


}
