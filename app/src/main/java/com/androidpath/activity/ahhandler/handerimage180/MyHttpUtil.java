package com.androidpath.activity.ahhandler.handerimage180;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyHttpUtil {

	public static Bitmap downLoadImage(String urlString) {
		Bitmap bitmap = null;
		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
//			connection.setRequestProperty("Accept-Encoding", "identity");
			InputStream inputStream = connection.getInputStream();
			bitmap = BitmapFactory.decodeStream(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return bitmap;
	}

}
