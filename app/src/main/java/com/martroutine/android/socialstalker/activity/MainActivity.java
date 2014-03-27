package com.martroutine.android.socialstalker.activity;

import android.app.Activity;
import android.app.Fragment;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.martroutine.android.socialstalker.app.R;

import java.util.List;

import javax.inject.Inject;


public class MainActivity extends BaseSocialStalkerActivity {

    public static final String TAG = "socialstalker";
    @Inject
    public Activity mActivity;

    @Inject
    public LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }

        List<String> allProviders = locationManager.getAllProviders();
        for(String provider : allProviders) {
            Log.i(TAG, "provider is = " + provider);
        }
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
