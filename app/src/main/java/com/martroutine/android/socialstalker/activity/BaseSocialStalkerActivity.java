package com.martroutine.android.socialstalker.activity;

import com.martroutine.android.common.skeleton.activity.BaseActivity;

/**
 * Created by MARTROUTINE on 27/03/2014.
 */
public class BaseSocialStalkerActivity extends BaseActivity {

    public static final String TAG = "socialstalker";

    @Override
    protected Object[] geActivitytModules() {
        return new Object[]{
                new ActivityScopeModule(this),
        };
    }
}
