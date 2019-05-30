package com.androidpath.view.widget.custom.canvasBezier;

import android.os.Bundle;
import androidx.annotation.Nullable;

import com.androidpath.activity.aabase.BaseActivity;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/21 11:39 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class BezierActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bezier3View bezierView = new Bezier3View(this);
        setContentView(bezierView);
    }
}
