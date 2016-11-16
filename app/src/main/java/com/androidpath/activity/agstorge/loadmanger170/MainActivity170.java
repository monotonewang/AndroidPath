package com.androidpath.activity.agstorge.loadmanger170;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

//泛型代表的是：loader加载的数据的类型
public class MainActivity170 extends ListActivity implements LoaderCallbacks<List<String>> {

	private ArrayAdapter<String> adapter;
	private List<String> list = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
				list);
		setListAdapter(adapter);

		
		//开启Loader，异步加载数据
		LoaderManager loaderManager = getLoaderManager();
		loaderManager.initLoader(1, null, this);
	}

	@Override
	public Loader<List<String>> onCreateLoader(int id, Bundle args) {
		// TODO Auto-generated method stub
		//创建并返回一个loader对象，
		//1.定义类继承AsynctaskLoader
		MyLoader loader = new MyLoader(this);
		Log.e("LoaderCallbacks","onCreateLoader....");
		return loader;
	}

	@Override
	public void onLoadFinished(Loader<List<String>> loader, List<String> list) {
		// TODO Auto-generated method stub
		Log.e("LoaderCallbacks","onLoadFinished....");
		
		this.list.clear();
		this.list.addAll(list);
		
		//通知数据改变
		adapter.notifyDataSetChanged();
	}

	@Override
	public void onLoaderReset(Loader<List<String>> loader) {
		// TODO Auto-generated method stub
		this.list.clear();
	}
}
