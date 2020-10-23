package com.androidpath.activity.ajbroadcast.localboradcastOne232;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import android.util.Log;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

//LocalBroadcastManager
//        This class is deprecated.
//        LocalBroadcastManager is an application-wide event bus and embraces layer violations in your app:
//        any component may listen events from any other.
//        You can replace usage of LocalBroadcastManager with other implementation of observable pattern,
//        depending on your usecase suitable options may be LiveData or reactive streams.

/**
 *
 * 静态注册，receiver的名称是广播接受者类。
 * 自己设置一个独一无二的action的名称。
 * 其他项目调用要求是action的名称是静态注册的action的名称。
 * 只有有序广播才可以拦截
 */
public class MainActivity232 extends BaseActivity {

    private LocalBroadcastManager localBroadcastManager;
    private MyReceiver myReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main232);

        /**
         * 本地广播管理器的注册
         */
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        myReceiver = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action.intent.abcd");
        localBroadcastManager.registerReceiver(myReceiver, intentFilter);

        getFragmentManager().beginTransaction()
                .add(R.id.fl_fragment, new MyFragment())
                .commit();
    }


    class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("print", "----->接收到本地广播");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (myReceiver != null) {
            localBroadcastManager.unregisterReceiver(myReceiver);
        }
    }
}
