package com.example.mahesh.viewpagerapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

public class CustomPageAdaptor extends FragmentStatePagerAdapter {
    static final int NUM_ITEMS = 3;
    private String tabtitles[] = new String[] {"Tab1","Tab2","Tab3","Tab4","Tab5"};
    Context context1;

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];

    }

    public CustomPageAdaptor(FragmentManager fm,Context context) {
        super(fm);
        context1=context;


    }

    @Override
    public Fragment getItem(int position) {
        // Create fragment object
        Log.d("TAB_NUMBER",String.valueOf(position));
        switch (position){
            case 0:
                Fragment1 fragment1=new Fragment1();
                return fragment1;

            case 1:
                Fragment2 fragment2=new Fragment2();
                return fragment2;
            case 2:
                Fragment3 fragment3=new Fragment3();
                return fragment3;

        }
        return null;

    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
