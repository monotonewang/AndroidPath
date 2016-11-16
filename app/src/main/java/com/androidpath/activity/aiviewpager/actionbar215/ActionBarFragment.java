package com.androidpath.activity.aiviewpager.actionbar215;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class ActionBarFragment extends ListFragment {

	public static Fragment getInstance(String str){
		ActionBarFragment actionBarFragment = new ActionBarFragment();
		Bundle bundle = new Bundle();
		bundle.putString("data", str);
		actionBarFragment.setArguments(bundle);
		return actionBarFragment;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Bundle bundle = getArguments();
		String str = bundle.getString("data");
		List<String> datas = new ArrayList();
		for(int i = 0; i < 20; i++){
			datas.add(str + "-->" + i);
		}
		
		ArrayAdapter<String> arrayAdapter = 
				new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, datas);
		setListAdapter(arrayAdapter);
	}
}
