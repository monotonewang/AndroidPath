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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.androidpath.R;
import com.androidpath.project.music.Entity.SongItemsEntity;
import com.androidpath.project.music.adapter.AbsBaseAdapter;
import com.androidpath.project.music.fragment.inter.OnFragmentSongClickListener;
import com.androidpath.project.music.parser.JsonParserSongItems;
import com.androidpath.project.music.service.MediaPlayerService;
import com.androidpath.project.music.utils.DownUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * 一个频道下的所有歌曲列表
 * @author user
 *
 */
public class FragmentSongListItems extends Fragment implements OnItemClickListener {
	private OnFragmentSongClickListener listener;
	//注册广播 接受频道下所有的歌曲list
	private LocalBroadcastManager localBroadcastManager;
	//发送广播 发送歌曲的 position 位置
	private LocalBroadcastManager localBroadcastManager1;
	//发送歌曲的channel的list
	private LocalBroadcastManager localBroadcastManager2;
	//发送当前歌曲的url到播放界面显示出来
	private LocalBroadcastManager localBroadcastManager3;
	private MyReceiver myReceiver;
	private ListView view2;
	private AbsBaseAdapter<SongItemsEntity> absBaseAdapter;
	private static String stringExtra;
	private List<SongItemsEntity> jsonByString;
	private ArrayList<SongItemsEntity> jsonSongIdList;
	
	public static Fragment getInstance(String str){
		FragmentSongListItems fragmentSongListItems=new FragmentSongListItems();
		Bundle str1=new Bundle();
		str1.putString("path", str);
		fragmentSongListItems.setArguments(str1);
		return fragmentSongListItems;
	}
	
//			"http://tingapi.ting.baidu.com/v1/restserver/ting?from=qianqian&version=2.1.0&method=baidu.ting.radio.getChannelSong&format=json&pn=0&rn=10&channelname=public_tuijian_spring";
	public class MyReceiver extends BroadcastReceiver implements DownUtils.OnDownComplete {
		
		@Override
		public void onReceive(Context context, Intent intent) {
			if (intent.getAction().equals("com.example.day25baidumusictest.fragment.FragmentSongListItems")) {
				stringExtra = intent.getStringExtra("songlist");
				if (stringExtra != null) {
//					Log.e("FragmentSongListItems1", stringExtra + "");
					DownUtils.dowJSON(stringExtra,this);
				} else {
					Log.e("FragmentSongListItems1", "no data");
				}
			}
		}
		@Override
		public void onDownSucc(String url, Object obj) {
//			Log.e("FragmentSongListItems1", url + "");
			if(url.equals(stringExtra)){
				String json=(String) obj;
				jsonByString = JsonParserSongItems.getJSONByString(json);
				jsonSongIdList=(ArrayList<SongItemsEntity>) jsonByString;
			/*	Log.e("onDownSuccString",json+ "");*/
//				Log.e("onDownSuccList",jsonByString+ "");
				//传递频道下所有歌曲的信息，（include song  id）到Service
				
				Intent intent =new Intent();
				intent.putExtra("songIdList", jsonSongIdList);
				intent.setAction("com.example.day25baidumusictest.fragment.MediaPlayerServiceChannelList");
				localBroadcastManager2.sendBroadcast(intent);
				
				absBaseAdapter=new AbsBaseAdapter<SongItemsEntity>(getActivity(), R.layout.music_song_list_more) {

					@Override
					public void bindDatas(ViewHolder viewHolder,SongItemsEntity data) {
						if(data.getThumb()!=null&&data.getArtist()!=null&&data.getSongid()!=null){
							viewHolder.bindCacheImageView(R.id.songIv,data.getThumb());
							viewHolder.bindTextView(R.id.songTitle, data.getTitle());
							viewHolder.bindTextView(R.id.songArtist, data.getArtist());
						} 
					}
				};
//				absBaseAdapter=new PublicItemAdapter(getActivity(), R.layout.frag_public_music_item_listview1);
				view2.setAdapter(absBaseAdapter);
				absBaseAdapter.setDatas(jsonByString);
			}else{
				Log.e("onDownSucc","url is wrong");
			}
		}
	}


	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener=(OnFragmentSongClickListener) activity;
		localBroadcastManager = LocalBroadcastManager.getInstance(getActivity());
		localBroadcastManager1=LocalBroadcastManager.getInstance(getActivity());
		localBroadcastManager2=LocalBroadcastManager.getInstance(getActivity());
		localBroadcastManager3=LocalBroadcastManager.getInstance(getActivity());
		myReceiver = new MyReceiver();
		IntentFilter intentFilter=new IntentFilter();
		intentFilter.addAction("com.example.day25baidumusictest.fragment.FragmentSongListItems");
		localBroadcastManager.registerReceiver(myReceiver, intentFilter);
//		Log.e("FragmentSongListItemsAttach", stringExtra+"");
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.music_frag_song_items, container, false);
		view2 = (ListView) view.findViewById(R.id.song_item_list);
		view2.setOnItemClickListener(this);
		
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
//		Log.e("FragmentSongListItems3", stringExtra+"");
			
//		Log.e("onActivityCreated", stringExtra);
		/*if(stringExtra!=null){
			DownUtils.dowJSON(stringExtra,this);
			Log.e("FragmentSongListItems","stringExtra="+stringExtra+ "");
		}else{
			Log.e("Fragment", "StringExtra no data");
		}*/
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		localBroadcastManager.unregisterReceiver(myReceiver);
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {

		listener.OnFragmentSongItemClick(position);
		
		//把点击的position传递到Service
		Intent intent=new Intent();
		intent.setAction("com.example.day25baidumusictest.fragment.FragmentPlayMusicPosition");
		intent.putExtra("songid1", position);
//		Log.e("position", position+"");
		localBroadcastManager1.sendBroadcast(intent);

		//传递歌曲的url
		String songSoureUrl="http://ting.baidu.com/data/music/links?songIds="+jsonByString.get(position).getSongid();
		Intent intent2=new Intent();
		intent2.setAction("com.example.day25baidumusictest.fragment.FragmentPlayMusicNow");
//		Log.e("songSoureUrl=", "a"+songSoureUrl);
		intent2.putExtra("songid", songSoureUrl);
		localBroadcastManager3.sendBroadcast(intent2);
		
		Intent intent3 = new Intent(getActivity(), MediaPlayerService.class);
		intent3.putExtra("songPosition", position);
		getActivity().startService(intent3);
	}
}
