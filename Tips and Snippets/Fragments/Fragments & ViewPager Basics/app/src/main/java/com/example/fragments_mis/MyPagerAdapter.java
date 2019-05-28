package com.example.fragments_mis;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS =3;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    // Retourne le nombre total de pages

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    // Retourne le fragment à retourner sur sa page
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: // Fragment # 0 - This will show FirstFragment
                return FirstFragment.newInstance(0, "Page # 1");
            case 1: // Fragment # 0 - This will show FirstFragment different title
                return FirstFragment.newInstance(1, "Page # 2");
            case 2: // Fragment # 1 - This will show SecondFragment
                return SecondFragment.newInstance(2, "Page # 3");
            default:
                return null;
        }
    }

    // Alimente le TabLayout
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page "+position;
    }
}
