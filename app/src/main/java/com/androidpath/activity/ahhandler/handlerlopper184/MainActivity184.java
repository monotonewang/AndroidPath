package com.androidpath.activity.ahhandler.handlerlopper184;


import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

public class MainActivity184 extends BaseActivity {
	private Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main184);

		new Thread(new Runnable() {

			@Override
			public void run() {
				Looper.prepare();//在子线程中需要手动创建Looper对象，这个方法会在创建Looper对象的同时创建一个消息队列
//				 Looper.myLooper();//获得Looper对象
				
				//在子线程中创建Handler对象，一定先要调用Looper.prepare方法
				 //handler的内部的构造方法需要获得Looper对象，必须保证有Looper对象
				handler = new Handler() { 
					@Override
					public void handleMessage(Message msg) {
						if (msg.what == 1) {
							Log.e("子线程", "收到了主线程的消息");
						}
					}
				};
				
				Looper.loop();//调用Looper对象的取消息的方法，一定写在handler创建的后面，是一个死循环，后面的代码无法执行、
				
			}
		}).start();
	}

	public void clickSend(View view) {
		handler.sendEmptyMessage(1);
	}
}
