package com.martroutine.android.socialstalker.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.martroutine.android.socialstalker.fragment.InstructionFragment;
import com.martroutine.android.socialstalker.fragment.WelcomeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MARTROUTINE on 27/03/2014.
 */
public class InitialAdapter extends FragmentPagerAdapter {

    public static final String TAG = "socialstalker";

    protected static final List<Fragment> list = new ArrayList<Fragment>() {
        {
            add(new WelcomeFragment());
            add(new InstructionFragment());
        }
    };


    public InitialAdapter(FragmentManager fm) {
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
