package com.androidpath.activity.adlistview.listviewjoke90.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class MyHttpUtil {

	public static String dowloadString(String urlString) {
		// TODO Auto-generated method stub
		//连接网络
		try {
			URL url = new URL(urlString);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			
			//获得流
			InputStream inputStream = urlConnection.getInputStream();
			
			BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));
			StringBuffer stringBuffer = new StringBuffer();
			
			while (true) {
				String line = bfr.readLine();
				if (line == null) {
					break;
				}
				stringBuffer.append(line);
			}
			
			return stringBuffer.toString();
			
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Bitmap downloadBitmap(String urlString) {
		// TODO Auto-generated method stub
		
		try {
			URL url = new URL(urlString);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			
			//获得流
			InputStream inputStream = urlConnection.getInputStream();
			
			Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
			
			return bitmap;
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	


}
