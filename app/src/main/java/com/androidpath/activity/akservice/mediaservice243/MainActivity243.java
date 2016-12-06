package com.androidpath.activity.akservice.mediaservice243;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity243 extends BaseActivity implements OnSeekBarChangeListener {

	private SeekBar seekBar;
	private TextView tv;
	
	private LocalBroadcastManager localBroadcastManager;
	private MyReceiver myReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main243);
		
		init();
	}
	
	private void init() {
		seekBar = (SeekBar) findViewById(R.id.seekbar);
		seekBar.setOnSeekBarChangeListener(this);
		
		tv = (TextView) findViewById(R.id.tv_timer);
		
		localBroadcastManager = LocalBroadcastManager.getInstance(this);
		myReceiver = new MyReceiver();
		IntentFilter intent = new IntentFilter();
		intent.addAction("android.action.intent.timer");
		localBroadcastManager.registerReceiver(myReceiver, intent);
	}

	public void play(View v){
		startService(new Intent(this, MediaService243.class));
	}
	
	public void stop(View v){
		stopService(new Intent(this, MediaService243.class));
	}
	
	class MyReceiver extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			if(intent.getAction().equals("android.action.intent.timer")){
				int max = intent.getIntExtra("maxLen", 0);
				int cur = intent.getIntExtra("curLen", 0);
				
				seekBar.setMax(max);
				seekBar.setProgress(cur);
				setTimerString(max, cur);
			}
		}
	}
	
	/**
	 * 设置时间字符串
	 * @param max
	 * @param cur
	 */
	private void setTimerString(int max, int cur){
		Date dateMax = new Date(max);
		Date dateCur = new Date(cur);
		
		SimpleDateFormat simpeDateFormat = new SimpleDateFormat("mm:ss");
		String maxStr = simpeDateFormat.format(dateMax);
		String curStr = simpeDateFormat.format(dateCur);
		tv.setText(curStr + "/" + maxStr);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		localBroadcastManager.unregisterReceiver(myReceiver);
	}

	/**
	 * SeekBar的监听方法
	 */
	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		//拖动过程中，一直回调该方法
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		//当你拖动前，触发该方法
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		//当你拖动停止时，触发该方法
		int pro = seekBar.getProgress();//得到当前SeekBar的进度
		Intent intent = new Intent("android.intent.action.progress");
		intent.putExtra("pro", pro);
		localBroadcastManager.sendBroadcast(intent);
	}
}
