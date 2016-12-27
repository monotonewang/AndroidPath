package com.androidpath.project.music.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.androidpath.R;
import com.androidpath.project.music.Entity.PublicListEntity;
import com.androidpath.project.music.adapter.AbsBaseAdapter;
import com.androidpath.project.music.fragment.inter.OnFragmentPublicItemClickListener;
import com.androidpath.project.music.parser.JsonParserPublicMusicItem;
import com.androidpath.project.music.utils.Constants;
import com.androidpath.project.music.utils.DownUtils;

import java.util.ArrayList;
import java.util.List;


public class FragmentPublicListItem extends Fragment implements DownUtils.OnDownComplete, OnItemClickListener {
	
	private List<String> itemString1;
	private View view;
	private GridView gridView;
	private String urlpath;
	private List<PublicListEntity> jsonParser;
	private AbsBaseAdapter<PublicListEntity> absBaseAdapter;
	private OnFragmentPublicItemClickListener listener;
	private String a="http://tingapi.ting.baidu.com/v1/restserver/ting?from=qianqian&version=2.1.0&method=baidu.ting.radio.getChannelSong&format=json&pn=0&rn=10&channelname=";
	private LocalBroadcastManager localBroadcastManager;
	private static Intent intent=new Intent();
	/**
	 * 返回歌曲频道的fragment
	 * @param datas
	 * @return
	 */
	public static FragmentPublicListItem getInstance(String datas){
		FragmentPublicListItem fragmentPublicListItem=new FragmentPublicListItem();
		Bundle bundle=new Bundle();
//		bundle.putString("song", songPath);
		bundle.putString("path", datas);
		fragmentPublicListItem.setArguments(bundle);
		return fragmentPublicListItem;
	}
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		listener=(OnFragmentPublicItemClickListener) activity;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.music_frag_public_music_item, container, false);
		gridView = (GridView) view.findViewById(R.id.public_grid_view);
		localBroadcastManager=LocalBroadcastManager.getInstance(getActivity());
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		intent.setAction("com.example.day25baidumusictest.fragment.FragmentSongListItems");
		
		Bundle bundle = getArguments();
		String string = bundle.getString("path");
		itemString1=new ArrayList<String>();
		if(string.equals("公共频道")){
			urlpath = Constants.URL.MUSIC_ITEM;
			//下载返回一个JsonString
			DownUtils.dowJSON(urlpath, this);
		/*	for (int i = 0; i < 20; i++) {
				itemString1.add("第一页"+i);
			}
			ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, itemString1);
			listView.setAdapter(adapter);*/
		}
		gridView.setOnItemClickListener(this);
	}
	@Override
	public void onDownSucc(String url, Object obj) {
		jsonParser=new ArrayList<PublicListEntity>();
		if(url.endsWith(urlpath)){
		
			String publicItemString=(String) obj;
//			Log.e("FragmentPublicListItem1",publicItemString);
			jsonParser = JsonParserPublicMusicItem.JSONParser(publicItemString);
		/*	for (int i = 0; i < jsonParser.size(); i++) {
				String thumb = jsonParser.get(i).getThumb();
				Log.e("FragmentPublicListItem", ""+thumb);
				String name = jsonParser.get(i).getName();
				Log.e("FragmentPublicListItem", ""+name);
			}*/
//			Log.e("FragmentPublicListItem", jsonParser.toString());
			absBaseAdapter=new AbsBaseAdapter<PublicListEntity>(getActivity(), R.layout.music_frag_public_music_item_listview1) {

				@Override
				public void bindDatas(ViewHolder viewHolder,PublicListEntity data) {
					viewHolder.bindCacheImageView(R.id.iv, data.getThumb());
					viewHolder.bindTextView(R.id.textView, data.getName());
				}
			};
//			absBaseAdapter=new PublicItemAdapter(getActivity(), R.layout.frag_public_music_item_listview1);
			gridView.setAdapter(absBaseAdapter);
			absBaseAdapter.setDatas(jsonParser);
			
		}
			/*	Log.e("FragmentPublicListItem",publicItemString);
			
			
//			List<PublicListEntity> itemEntity=new ArrayList<PublicListEntity>();
		}*/
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		String songPath = a+jsonParser.get(position).getCh_name();
		listener.OnFragmentPublicItemClick( a+jsonParser.get(position).getCh_name(),position);
		
		
		Log.e("onItemClick", songPath);
		intent.putExtra("songlist", songPath);
//		localBroadcastManager.sendBroadcast(intent);
		localBroadcastManager.sendBroadcastSync(intent);
		/*Intent intent =new Intent(getActivity(), FragmentSongListItems.class);
		intent.putExtra("SongList", a+jsonParser.get(position).getCh_name());*/
//		startActivity(intent);
	}
}
