package com.martroutine.android.socialstalker.activity;

import android.app.Activity;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.martroutine.android.socialstalker.adapter.IntroAdapter;
import com.martroutine.android.socialstalker.app.R;
import com.viewpagerindicator.LinePageIndicator;

import javax.inject.Inject;


public class MainActivity extends BaseSocialStalkerActivity {

    public static final String TAG = "socialstalker";

    @Inject
    public Activity mActivity;

    @Inject
    public LocationManager locationManager;

    @Inject
    public SharedPreferences sharedPreferences;

    private ViewPager viewPager;
    private LinePageIndicator linePageIndicator;
    private IntroAdapter introAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (sharedPreferences.getBoolean("firstrun", true)) {

            introAdapter = new IntroAdapter(getSupportFragmentManager());
            viewPager = (ViewPager) findViewById(R.id.pager);
            viewPager.setAdapter(introAdapter);

            linePageIndicator = (LinePageIndicator)findViewById(R.id.indicator);
            linePageIndicator.setViewPager(viewPager);

            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment(0))
                    .commit();

            sharedPreferences.edit().putBoolean("firstrun", false).commit();

        } else {

            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment(1))
                    .commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public static class PlaceholderFragment extends Fragment {

        private int flag = -1;

        public PlaceholderFragment(int flag) {
            this.flag = flag;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            int fragment = 0;

            switch (flag) {
                case 0:
                    fragment = R.layout.fragment_intro;
                    break;
                case 1:
                    fragment = R.layout.fragment_main;
                    break;
                default:
                    break;
            }

            View rootView = inflater.inflate(fragment, container, false);
            return rootView;
        }
    }
}
