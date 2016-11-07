package com.androidpath.fragment.staticfragment121;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidpath.R;

public class TitleFragment extends Fragment {

	//在系统需要将fragment加入到activity中时才会创建fragment对象，创建fragment对象的时候回调onCreateView
	//返回值就是fragment的布局对象，
	//参数一：系统提供的布局加载器对象
	//参数二：是activity要装入fragment对象的容器对象
	//参数三：是现场保护的时候保存的数据
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		//加载fragement布局
//		inflater.inflate(resource, root)
		View view = inflater.inflate(R.layout.title_fragment_layout121,//要加载的布局id
				container,//加载出来的布局要装入的父容器
				false);//填false代表直接将加载出来的布局对象加入参数二指定的父容器，填true的话还会在加载出来的布局对象的外层再加一层布局
		
		Log.d("TitleFragment", "onCreateView.....");
		return view;
	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		Log.d("TitleFragment", "onAttach.....");
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.d("TitleFragment", "onCreate.....");
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		Log.d("TitleFragment", "onActivityCreated.....");
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.d("TitleFragment", "onStart.....");
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d("TitleFragment", "onResume.....");
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.d("TitleFragment", "onPause.....");
	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.d("TitleFragment", "onStop.....");
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		Log.d("TitleFragment", "onDestroyView.....");
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("TitleFragment", "onDestroy.....");
	}
	
	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
		Log.d("TitleFragment", "onDetach.....");
	}
	
	
}
