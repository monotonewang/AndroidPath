package com.androidpath.activity.affragment.fragmentpassvalue122;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.androidpath.R;

import java.util.ArrayList;
import java.util.List;

//根据flag的不同，去下载不同的数据
public class MyFragment extends Fragment {
	List<String> list = null;
	private ListView listView;
	private ArrayAdapter<String> adapter;
	private OnFragmentItemClickListener listener;
	
	public interface OnFragmentItemClickListener{
		void  OnFragmentItemClick(String msg);
	}

	// 1.准备数据
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		// 网络连接（获得url），下载数据，解析
		
		listener = (OnFragmentItemClickListener) activity;

		Bundle bundle = getArguments();
		String urlString = bundle.getString("urlString");
		list = new ArrayList<>();
		if (urlString.equals("www.msg.com")) {
			for (int i = 0; i < 20; i++) {
				list.add("消息" + i);
			}

		}/* else if (urlString.equals("www.contact.com")) {

			for (int i = 0; i < 20; i++) {
				list.add("凤姐" + i);
			}
		}*/

		adapter = new ArrayAdapter<>(activity,
				android.R.layout.simple_list_item_1,
				list);

	}

	// 2.准备视图
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater
				.inflate(R.layout.fragment_layout122, container, false);

		listView = (ListView) view.findViewById(R.id.listView);
		listView.setEmptyView(view.findViewById(R.id.empty_text));
		return view;
	}

	// 3.展示数据到视图中
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		listView.setAdapter(adapter);
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				listener.OnFragmentItemClick(list.get(position));
			}
		});

	}
	
	

}
