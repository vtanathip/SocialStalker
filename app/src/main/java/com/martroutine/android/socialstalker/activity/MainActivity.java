package com.martroutine.android.socialstalker.activity;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.martroutine.android.socialstalker.adapter.TabAdapter;
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

    public static class PlaceHolderFragment extends Fragment implements ActionBar.TabListener {

        private ViewPager viewPager;
        private ActionBar actionBar;
        private TabAdapter mAdapter;
        private String[] tabs;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.d(TAG, "MainActivity inner class onCreateView");

            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            tabs = getResources().getStringArray(R.array.tab_name);
            viewPager = (ViewPager) rootView.findViewById(R.id.pager);

            actionBar = getActivity().getActionBar();
            mAdapter = new TabAdapter(getActivity().getSupportFragmentManager());

            viewPager.setAdapter(mAdapter);
            actionBar.setHomeButtonEnabled(false);
            actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

            for (String tab_name : tabs) {
                actionBar.addTab(actionBar.newTab().setText(tab_name)
                        .setTabListener(this));
                Log.d(TAG, "MainActivity add tab : " + tab_name);
            }

            viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override
                public void onPageSelected(int position) {
                    actionBar.setSelectedNavigationItem(position);
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                }
            });

            Button add_staking_button = (Button) rootView.findViewById(R.id.add_stalking_button);
            add_staking_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(),AddStalkingActivity.class);
                    startActivity(intent);
                }
            });

            return rootView;
        }

        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
            Log.d(TAG, "MainActivity select tab number : " + tab.getPosition());
            viewPager.setCurrentItem(tab.getPosition());
        }

        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        }

    }
}
