package com.martroutine.android.socialstalker.activity;

import android.app.Activity;
import android.content.Context;

import com.martroutine.android.common.skeleton.qualifier.ForActivity;
import com.martroutine.android.socialstalker.app.ApplicationScopeModule;
import com.martroutine.android.socialstalker.fragment.InstructionFragment;
import com.martroutine.android.socialstalker.fragment.WelcomeFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by MARTROUTINE on 27/03/2014.
 */

@Module(
        complete = true,    // Here we enable object graph validation
        library = true,
        addsTo = ApplicationScopeModule.class, // Important for object graph validation at compile time
        injects = {
                MainActivity.class,
                InitialActivity.class,
                WelcomeFragment.class,
                InstructionFragment.class
        }
)
public class ActivityScopeModule {
    private final BaseSocialStalkerActivity mActivity;

    public ActivityScopeModule(BaseSocialStalkerActivity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @Singleton
    @ForActivity
    Context providesActivityContext() {
        return mActivity;
    }

    @Provides
    @Singleton
    Activity providesActivity() {
        return mActivity;
    }
}
