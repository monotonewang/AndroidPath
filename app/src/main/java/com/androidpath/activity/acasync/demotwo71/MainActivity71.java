package com.androidpath.activity.acasync.demotwo71;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity71 extends BaseActivity {

	private ImageView imageView;
	int count = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main71);
		
		imageView = (ImageView) findViewById(R.id.imageview);
	}
	
	public void clickDownload(View view) {
		//下载图片
//		http://a3.att.hudong.com/50/30/01300000322847123114301689718.jpg
		//这是一个耗时操作，4.0以后明确规定网络连接必须在子线程中执行
		//2.创建异步任务实例
		MyAsyncTask myAsyncTask = new MyAsyncTask();
		
		//3.开启异步任务
		myAsyncTask.execute("http://a3.att.hudong.com/50/30/01300000322847123114301689718.jpg");
		
	}
	
	//1.定义类继承于asynctask
	//三个泛型：
	/*Params:主线程要传给子线程的参数的类型-----主线程需要传网络地址---String
	 *Progress：进度数据的类型---不显示进度---Void
	 *Result：子线程执行结束后返回给主线程的结果的数据类型----返回的是一张图片---Bitmap
	 * */
	public class MyAsyncTask extends AsyncTask<String, Void, Bitmap>{
		
		//在UI线程上执行的，主要做一些界面的准备工作,最先执行
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
//			Toast.makeText(MainActivity71.this, "onPreExecute", 0).show();
			Log.e("MyAsyncTask72", "onPreExecute");
		}

		
		//在子线程中执行，参数就是主线程传过来的数据，返回值是线程执行完任务的时候返回的结果，这个结果被返回到onPostExecute方法的参数中
		@Override
		protected Bitmap doInBackground(String... params) {
			// TODO Auto-generated method stub
			Bitmap bitmap = null;
			//获得url字符串
			String urlString = params[0];
			try {
				URL url = new URL("http://a3.att.hudong.com/50/30/01300000322847123114301689718.jpg");
				//建立连接
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				
				
				InputStream inputStream = connection.getInputStream();
				
				bitmap = BitmapFactory.decodeStream(inputStream);
				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
//			Toast.makeText(MainActivity71.this, "doInBackground"+urlString, 0).show();
			Log.e("MyAsyncTask72", "doInBackground");
			
			return bitmap;
		}
		
		//在UI线程上执行，用于更新进度，当在doInBackground调用 publishProgress(Progress...)方法的时候回调
		@Override
		protected void onProgressUpdate(Void... values) {
			// TODO Auto-generated method stub
//			Toast.makeText(MainActivity71.this, "onProgressUpdate", 0).show();
			Log.e("MyAsyncTask72", "onProgressUpdate");
			super.onProgressUpdate(values);
		}
		
		
		//在UI线程上执行，参数是子线程返回的结果，最后执行
		@Override
		protected void onPostExecute(Bitmap result) {
			// TODO Auto-generated method stub
//			Toast.makeText(MainActivity71.this, "onPostExecute", 0).show();
			Log.e("MyAsyncTask72", "onPostExecute");
			
		
			//更新UId
			imageView.setImageBitmap(result);
			super.onPostExecute(result);
		}
		
	}
}
