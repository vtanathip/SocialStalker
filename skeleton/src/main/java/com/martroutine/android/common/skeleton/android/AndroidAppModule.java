package com.martroutine.android.common.skeleton.android;

import android.content.Context;
import android.location.LocationManager;

import com.martroutine.android.common.skeleton.qualifier.ForApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static android.content.Context.LOCATION_SERVICE;
/**
 * Created by MARTROUTINE on 26/03/2014.
 */
@Module(
        complete = false,
        library = true,
        injects = {
        }
)
public class AndroidAppModule {
    public static Context sApplicationContext = null;

    @Provides
    @Singleton
    @ForApplication
    Context provideApplicationContext() {
        return sApplicationContext;
    }

    @Provides
    @Singleton
    LocationManager provideLocationManager() {
        return (LocationManager) sApplicationContext.getSystemService(LOCATION_SERVICE);
    }
}
