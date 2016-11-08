package com.androidpath.service.localbroadservice242;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;

import java.util.Timer;
import java.util.TimerTask;

public class TimerSerivce extends Service {

	private Timer timer;
	private int count = 0;
	private LocalBroadcastManager localBroadcastManager;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		localBroadcastManager = LocalBroadcastManager.getInstance(this);
	}
	
	/**
	 * 该方法内不能进行耗时操作
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if(timer == null){
			timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					//在子线程中执行的方法
					count++;
					Intent intent = new Intent("android.action.intent.timer");
					intent.putExtra("count", count);
					localBroadcastManager.sendBroadcast(intent);
				}
			}, 0, 1000);
		} else {
			timer.cancel();
			timer = null;
		}
		
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		if(timer != null){
			timer.cancel();
			timer = null;
		}
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}
