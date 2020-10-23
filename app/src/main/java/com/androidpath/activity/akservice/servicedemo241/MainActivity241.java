package com.androidpath.activity.akservice.servicedemo241;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

/**
 * 认识Service：
 * 没有UI界面，并且长期运行与后台，所处的进程，我们通常叫做“服务进程”，类似于一个没有界面的Activity
 * 主要的功能：是用来实现一些长期处于后台工作的控件，比如媒体播放器，定时器等
 * 
 * StartService的三个核心：
 * onCreate()
 * onStartCommand()
 * onDestory()
 * 
 * 特点:
 * 用startService的方式启动的服务，与activity之间没有绑定关系，activity退出后，服务仍然在执行
 * 
 * 注意:启动有一个onBind()方法必须重写，该方法是用于bindService时使用的，StartService时无需实现
 * 
 * 具体步骤:
 * 1、声明一个Service的子类，重写onBind()方法
 * 2、在onCreate方法中，进行一个初始化操作，在onStartCommand()方法中进行一些核心的操作
 * 3、在配置清单文件中，注册该服务
 * 4、启动和停止服务
 *     停止服务：stopService
 *           在service内部调用stopSelf //停止自己
 * @author Ken
 *
 */
public class MainActivity241 extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx onCreate MainActivity241");
		setContentView(R.layout.activity_main241);
		findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("xxxxxxxxxxxxxxxxxxxxxxx onClick start");
				Intent intent = new Intent(MainActivity241.this, StartService.class);
				intent.putExtra("name","weiwei");
				startService(intent);
			}
		});
		findViewById(R.id.stop).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity241.this, StartService.class);
				stopService(intent);
			}
		});
	}
	

}
