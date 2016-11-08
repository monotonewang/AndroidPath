package com.androidpath.storge.loadmanger170;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

//泛型代表的是Loader加载的数据的类型
public class MyLoader extends AsyncTaskLoader<List<String>> {

	
	public MyLoader(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		Log.e("MyLoader","构造方法....");
	}
	
	//必须重写的方法：
	@Override
	protected void onStartLoading() {
		// TODO Auto-generated method stub
		super.onStartLoading();
		Log.e("MyLoader","onStartLoading....");
		//这个方法必须调用，功能是让下一个方法loadInBackground继续执行
		forceLoad();
	}

	//这个方法运行在子线程上，用于执行耗时操作，线程任务执行完成后，返回需要的数据----数据是返回到deliverResult的参数中
	@Override
	public List<String> loadInBackground() {
		//连接网络下载数据，解析数据。
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			list.add("要下课了！"+i);
		}
		
		Log.e("MyLoader","loadInBackground....");
		return list;
	}
	
	//
	@Override
	public void deliverResult(List<String> data) {
		// TODO Auto-generated method stub
		super.deliverResult(data);
		Log.e("MyLoader","deliverResult....");
	}

}
