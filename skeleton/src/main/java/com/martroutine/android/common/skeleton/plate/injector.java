package com.martroutine.android.common.skeleton.plate;

import dagger.ObjectGraph;

/**
 * Created by MARTROUTINE on 26/03/2014.
 */
public interface injector {

    void inject(Object object);

    ObjectGraph getObjectGraph();

}
