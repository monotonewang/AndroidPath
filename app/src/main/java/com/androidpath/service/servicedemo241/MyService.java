package com.androidpath.service.servicedemo241;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

	/**
	 * 初始化方法 -- 该方法只会被调用一次
	 */
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("print", "--->onCreate");
	}
	
	/**
	 * 该方法会被调用多次 -- 每启动一次service，该方法就会被调用一次
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("print", "--->onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("print", "--->onDestroy");
	}
	
	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

}
