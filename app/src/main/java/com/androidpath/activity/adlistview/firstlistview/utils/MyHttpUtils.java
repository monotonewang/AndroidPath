package com.androidpath.activity.adlistview.firstlistview.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MyHttpUtils {
	// private final static String TAG="MyHttpUtils";
	public static String downLoadstring(String urlpath) {

		try {
			URL url = new URL(urlpath);
			// Log.i(TAG, url+"-aa");
			HttpURLConnection httpURLConnection = (HttpURLConnection) url
					.openConnection();
			InputStream inputStream = httpURLConnection.getInputStream();
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(inputStream));
			StringBuffer stringBuffer = new StringBuffer();
			while (true) {
				String str = bufferedReader.readLine();
				if (str == null) {
					break;
				}
				stringBuffer.append(str);
			}
			return stringBuffer.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
		// TODO Auto-generated method stub

	}

	public static Bitmap downLoadBitmap(String string) {

		try {
			URL url = new URL(string);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url
					.openConnection();
			httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
			InputStream inputStream = httpURLConnection.getInputStream();
			// 内存转换流
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			while (true) {
				byte[] b = new byte[1024];// 如果写在while外面会出现图片只显示一部分
				int len = inputStream.read(b, 0, b.length);
				if (len == -1) {
					break;
				}
				byteArrayOutputStream.write(b, 0, len);
			}
			byte[] byteArray = byteArrayOutputStream.toByteArray();
			Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0,
					byteArray.length);
			// Bitmap bitmap=BitmapFactory.decodeStream(inputStream);
			return bitmap;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
		// TODO Auto-generated method stub

	}
}
