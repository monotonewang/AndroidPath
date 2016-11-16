package com.androidpath.service.mediaservice246.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.RemoteViews;

import com.androidpath.R;
import com.androidpath.activity.aabase.MainActivity;
import com.androidpath.service.mediaservice246.modle.MusicEntity;
import com.androidpath.service.mediaservice246.util.Constants;

import java.util.ArrayList;

public class MediaService246 extends Service {

	private LocalBroadcastManager localBroadcastManager;
	private MusicReceiver musicReceiver;
	
	private NotifyReceiver notifyReceiver;
	
	private ArrayList<MusicEntity> dataList;//歌曲列表
	private int index;//当前播放的歌曲下标
	
	private MediaPlayer mediaPlayer;
	
	/**
	 * 通知管理器
	 */
	private NotificationManager notificationManager;
	private Notification notification;
	private RemoteViews remoteViews;
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		/**
		 * 注册Service端的本地广播管理器
		 */
		localBroadcastManager = LocalBroadcastManager.getInstance(this);
		musicReceiver = new MusicReceiver();
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction(Constants.ACTION.MUSIC_LIST);
		localBroadcastManager.registerReceiver(musicReceiver, intentFilter);
		
		/**
		 * 注册全局广播接收者
		 */
		notifyReceiver = new NotifyReceiver();
		IntentFilter intentFilter2 = new IntentFilter();
		intentFilter2.addAction(Constants.ACTION.NOTIFICATION_PLAY);
		intentFilter2.addAction(Constants.ACTION.NOTIFICATION_ABOVE);
		intentFilter2.addAction(Constants.ACTION.NOTIFICATION_NEXT);
		registerReceiver(notifyReceiver, intentFilter2);
		
		/**
		 * 初始化音乐播放器
		 */
		mediaPlayer = new MediaPlayer();
		
		/**
		 * 初始化通知管理器
		 */
		notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
		remoteViews = new RemoteViews(getPackageName(), R.layout.notification_layout243);
		//通过RemoteViews给布局中的按钮设置点击事件
		Intent playintent = new Intent(Constants.ACTION.NOTIFICATION_PLAY);
		PendingIntent playpendingIntent = PendingIntent.getBroadcast(this, 0, playintent, 0);
		remoteViews.setOnClickPendingIntent(R.id.btn_play, playpendingIntent);
		
		//通知RemoteViews给布局中的上一曲按钮添加点击事件
		Intent aboveintent = new Intent(Constants.ACTION.NOTIFICATION_ABOVE);
		PendingIntent abovependingIntent = PendingIntent.getBroadcast(this, 0, aboveintent, 0);
		remoteViews.setOnClickPendingIntent(R.id.btn_above, abovependingIntent);
		
		//通知RemoteViews给布局中的上一曲按钮添加点击事件
		Intent nextintent = new Intent(Constants.ACTION.NOTIFICATION_NEXT);
		PendingIntent nextpendingIntent = PendingIntent.getBroadcast(this, 0, nextintent, 0);
		remoteViews.setOnClickPendingIntent(R.id.btn_next, nextpendingIntent);
		
		//定义一个点击Notification的延迟意图
		Intent intent = new Intent(this, MainActivity.class);
		PendingIntent clickPendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
		notification = new NotificationCompat.Builder(this)
						.setSmallIcon(R.drawable.ic_launcher)
						.setContent(remoteViews)//设置通知自定义布局
						.setContentIntent(clickPendingIntent)
						.setOngoing(true)//让通知不能被手动移除
						.build();
		//弹出通知
		notificationManager.notify(Constants.ID.NOTIFICATION_ID, notification);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		index = intent.getIntExtra(Constants.KEY.PLAY_MUSIC_POSITION, -1);
		if(index != -1){
			//开始播放
			reStart();
		}
		return super.onStartCommand(intent, flags, startId);
	}
	
	/**
	 * 播放歌曲
	 * 
	 * mediaPlayer.prepareAsync();
				mediaPlayer.setOnPreparedListener(new OnPreparedListener() {
					
					@Override
					public void onPrepared(MediaPlayer mp) {
						mediaPlayer.start		
					}
				});
	 */
	private void reStart(){
		if(mediaPlayer != null){
			mediaPlayer.reset();
			try {
				mediaPlayer.setDataSource(dataList.get(index).getPath());
				mediaPlayer.prepare();
				mediaPlayer.start();
				
				//获得需要播放的歌曲名称
				String musicName = dataList.get(index).getName();
				if(remoteViews != null){
					//更新notification上的歌曲名称
					remoteViews.setTextViewText(R.id.tv_musicname, musicName);
					notificationManager.notify(Constants.ID.NOTIFICATION_ID, notification);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		if(musicReceiver != null){
			localBroadcastManager.unregisterReceiver(musicReceiver);
		}
	}
	
	/**
	 * 本地广播接收者 -- 接收activity的数据
	 * @author Ken
	 *
	 */
	public class MusicReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			if(intent.getAction() == Constants.ACTION.MUSIC_LIST){
				//接收音乐播放列表
				dataList = (ArrayList<MusicEntity>) intent.getSerializableExtra(Constants.KEY.MUSIC_LIST_KEY);
			}
		}
	}
	
	/**
	 * 全局广播接收者 -- 用于接收Notification的操作信号
	 */
	public class NotifyReceiver extends BroadcastReceiver{
		@Override
		public void onReceive(Context context, Intent intent) {
			if(intent.getAction()==Constants.ACTION.NOTIFICATION_PLAY){
				//表示通过通知，发过来播放/暂停的信号
				if(mediaPlayer != null){
					if(mediaPlayer.isPlaying()){
						mediaPlayer.pause();
					} else {
						mediaPlayer.start();
					}
				}
			} else if(intent.getAction()==Constants.ACTION.NOTIFICATION_ABOVE){
				//上一曲
				if(index == 0){
					index = dataList.size() - 1;
				} else {
					index--;
				}
				reStart();
			} else if(intent.getAction()==Constants.ACTION.NOTIFICATION_NEXT){
				//下一曲
				if(index == dataList.size() - 1){
					index = 0;
				} else {
					index++;
				}
				reStart();
			}
		}
	}
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}
