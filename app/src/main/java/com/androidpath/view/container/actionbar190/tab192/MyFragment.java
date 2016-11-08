package com.androidpath.view.container.actionbar190.tab192;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class MyFragment extends Fragment {
	
	
	private String title;
	private int color;

	@SuppressLint("ValidFragment")
	public MyFragment(String title, int color) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.color = color;
	}

	
	//创建fragment的视图
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		LinearLayout layout = new LinearLayout(getActivity());
		//设置布局的宽高属性
		LayoutParams params = new LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		layout.setLayoutParams(params );
		
		layout.setBackgroundColor(color);
		
		
		TextView textView = new TextView(getActivity());
		textView.setText(title);
		
		//将textview加入容器
		layout.addView(textView);
		
		
		return layout;
	}
}
