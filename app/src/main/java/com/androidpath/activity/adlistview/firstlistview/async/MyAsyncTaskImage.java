package com.androidpath.activity.adlistview.firstlistview.async;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;

import com.androidpath.activity.adlistview.firstlistview.utils.MyHttpUtils;


public class MyAsyncTaskImage extends AsyncTask<String, Void, Bitmap> {
	private ImageView newImage;
	private String urlPathString;

	public MyAsyncTaskImage(ImageView newImage) {
		this.newImage = newImage;
	}

	@Override
	protected Bitmap doInBackground(String... params) {
		urlPathString = params[0];
		Bitmap bitmap = MyHttpUtils.downLoadBitmap(urlPathString);
		return bitmap;
	}

	@Override
	protected void onPostExecute(Bitmap result) {
		String url = (String) newImage.getTag();
		if (urlPathString.equals(url)) {
			newImage.setVisibility(View.VISIBLE);
			newImage.setImageBitmap(result);
		} else {

		}

	}

}
