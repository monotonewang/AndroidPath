package com.androidpath.broadcast.localboradcastTwo233;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;

import com.androidpath.R;

/**
 * 静态注册，receiver的名称是广播接受者类。
 * 自己设置一个独一无二的action的名称。
 * 其他项目调用要求是action的名称是静态注册的action的名称。
 * 只有有序广播才可以拦截
 */
public class MainActivity233 extends FragmentActivity {

    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main233);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_fragment, new TextFragment())
                .commit();
    }

    public void btnClick(View v) {
        Intent intent = new Intent();
        intent.setAction("action.intent.abcd");
        localBroadcastManager.sendBroadcast(intent);
    }
}
