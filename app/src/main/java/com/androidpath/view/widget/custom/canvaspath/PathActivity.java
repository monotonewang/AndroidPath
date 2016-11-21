package com.androidpath.view.widget.custom.canvaspath;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.androidpath.activity.aabase.BaseActivity;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/21 10:59 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class PathActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PathView pathView=new PathView(this);
        setContentView(pathView);
    }
}
