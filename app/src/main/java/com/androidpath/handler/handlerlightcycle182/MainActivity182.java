package com.androidpath.handler.handlerlightcycle182;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;

import com.androidpath.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity182 extends Activity {

	private RelativeLayout rootLayout;
	View[] views;
	List<Integer> list;
	private Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main182);
		rootLayout = (RelativeLayout) findViewById(R.id.root_layout);
		
		initDataAndView();
		
		//循环更换每一个控件的颜色
		handler = new Handler();
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < views.length; i++) {
					views[i].setBackgroundColor(list.get(i));
				}
				
				//移动颜色的位置
				Collections.rotate(list, -1);
				//再次执行设置颜色
				handler.postDelayed(this, 500);
				
			}
		}, 500);
		
	}

	private void initDataAndView() {
		int size = rootLayout.getChildCount();
		views = new View[size-1];//用于保存所有的button控件,不包含imageview
		
		for (int i = 0; i < views.length; i++) {
			views[i] = rootLayout.getChildAt(i);
		}
		
		list = new ArrayList<>();
		list.add(0xffff0000);//颜色值一定是一个八位十六进制数
		list.add(0xff00ff00);
		list.add(0xff0000ff);
		list.add(0xffffff00);
	}
	
	
}
