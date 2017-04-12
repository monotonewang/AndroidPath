package com.androidpath.activity.affragment.radiofragment124;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidpath.R;

public class MsgFragment extends Fragment {

    private String TAG = MainActivity124.TAG;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(TAG, "MsgFragment+onAttach.....");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "MsgFragment+onCreate.....");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.msg_fragment_layout124, container, false);
        Log.d(TAG, "MsgFragment+onCreateView.....");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "MsgFragment+onActivityCreated.....");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "MsgFragment+onStart.....");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "MsgFragment+onResume.....");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "MsgFragment+onPause.....");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "MsgFragment+onStop.....");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "MsgFragment+onDestroyView.....");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MsgFragment+onDestroy.....");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "MsgFragment+onDetach.....");
    }
}
