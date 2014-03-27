package com.martroutine.android.common.skeleton.activity;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.martroutine.android.common.skeleton.app.SocialStalkerApplication;
import com.martroutine.android.common.skeleton.plate.Injector;

import dagger.ObjectGraph;

/**
 * Created by MARTROUTINE on 26/03/2014.
 */
public abstract class BaseActivity extends SherlockFragmentActivity implements Injector {

    private ObjectGraph mActivityGraph;

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SocialStalkerApplication application = (SocialStalkerApplication) getApplication();
        mActivityGraph = application.getObjectGraph().plus(geActivitytModules());

        mActivityGraph.inject(this);
    }

    @Override
    protected void onDestroy() {
        mActivityGraph = null;

        super.onDestroy();
    }

    @Override
    public void inject(Object object) {
        mActivityGraph.inject(object);
    }

    public ObjectGraph getObjectGraph() {
        return mActivityGraph;
    }

    protected abstract Object[] geActivitytModules();
}
