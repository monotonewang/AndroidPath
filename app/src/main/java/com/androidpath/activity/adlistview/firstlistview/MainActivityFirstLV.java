package com.androidpath.activity.adlistview.firstlistview;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;
import com.androidpath.activity.adlistview.firstlistview.adapter.MyBaseAdapter;
import com.androidpath.activity.adlistview.firstlistview.async.MyAsyncTask;
import com.androidpath.activity.adlistview.firstlistview.bean.MyNews;

import java.util.ArrayList;
import java.util.List;

public class MainActivityFirstLV extends BaseActivity {
	private List<MyNews> list;
	private MyBaseAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.e("MainActivityFirstLV", "onCreate");
		setContentView(R.layout.activity_main_f_lv);

		list = new ArrayList<MyNews>();
		ListView listView = (ListView) findViewById(R.id.headLine_news);

		// 新建异步任务
		MyAsyncTask myAsyncTask = new MyAsyncTask();
		// 开启异步任务
		myAsyncTask.execute(NewsUrlPath.getUrlMynes());

		myAsyncTask.SetOnDownLoadCompleteLister(new MyAsyncTask.OnDownLoadCompleteLister() {

			@Override
			public void SetOnDownLoadCompleteLister(List<MyNews> myList) {
				// TODO Auto-generated method stub
				list.addAll(myList);
				adapter.notifyDataSetChanged();
				// Log.i(TAG, list.toString()+"a");
			}
		});

		adapter = new MyBaseAdapter(this, list);

		listView.setAdapter(adapter);
	}
}