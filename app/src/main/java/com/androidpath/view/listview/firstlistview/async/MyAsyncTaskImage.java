package com.androidpath.view.listview.firstlistview.async;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;

import com.androidpath.view.listview.firstlistview.utils.MyHttpUtils;


public class MyAsyncTaskImage extends AsyncTask<String, Void, Bitmap> {
	private ImageView newImage;
	private String urlPathString;

	public MyAsyncTaskImage(ImageView newImage) {
		// TODO Auto-generated constructor stub
		this.newImage = newImage;
	}

	@Override
	protected Bitmap doInBackground(String... params) {
		// TODO Auto-generated method stub
		urlPathString = params[0];
		Bitmap bitmap = MyHttpUtils.downLoadBitmap(urlPathString);
		return bitmap;
	}

	@Override
	protected void onPostExecute(Bitmap result) {
		// TODO Auto-generated method stub
		String url = (String) newImage.getTag();
		if (urlPathString.equals(url)) {
			newImage.setVisibility(View.VISIBLE);
			newImage.setImageBitmap(result);
		} else {

		}

	}

}