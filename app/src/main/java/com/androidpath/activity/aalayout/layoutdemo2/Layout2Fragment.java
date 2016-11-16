package com.androidpath.activity.aalayout.layoutdemo2;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/3 11:32 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class Layout2Fragment extends Fragment {

    private View view;
    public String TAG = "Layout2Fragment";
    public  int index;

    public static Fragment getInstance(int res,int index) {
        Layout2Fragment layout2Fragment1 = new Layout2Fragment();
        Bundle bundle = new Bundle();
        bundle.putInt("xxx", res);
        bundle.putInt("xx", index);
        layout2Fragment1.setArguments(bundle);
        return layout2Fragment1;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Bundle bundle = getArguments();
        index = bundle.getInt("xx");

        Log.e(TAG, index+"onAttach: ");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,index+ "onCreate: ");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.e(TAG, index+"onCreateView: ");
        Bundle bundle = getArguments();
        int res = bundle.getInt("xxx", 1);
        view = inflater.inflate(res, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, index+"onViewCreated: ");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, index+"onActivityCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, index+"onStart: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, index+"onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, index+"onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, index+"onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, index+"onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, index+"onDetach: ");
    }
}
