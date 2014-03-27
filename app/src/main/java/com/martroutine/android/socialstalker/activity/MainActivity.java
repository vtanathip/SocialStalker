package com.martroutine.android.socialstalker.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.martroutine.android.socialstalker.app.R;

import javax.inject.Inject;


public class MainActivity extends BaseSocialStalkerActivity {

    public static final String TAG = "socialstalker";

    @Inject
    public Activity mActivity;

    @Inject
    public LocationManager locationManager;

    @Inject
    public SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sharedPreferences.getBoolean("firstrun", true)) {
            // Do first run stuff here then set 'firstrun' as false
            // using the following line to edit/commit prefs
            Log.i(TAG,"SharePreference data= " + sharedPreferences.getBoolean("firstrun", true));
            sharedPreferences.edit().putBoolean("firstrun", false).commit();

            
        }

        Log.i(TAG,"SharePreference data= " + sharedPreferences.getBoolean("firstrun", true));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
}
