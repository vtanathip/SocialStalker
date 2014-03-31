package com.martroutine.android.socialstalker.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.martroutine.android.socialstalker.app.R;

/**
 * Created by MARTROUTINE on 30/03/2014.
 */
public class AddStalkingActivity extends BaseSocialStalkerActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stalking);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceHolderFragment())
                    .commit();
            Log.d(TAG, "Attach fragment add to AddStalkingActivity.");
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

    public static class PlaceHolderFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Log.d(TAG, "AddStalkingActivity inner class onCreateView.");

            View rootView = inflater.inflate(R.layout.fragment_add, container, false);

            Button stalkingButton = (Button) rootView.findViewById(R.id.stlking_this_source_button);
            stalkingButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast toast = Toast.makeText(getActivity(), "Button Clicked.", Toast.LENGTH_SHORT);
                    toast.show();
                    getActivity().finish();
                }
            });

            return rootView;
        }

    }
}
