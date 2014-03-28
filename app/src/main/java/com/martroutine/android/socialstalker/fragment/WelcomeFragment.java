package com.martroutine.android.socialstalker.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.martroutine.android.common.skeleton.fragment.BaseFragment;
import com.martroutine.android.socialstalker.app.R;

/**
 * Created by MARTROUTINE on 28/03/2014.
 */
public class WelcomeFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.viewpagger_welcome, container, false);
    }
}
