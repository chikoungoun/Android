package com.example.myviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.myviewpager.PageFragment;

public class PageAdapter extends FragmentPagerAdapter {



    private int[] colors;

    public PageAdapter(FragmentManager fm, int[] colors) {
        super(fm);
        this.colors = colors;
    }


    // Number of pages
    @Override
    public int getCount() {
        return 5;
    }

    // Page to return
    @Override
    public Fragment getItem(int position) {
        return PageFragment.newInstance(position,this.colors[position]);
    }
}
