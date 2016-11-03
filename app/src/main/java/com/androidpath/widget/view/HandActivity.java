package com.androidpath.widget.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.androidpath.R;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/3 16:50 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class HandActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.handactivity);
        DrawDemo2 drawDemo = new DrawDemo2(this);
        linearLayout.addView(drawDemo);
    }
}
