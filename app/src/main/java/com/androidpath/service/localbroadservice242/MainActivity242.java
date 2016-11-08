package com.androidpath.service.localbroadservice242;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.TextView;

import com.androidpath.R;

public class MainActivity242 extends Activity {

	private TextView tv;
	private LocalBroadcastManager localBroadcastManager;
	private MyReceiver myReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main242);
		
		tv = (TextView) findViewById(R.id.tv);
		
		localBroadcastManager = LocalBroadcastManager.getInstance(this);
		myReceiver = new MyReceiver();
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("android.action.intent.timer");
		localBroadcastManager.registerReceiver(myReceiver, intentFilter);
	}
	
	public void start(View v){
		startService(new Intent(this, TimerSerivce.class));
	}
	
	public void reset(View v){
		stopService(new Intent(this, TimerSerivce.class));
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		localBroadcastManager.unregisterReceiver(myReceiver);
	}
	
	class MyReceiver extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			int count = intent.getIntExtra("count", -1);
			tv.setText("" + count);
		}
	}

}
