package com.androidpath.activity.abactivity.activitylivecircle;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidpath.R;

/**
 * 在此写用途
 *
 * @author monotone
 * @version V1.0 <描述当前版本功能>
 * @value com.hifunki.www.testactivity.LifeCircleFragment.java
 * @link
 * @since 2017-04-20 16:12:12
 */
public class LifeCircleFragment extends Fragment {
    private String TAG = "test";

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG, "LifeCircleFragment---onAttach: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "LifeCircleFragment---onCreate: ");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG, "LifeCircleFragment---onCreateView: ");
        View inflate = inflater.inflate(R.layout.fragment_lifecircle, null);
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "LifeCircleFragment---onActivityCreated: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "LifeCircleFragment---onStart: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "LifeCircleFragment---onResume: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "LifeCircleFragment---onPause: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "LifeCircleFragment---onStop: ");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "LifeCircleFragment---onDestroyView: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "LifeCircleFragment---onDestroy: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "LifeCircleFragment---onDetach: ");
    }
}
