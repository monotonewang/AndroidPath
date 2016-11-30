package com.androidpath.project.music.service;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.androidpath.project.music.Entity.SongItemsEntity;
import com.androidpath.project.music.Entity.SongLinkEntity;
import com.androidpath.project.music.parser.JsonParserSongLink;
import com.androidpath.project.music.utils.DownUtils;

import java.util.ArrayList;
import java.util.List;

public class MediaPlayerService extends Service implements DownUtils.OnDownComplete {
	
	private MediaPlayer mediaPlayer;
	private LocalBroadcastManager localBroadcastManager;
	private MusicReceiver musicReceiver;
	private Integer IntPosition=-1;
	private ArrayList<SongItemsEntity> dataList;//歌曲列表
	private Uri uri1;
	public class MusicReceiver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			if(intent.getAction().equals("com.example.day25baidumusictest.fragment.FragmentPlayMusicPosition")){
				IntPosition = intent.getIntExtra("songid1", -1);
			}else if(intent.getAction().equals("com.example.day25baidumusictest.fragment.MediaPlayerServiceChannelList")){
				//获取到频道下的所有歌曲。
				dataList=(ArrayList<SongItemsEntity>) intent.getSerializableExtra("songIdList");
//				Log.e("MediaPlayerService", "dataList="+dataList+"");
			}else if(intent.getAction().equals("com.example.day25baidumusictest.fragment.MediaPlayerServiceUrl")){
				//获取到yishou下的所有歌曲。
				String songUrl = intent.getStringExtra("songURl");
//				Log.e("MediaPlayerService", "songUrl="+songUrl+"");
			}else if(intent.getAction().equals("com.example.day25baidumusictest.fragment.MediaPlayerService.PlayOrStop")){
				if(mediaPlayer!=null){
					if(mediaPlayer.isPlaying()){
						mediaPlayer.pause();
					}else{
						mediaPlayer.start();
					}
				}
			}
		}
	}
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		Log.e("MediaPlayerService", "onCreate");
		/**
		 * 注册Service端的本地广播管理器
		 */
		localBroadcastManager = LocalBroadcastManager.getInstance(this);
		musicReceiver = new MusicReceiver();
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("com.example.day25baidumusictest.fragment.FragmentPlayMusicPosition");
		intentFilter.addAction("com.example.day25baidumusictest.fragment.MediaPlayerServiceChannelList");
		intentFilter.addAction("com.example.day25baidumusictest.fragment.MediaPlayerServiceUrl");
		intentFilter.addAction("com.example.day25baidumusictest.fragment.MediaPlayerService.PlayOrStop");
		localBroadcastManager.registerReceiver(musicReceiver, intentFilter);
		mediaPlayer = new MediaPlayer();
	}
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Log.e("MediaPlayerService", "onBind");
		return null;
	}
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		int index = intent.getIntExtra("songPosition",-1);
		Log.e("MediaPlayerService", "onStartCommand");
//		if(mediaPlayer!=null){
			if(index>=0){
				String songSoureUrl="http://ting.baidu.com/data/music/links?songIds="+dataList.get(index).getSongid();
				DownUtils.dowJSON(songSoureUrl, this);
			}
//		}
		return super.onStartCommand(intent, flags, startId);
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if(mediaPlayer!=null){
			mediaPlayer.release();
		}
		Log.e("MediaPlayerService", "onDestroy");
		localBroadcastManager.unregisterReceiver(musicReceiver);
	}
	@Override
	public void onDownSucc(String url, Object obj) {
		// TODO Auto-generated method stub
		String songJson=(String) obj;
		//得到当前一首歌曲的详细信息
		List<SongLinkEntity> songLinkList = JsonParserSongLink.getJSONByString(songJson);
		String songLinkUrl = songLinkList.get(0).getSongLink();
//		Log.e("songTrueUrl=","songTrueUrl"+songLinkUrl);
		UriToPlayMusic(songLinkUrl);
	}
	public void UriToPlayMusic(String msg){
		uri1=Uri.parse(msg);
		try {
			mediaPlayer.setDataSource(MediaPlayerService.this, uri1);
			mediaPlayer.prepareAsync();
			mediaPlayer.setOnPreparedListener(new OnPreparedListener() {
				@Override
				public void onPrepared(MediaPlayer mp) {
					// TODO Auto-generated method stub
					Log.e("MusicReceiver", "a");
					mp.start();
//					mediaPlayer.start();
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
}
