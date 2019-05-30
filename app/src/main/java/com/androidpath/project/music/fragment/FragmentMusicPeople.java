package com.androidpath.project.music.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

public class FragmentMusicPeople extends Fragment {
	public static FragmentMusicPeople getInstance(String datas){
		FragmentMusicPeople fragmentMusicPeople=new FragmentMusicPeople();
		Bundle bundle=new Bundle();
		bundle.putString("path", datas);
		fragmentMusicPeople.setArguments(bundle);
		return fragmentMusicPeople;
	}
}
