package com.martroutine.android.common.skeleton.app;

import android.app.Application;

import com.martroutine.android.common.skeleton.android.AndroidAppModule;
import com.martroutine.android.common.skeleton.plate.Injector;

import java.util.ArrayList;
import java.util.List;

import dagger.ObjectGraph;

/**
 * Created by MARTROUTINE on 26/03/2014.
 */
public abstract class SocialStalkerApplication extends Application implements Injector {

    private ObjectGraph mObjectGraph;

    @Override
    public void onCreate() {
        super.onCreate();

        AndroidAppModule sharedAppModule = new AndroidAppModule();
        sharedAppModule.sApplicationContext = this.getApplicationContext();

        List<Object> modules = new ArrayList<Object>();
        modules.add(sharedAppModule);
        modules.addAll(getAppModules());

        mObjectGraph = ObjectGraph.create(modules.toArray());

        mObjectGraph.inject(this);
    }

    protected abstract List<Object> getAppModules();

    @Override
    public void inject(Object object) {
        mObjectGraph.inject(object);
    }

    @Override
    public ObjectGraph getObjectGraph() {
        return mObjectGraph;
    }
}
