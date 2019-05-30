package com.androidpath.project.music.fragment;

import android.os.Bundle;
import androidx.fragment.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyFragment extends ListFragment {
	private List<String> thing;
	public static MyFragment getInstance(String datas){
		MyFragment myFragment=new MyFragment();
		Bundle bundle=new Bundle();
		bundle.putString("path", datas);
		myFragment.setArguments(bundle);
		return myFragment;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		thing=new ArrayList<String>();
		Bundle bundle = getArguments();
		String string = bundle.getString("path");
		for (int i = 0; i < 20; i++) {
//			TextView tv=new TextView(getActivity());
			thing.add(string+i);
		}
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, thing);
		setListAdapter(adapter);
	}
}
