package com.androidpath.view.widget.custom.canvasmesure;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.androidpath.activity.aabase.BaseActivity;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/21 14:49 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class PathMesureActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PathMesureView pathMesureView = new PathMesureView(this);
        setContentView(pathMesureView);
    }
}
