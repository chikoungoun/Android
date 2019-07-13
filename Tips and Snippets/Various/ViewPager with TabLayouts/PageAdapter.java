package com.example.myviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {



    private int[] colors;

    public PageAdapter(FragmentManager fm) {
        super(fm);

    }


    // Number of pages
    @Override
    public int getCount() {
        return 3;
    }

    // Page to return
    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return NewsPageFragment.newInstance();
            case 1:
                return ProfilePageFragment.newInstance();
            case 2:
                return ParamPageFragment.newInstance();
                default:
                    return null;
        }
    }

    //will be able customizing tabs name
        @Override
    public CharSequence getPageTitle(int position) {
            switch (position){
                case 0: //Page number 1
                    return "News";
                case 1: //Page number 2
                    return "Profile";
                case 2: //Page number 3
                    return "Parameters";
                default:
                    return null;
            }
    }
}
