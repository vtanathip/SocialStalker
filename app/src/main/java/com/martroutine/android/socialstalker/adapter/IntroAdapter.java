package com.martroutine.android.socialstalker.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by MARTROUTINE on 27/03/2014.
 */
public class IntroAdapter extends FragmentPagerAdapter {

    protected static final ArrayList<Fragment> list = new ArrayList<Fragment>(){

    };


    public IntroAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
