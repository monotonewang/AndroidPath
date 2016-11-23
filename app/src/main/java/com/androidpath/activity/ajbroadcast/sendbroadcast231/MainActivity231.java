package com.androidpath.activity.ajbroadcast.sendbroadcast231;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

public class MainActivity231 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main231);
    }

    public void btnClick(View v) {
        Intent intent = new Intent();
        intent.setAction("android.action.intent.myself");
        this.sendBroadcast(intent);
    }
}
