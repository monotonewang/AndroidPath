package com.androidpath.activity.akservice.servicedemo241;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class StartService extends Service {

    /**
     * 初始化方法 -- 该方法只会被调用一次
     */
    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" + "--->onCreate" + Thread.currentThread().getName());
    }

    /**
     * 该方法会被调用多次 -- 每启动一次service，该方法就会被调用一次
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String name = "";
        if (intent != null)
            name = intent.getStringExtra("name");
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" + "--->onStartCommand" + Thread.currentThread().getName() + "flags=" + flags + "startId=" + startId + "name=" + name);
//        Log.d("print", "--->onStartCommand" + Thread.currentThread().getName() + "flags=" + flags + "startId=" + startId+"name="+name);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx" + "--->onDestroy" + Thread.currentThread().getName());
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

}
