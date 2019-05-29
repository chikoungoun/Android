package com.example.fragment_listview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentAdapter extends FragmentPagerAdapter {

    private static int NUM_ITEMS = 3;

    private Context context;

    public MyFragmentAdapter(Context c,FragmentManager fm) {
        super(fm);
        context = c;
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return "Page "+(position+1);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i) {
            case 0:
                return new AdventureFragment();
            case 1:
                return new FightFragment();
            case 2:
                return new RPGFragment();
            default:
                return null;
        }


    }
}
