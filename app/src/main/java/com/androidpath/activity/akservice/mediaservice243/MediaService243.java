package com.androidpath.activity.akservice.mediaservice243;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.IBinder;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import com.androidpath.R;

import java.util.Timer;
import java.util.TimerTask;

public class MediaService243 extends Service{
	
	private LocalBroadcastManager localBroadcastManager;
	private ServiceReceiver serviceReceiver;
	
	private MediaPlayer mediaPlayer;
	private Timer timer;
	
	private int maxLen;
	private int curLen;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		/**
		 * 通过静态方法创建的MediaPlayer对象，会直接进入就绪状态
		 */
		mediaPlayer = MediaPlayer.create(this, R.raw.zmtlr);
		
		localBroadcastManager = LocalBroadcastManager.getInstance(this);
		serviceReceiver = new ServiceReceiver();
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("android.intent.action.progress");
		localBroadcastManager.registerReceiver(serviceReceiver, intentFilter);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if(mediaPlayer != null && mediaPlayer.isPlaying()){
			mediaPlayer.pause();
		} else {
			mediaPlayer.start();
			
			timer();
		}
		return super.onStartCommand(intent, flags, startId);
	}
	
	/**
	 * 定时器方法 -- 用于实时给activity传输播放进度
	 */
	private void timer(){
		if(timer == null){
			timer = new Timer();
			timer.schedule(new TimerTask() {
				@Override
				public void run() {
					try {
						if(mediaPlayer != null && mediaPlayer.isPlaying()){
							//得到歌曲的总时长 和 当前播放进度
							maxLen = mediaPlayer.getDuration();//得到歌曲的总时长
							curLen = mediaPlayer.getCurrentPosition();//得到当前的播放进度
							
							Intent intent = new Intent("android.action.intent.timer");
							intent.putExtra("maxLen", maxLen);
							intent.putExtra("curLen", curLen);
							localBroadcastManager.sendBroadcast(intent);
						} else {
							timer.cancel();
							timer = null;
						}
					} catch (Exception e) {
						e.printStackTrace();
						timer.cancel();
						timer = null;
					}
				}
			}, 0, 500);
		}
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		if(mediaPlayer != null){
			//销毁 回收资源
			mediaPlayer.release();
		}
		
		if(serviceReceiver != null){
			localBroadcastManager.unregisterReceiver(serviceReceiver);
		}
	}
	
	class ServiceReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			if(intent.getAction().equals("android.intent.action.progress")){
				int pro = intent.getIntExtra("pro", 0);//得到拖放的进度
				mediaPlayer.seekTo(pro);
			}
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}
