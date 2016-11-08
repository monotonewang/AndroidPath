package com.androidpath.handler.handerimage180;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.androidpath.R;

public class MainActivity180 extends Activity {
	String urlString = "http://a3.att.hudong.com/50/30/01300000322847123114301689718.jpg";

	private ImageView imageView;

	private Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main180);
		imageView = (ImageView) findViewById(R.id.imageView);
		
		//1.创建Handler对象
		handler = new Handler(){
			//消息处理方法，在收到消息的时候回调,参数就是收到的消息对象
			@Override
			public void handleMessage(Message msg) {
				Log.e("Handler", "handleMessage");
				if (msg.what == 1) {
					Bitmap bitmap = (Bitmap) msg.obj;
					imageView.setImageBitmap(bitmap );
				}
				
			}
		};
	}
	
	public void clickDown(View view) {
		//开始下载图片---用Handler下载图片
		new Thread(){
			public void run() {
				Bitmap bitmap = MyHttpUtil.downLoadImage(urlString);
				//2.在子线程中发出消息
				//创建消息对象
				Message message = new Message();
				//在消息对象中携带上数据
				message.what = 1;//what一般用于标识消息的类型，类型由程序员自己来规定
				message.obj = bitmap;
				Log.e("Thread", "下载完成");
				//发出消息
				handler.sendMessage(message);
				
//				imageView.setImageBitmap(bitmap);
				
			};
		}.start();
	}
}
