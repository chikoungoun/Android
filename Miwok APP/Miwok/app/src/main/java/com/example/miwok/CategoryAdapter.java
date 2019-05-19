package com.example.miwok;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter {

    private String tabTitles[] = new String[]{"Numbers","Family","Colors","Phrases"};

    private Context context;

    public CategoryAdapter(Context c,FragmentManager fm){
        super(fm);
        context = c;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NumbersFragment();
        } else if (position == 1){
            return new FamilyFragment();
        } else if (position == 2){
            return new ColorsFragment();
        }else{
            return new PhrasesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return context.getString(R.string.category_numbers);
        } else if (position == 1){
            return context.getString(R.string.category_family);
        } else if (position == 2){
            return context.getString(R.string.category_colors);
        }else{
            return context.getString(R.string.category_phrases);
        }
    }
}
