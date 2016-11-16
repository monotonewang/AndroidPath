package com.androidpath.view.surfaceview;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.androidpath.R;


public class SurfaceViewMainActivity extends FragmentActivity {
    private static final String Tag = SurfaceViewMainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.surfaceview_activity_main);

    }
}
