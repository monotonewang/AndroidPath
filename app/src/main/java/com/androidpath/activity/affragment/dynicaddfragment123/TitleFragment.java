package com.androidpath.activity.affragment.dynicaddfragment123;

import android.app.Fragment;
import android.os.Bundle;
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
		View view = inflater.inflate(R.layout.title_fragment_layout123,//要加载的布局id
				container,//加载出来的布局要装入的父容器
				false);//填false代表直接将加载出来的布局对象加入参数二指定的父容器，填true的话还会在加载出来的布局对象的外层再加一层布局
		
		
		return view;
	}
}
