package com.androidpath.activity.affragment.radiofragment124;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidpath.R;

public class ContantFragment extends Fragment {

    private String TAG = MainActivity124.TAG;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(TAG, "ContantFragment+onAttach.....");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "ContantFragment+onCreate.....");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "ContantFragment+onCreateView.....");
        View view = inflater.inflate(R.layout.contact_fragment_layout124, container, false);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "ContantFragment+onActivityCreated.....");
    }


    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "ContantFragment+onStart.....");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "ContantFragment+onResume.....");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "ContantFragment+onPause.....");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "ContantFragment+onStop.....");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "ContantFragment+onDestroyView.....");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "ContantFragment+onDestroy.....");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "ContantFragment+onDetach.....");
    }
}
