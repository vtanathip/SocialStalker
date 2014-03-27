package com.martroutine.android.socialstalker.app;

import com.martroutine.android.common.skeleton.android.AndroidAppModule;

import dagger.Module;

/**
 * Created by MARTROUTINE on 27/03/2014.
 */
@Module(
        complete = true,    // Here it enables object graph validation
        library = true,
        addsTo = AndroidAppModule.class, // Important for object graph validation at compile time
        injects = {
                BaseSocialStalkerApplication.class
        }
)
public class ApplicationScopeModule {
}
