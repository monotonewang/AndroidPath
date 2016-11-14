package com.androidpath.view.listview.firstlistview.async;


import android.os.AsyncTask;

import com.androidpath.view.listview.firstlistview.bean.MyNews;
import com.androidpath.view.listview.firstlistview.parser.MyJsonParser;
import com.androidpath.view.listview.firstlistview.utils.MyHttpUtils;

import java.util.List;

public class MyAsyncTask extends AsyncTask<String, Void, List<MyNews>> {
	// private final String TAG="MyAsyncTask";
	private OnDownLoadCompleteLister OnDownLoadCompleteLister;

	@Override
	protected List<MyNews> doInBackground(String... params) {
		// TODO Auto-generated method stub
		String Urlpath = params[0];
		String jsonString = MyHttpUtils.downLoadstring(Urlpath);
		// Log.i(TAG, jsonString+"aaa");
		List<MyNews> list = MyJsonParser.parserNews(jsonString);
		// Log.i(TAG, list.toString()+"aaa");
		return list;
	}

	@Override
	protected void onPostExecute(List<MyNews> result) {
		// TODO Auto-generated method stub
		OnDownLoadCompleteLister.SetOnDownLoadCompleteLister(result);
		super.onPostExecute(result);
	}

	// 下面定义一个接口回调上
	public interface OnDownLoadCompleteLister {
		// 定义一个方法，参数填写要传递的对象.
		void SetOnDownLoadCompleteLister(List<MyNews> myList);
	}

	public void SetOnDownLoadCompleteLister(OnDownLoadCompleteLister myList) {
		this.OnDownLoadCompleteLister = myList;
	}
}
