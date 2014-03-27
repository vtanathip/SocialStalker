package com.martroutine.android.common.skeleton.fragment;

import android.app.Fragment;
import android.os.Bundle;

import com.martroutine.android.common.skeleton.activity.BaseActivity;

/**
 * Created by MARTROUTINE on 27/03/2014.
 */
public class BaseFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Assume that it lives within a BaseActivity host
        ((BaseActivity)getActivity()).inject(this);
    }
}
