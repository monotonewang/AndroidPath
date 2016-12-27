package com.androidpath.project.music.utils;

import android.graphics.Bitmap;
import android.os.Handler;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class DownUtils {
	private static ExecutorService executorService=Executors.newFixedThreadPool(5);
	private static Handler handler=new Handler();
	
//			使用所要求的零延迟执行命令。
	/**
	 * 下载json
	 */
	public static void dowJSON(final String url,final OnDownComplete onDownComplete){
		executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				final String json = HttpUtil.getJSONStringByByte(url);
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						onDownComplete.onDownSucc(url,json);
					}
				});
			}
		});
	}
	public static void downBitmap(final String url,final OnDownComplete onDownComplete){
		executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				// 子线程
				final Bitmap bitmap= HttpUtil.getBitmapByByte(url);
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						// 结果返回ui主线程
						onDownComplete.onDownSucc(url, bitmap);
					}
				});
			}
		});
	}
	public interface OnDownComplete{
		void onDownSucc(String url, Object obj);
	}
}
