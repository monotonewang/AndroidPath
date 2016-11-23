package com.androidpath.activity.ajbroadcast.staticdymic230;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

/**
 * 动态注册
 * 1、创建一个类，继承BroadCastReceiver（通常是一个内部类）
 * 2、在Activity中，创建该类的全局变量
 * 3、创建一个IntentFilter类，并且赋予action
 * 4、调用registerReceiver（）方法进行动态注册
 * 5、在activity中的onDestroy方法里，进行取消注册
 * @author Ken
 *
 * 静态注册
 * 1、创建一个类，继承BroadCastReceiver（新建一个类）
 * 2、到配置清单文件中，注册该类
 * 
 * 特点：程序退出以后，仍然能够接收到广播
 * 
 * 开机广播：
 * 1、开机广播必须静态注册
 * 2、必须给程序赋予开机启动的权限
 * 3、从android3.1以后，程序必须启动一次后，才可接收到开机启动的广播
 */
public class MainActivity230 extends BaseActivity {

	private MyReceiver myReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main230);
		
		init();
	}

	private void init() {
		myReceiver = new MyReceiver();
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
		intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
		intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);
		intentFilter.addAction(Intent.ACTION_BATTERY_LOW);
		registerReceiver(myReceiver, intentFilter);
	}
	
	/**
	 * 广播接收类
	 * @author Ken
	 *
	 */
	class MyReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			if(intent.getAction() == Intent.ACTION_BATTERY_CHANGED){
				int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
				Log.d("print", "---->收到广播,当前电量：" + level);
			} else if(intent.getAction() == Intent.ACTION_POWER_CONNECTED){
				Log.d("print", "---->电源连接");
			} else if(intent.getAction() == Intent.ACTION_POWER_DISCONNECTED){
				Log.d("print", "---->电源断开");
			} else if(intent.getAction() == Intent.ACTION_BATTERY_LOW){
				Log.d("print", "---->电量不足");
			}
			
		}
	}

	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		if(myReceiver != null){
			unregisterReceiver(myReceiver);
		}
	}
}
