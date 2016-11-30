package com.androidpath.project.music.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class HttpUtil {
	/**
	 * 根据url地址下载到一个byte[]里面
	 * @param urlstr
	 * @return
	 */
	public static byte[] getBytesByURL(String urlstr){
		try {
			URL url= new URL(urlstr);
			HttpURLConnection connection=(HttpURLConnection) url.openConnection();
			connection.setReadTimeout(5000);
			connection.setRequestMethod("GET");
			connection.setDoInput(true);
			InputStream inputStream = connection.getInputStream();//不要把这里的inpurStream提取出去
			ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
			int len=0;
			byte[] bs=new byte[1024];
			while((len=inputStream.read(bs))!=-1){
				byteArrayOutputStream.write(bs, 0, len);
			}
			inputStream.close();
			return byteArrayOutputStream.toByteArray();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	}
	/**
	 * 
	 * @param url
	 * @return
	 */
	public static String getJSONStringByByte(String url){
		byte[] bs=getBytesByURL(url);
		if(bs!=null){
			String JsonString;
			try {
				JsonString = new String(bs,"utf-8");
				return JsonString;
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}else{
			return null;
		}
	}
	public static Bitmap getBitmapByByte(String url){
//		Log.e("HttpUtil", url);
		byte[] bs=getBytesByURL(url);
		if(bs!=null){
			Bitmap bitmap = BitmapFactory.decodeByteArray(bs, 0, bs.length);
			return bitmap;
		}else{
			Log.e("HttpUtil", "bitmap no byte[]");
			return null;
		}
	}
}
