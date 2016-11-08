package com.androidpath.view.listview.listviewdataparse83.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyHttpUtil {

	public static String downLoadString(String urlString) {
		// TODO Auto-generated method stub
		URL url;
		try {
			url = new URL(urlString);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			
			
			InputStream inputStream = httpURLConnection.getInputStream();
			//将字节流转换成带缓冲的字符流
			BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));
			
			//内容可变的字符串缓冲区
			StringBuffer stringBuffer = new StringBuffer();
			
			while (true) {
				String line = bfr.readLine();
				if (line == null) {
					break;
				}
				//保存数据
				stringBuffer.append(line);
			}
			
			return stringBuffer.toString();
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
