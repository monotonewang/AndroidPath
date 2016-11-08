package com.androidpath.service.intentservice244;

import android.app.IntentService;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * IntentService的生命周期方法：
 * onCreate()
 * onStartCommand()
 * onHandleIntent()
 * onDestory()
 * 
 * 也是通过startService来启动
 * 
 * 如果onHandleIntent方法执行完毕，自动结束
 * @author Ken
 *
 */
public class DownLoadService244 extends IntentService {

	private LocalBroadcastManager localBroadcastManager;
	
	public DownLoadService244() {
		super("DownLoadService244");//该参数，表示给子线程定义一个名称
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("print", "------>onCreate");
		
		localBroadcastManager = LocalBroadcastManager.getInstance(this);
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.d("print", "------>onStartCommand");
		return super.onStartCommand(intent, flags, startId);
	}

	/**
	 * 这个方法就是在子线程中执行
	 */
	@Override
	protected void onHandleIntent(Intent intent) {
		Log.d("print", "------>onHandleIntent");
		String path = intent.getStringExtra("path");
		
		try {
			URL url = new URL(path);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setReadTimeout(5000);
			conn.setDoInput(true);
			conn.setRequestMethod("GET");
			
			InputStream in = conn.getInputStream();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int len = 0;
			byte[] bs = new byte[1024 * 10];
			while((len = in.read(bs)) != -1){
				out.write(bs, 0, len);
			}
			
			in.close();
			byte[] buffer = out.toByteArray();
			
			Bitmap bitmap = BitmapFactory.decodeByteArray(buffer, 0, buffer.length);
			
			Intent intent2 = new Intent("android.intent.action.down");
			intent2.putExtra("image", bitmap);
			intent2.putExtra("url", path);
			localBroadcastManager.sendBroadcast(intent2);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("print", "------>onDestroy");
	}

}
