package com.androidpath.project.music.fragment;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.project.music.Entity.SongLinkEntity;
import com.androidpath.project.music.adapter.AbsBaseAdapter;
import com.androidpath.project.music.custem.CacheImageView;
import com.androidpath.project.music.parser.JsonParserSongLink;
import com.androidpath.project.music.utils.DownUtils;

import java.util.List;


public class FragmentPlayMusic extends Fragment implements OnClickListener {
	
	private LocalBroadcastManager localBroadcastManager;
	private LocalBroadcastManager localBroadcastManagerSongServie;
	private LocalBroadcastManager localBroadcastManagerSongPlayOrStop;
	private MyReceiverSongId myReceiverSongId;
	private AbsBaseAdapter<SongLinkEntity> absBaseAdapter;
	private View view;
	private SeekBar seekBar;
	
	public static Fragment getInstance(String str){
		FragmentPlayMusic fragmentPlayMusic=new FragmentPlayMusic();
		Bundle str1=new Bundle();
		str1.putString("path", str);
		fragmentPlayMusic.setArguments(str1);
		return fragmentPlayMusic;
	}
	/**
	 * 广播接收着，得到fragment返回的歌曲URl;
	 * @author user
	 *
	 */
	public class MyReceiverSongId extends BroadcastReceiver implements DownUtils.OnDownComplete {

		@Override
		public void onReceive(Context context, Intent intent) {
			//拿到歌曲的下载url
			String SongLibkUrl= intent.getStringExtra("songid");
			Log.d("FragmentPlayMusic", "songurl="+SongLibkUrl+"");
			DownUtils.dowJSON(SongLibkUrl,this);
		}

		@Override
		public void onDownSucc(String url, Object obj) {
			String songJson=(String) obj;
			Log.e("one song info", url);
			//得到当前一首歌曲的详细信息
			List<SongLinkEntity> songLinkList = JsonParserSongLink.getJSONByString(songJson);
			Log.e("FragmentPlayMusic", songLinkList.toString());
			
			//将得到的歌曲信息展示到ui上
			CacheImageView imageView=(CacheImageView) view.findViewById(R.id.songPicBig);
			TextView textView1 =(TextView) view.findViewById(R.id.songName);
			TextView textView2 =(TextView) view.findViewById(R.id.artistName);
			TextView textView3 =(TextView) view.findViewById(R.id.albimName);
			String songLinkImageUrl = songLinkList.get(0).getSongPicBig();
			if(songLinkImageUrl!=null){
				imageView.setUrl(songLinkImageUrl);
			}
			textView1.setText(songLinkList.get(0).getSongName());
			textView2.setText(songLinkList.get(0).getArtistName());
			textView3.setText(songLinkList.get(0).getAlbimName());
			//得到歌曲的url，准备开始到Service
			String songLinkUrl = songLinkList.get(0).getSongLink();
			
			Intent intent=new Intent();
			intent.setAction("com.example.day25baidumusictest.fragment.MediaPlayerServiceUrl");
			intent.putExtra("songURl", songLinkUrl);
//			Log.e("MusicReceiver",songLinkUrl+ "");
			localBroadcastManagerSongServie.sendBroadcast(intent);
		}

	}
	@Override
	public void onClick(View v) {

		Intent intent=new Intent();
		intent.setAction("com.example.day25baidumusictest.fragment.MediaPlayerService.PlayOrStop");
		localBroadcastManagerSongPlayOrStop.sendBroadcast(intent);
	}
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		//得到当前用户点击歌曲的url
		localBroadcastManager=LocalBroadcastManager.getInstance(getActivity());
		IntentFilter intent =new IntentFilter();
		intent.addAction("com.example.day25baidumusictest.fragment.FragmentPlayMusicNow");
		myReceiverSongId = new MyReceiverSongId();
		localBroadcastManager.registerReceiver(myReceiverSongId, intent);
		
		
		localBroadcastManagerSongServie=LocalBroadcastManager.getInstance(getActivity());
		localBroadcastManagerSongPlayOrStop=LocalBroadcastManager.getInstance(getActivity());
		
		
	}
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = LayoutInflater.from(getActivity()).inflate(R.layout.music_single_song_more, container, false);
		Button button =(Button) view.findViewById(R.id.BtnMusicPlayer);
		button.setOnClickListener(this);
		seekBar = (SeekBar) view.findViewById(R.id.progressMusic);
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		localBroadcastManager.unregisterReceiver(myReceiverSongId);
	}
	
}
