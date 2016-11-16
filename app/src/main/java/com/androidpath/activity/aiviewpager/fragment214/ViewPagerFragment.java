package com.androidpath.activity.aiviewpager.fragment214;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.androidpath.R;

import java.util.ArrayList;

public class ViewPagerFragment extends Fragment {

	private ListView lv;
	private ArrayAdapter<String> adapter;
	
	/**
	 * 静态工厂方法
	 * @param datas
	 * @return
	 */
	public static Fragment getInstance(ArrayList<String> datas){
		ViewPagerFragment fragment = new ViewPagerFragment();
		Bundle bundle = new Bundle();
		bundle.putSerializable("data", datas);
		fragment.setArguments(bundle);
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_conts214, container, false);
		initView(view);
		return view;
	}
	
	/**
	 * 初始化控件
	 * @param view
	 */
	private void initView(View view) {
		lv = (ListView) view.findViewById(R.id.lv_id);
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Bundle bundle = getArguments();
		ArrayList<String> datas = (ArrayList<String>) bundle.getSerializable("data");
		adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, datas);
		lv.setAdapter(adapter);
	}
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		Log.d("print", "---->fragment销毁视图");
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("print", "---->fragment销毁");
	}
	
}
