package com.androidpath.storge.loadimage172;


import android.content.AsyncTaskLoader;
import android.content.Context;
import android.graphics.Bitmap;

import com.androidpath.storge.loadimage172.util.MyHttpUtil;

public class MyDownLoadLoader extends AsyncTaskLoader<Bitmap> {

	private String urlString;

	public MyDownLoadLoader(Context context, String urlString) {
		super(context);
		// TODO Auto-generated constructor stub
		this.urlString = urlString;
	}
	
	@Override
	protected void onStartLoading() {
		// TODO Auto-generated method stub
		super.onStartLoading();
		forceLoad();
	}

	@Override
	public Bitmap loadInBackground() {
		// TODO Auto-generated method stub
		Bitmap bitmap = MyHttpUtil.downLoadImage(urlString);
		
		return bitmap;
	}

}
