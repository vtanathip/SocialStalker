package com.martroutine.android.socialstalker.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.martroutine.android.socialstalker.fragment.FacebookFragment;
import com.martroutine.android.socialstalker.fragment.TwitterFragment;
import com.martroutine.android.socialstalker.fragment.WordpressFragment;

/**
 * Created by MARTROUTINE on 29/03/2014.
 */
public class TabAdapter extends FragmentPagerAdapter{
    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FacebookFragment();
            case 1:
                return new WordpressFragment();
            case 2:
                return new TwitterFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
