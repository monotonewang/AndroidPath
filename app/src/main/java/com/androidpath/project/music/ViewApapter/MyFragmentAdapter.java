package com.androidpath.project.music.ViewApapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.androidpath.project.music.fragment.FragmentPlayMusic;
import com.androidpath.project.music.fragment.FragmentPublicListItem;
import com.androidpath.project.music.fragment.FragmentSongListItems;
import com.androidpath.project.music.fragment.MyFragment;


public class MyFragmentAdapter extends FragmentPagerAdapter {

	private String[] datas;
	
	public MyFragmentAdapter(FragmentManager fm,String[] datas) {
		super(fm);
		this.datas=datas;
	}

	@Override
	public Fragment getItem(int arg0) {
		if(arg0==0){
			return FragmentPublicListItem.getInstance(datas[0]);
		}else if(arg0==2) {
//			Log.e("Adapter", datas[2]);
			return FragmentSongListItems.getInstance(datas[2]);
		}else if(arg0==3) {
//			Log.e("Adapter", datas[2]);
			return FragmentPlayMusic.getInstance(datas[3]);
		}
		else{
			return MyFragment.getInstance(datas[arg0]);
		}
	}

	@Override
	public int getCount() {
		return datas.length;
	}

}
