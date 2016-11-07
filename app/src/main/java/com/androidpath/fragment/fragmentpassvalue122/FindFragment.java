package com.androidpath.fragment.fragmentpassvalue122;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.androidpath.R;

import java.util.ArrayList;

public class FindFragment extends ListFragment {
	private ArrayList<String> list;
	private ArrayAdapter<String> adapter;

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);

		list = new ArrayList<>();
		list.add("美食");
		list.add("附近");
		list.add("摇一摇");
		list.add("扫一扫");
		list.add("发红包");

		adapter = new ArrayAdapter<>(activity,
				android.R.layout.simple_list_item_1, list);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.find_fragment_layout122, container,
				false);
		return view;
		// return super.onCreateView(inflater, container, savedInstanceState);
	}

	// 绑定数据
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		// 如果数据集合中没有数据就显示"暂无发现",如果使用的是自定义布局，这句话就不要
		// setEmptyText("暂无发现");

		setListAdapter(adapter);
	}

	// 列表条被点击的时候回调
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Toast.makeText(getActivity(), "选中了" + list.get(position),
				Toast.LENGTH_SHORT).show();
	}
	
}
