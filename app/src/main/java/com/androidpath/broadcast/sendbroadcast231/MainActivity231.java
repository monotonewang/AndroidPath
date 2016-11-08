package com.androidpath.broadcast.sendbroadcast231;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.androidpath.R;

public class MainActivity231 extends Activity {

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
