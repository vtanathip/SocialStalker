package com.martroutine.android.socialstalker.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.martroutine.android.socialstalker.app.R;


public class MainActivity extends BaseSocialStalkerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "MainActivity onCreate.");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceHolderFragment())
                    .commit();
            Log.d(TAG, "Attach fragment to MainActivity.");
        }

    }

    public static class PlaceHolderFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.d(TAG, "MainActivity inner class onCreateView");

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            return rootView;
        }

    }
}
