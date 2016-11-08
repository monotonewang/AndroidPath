package com.androidpath.handler.handercycleiamge181;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.androidpath.R;

public class MainActivity181 extends Activity {

	private ImageView imageView;
	private int[] imageIds;
	private Handler handler;
	private boolean flag = true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main181);
		imageView = (ImageView) findViewById(R.id.imageView);
		imageIds = new int[] {
				R.drawable.meinv1,
				R.drawable.meinv2,
				R.drawable.meinv3,
				R.drawable.meinv4,
				R.drawable.meinv5
		};
		
		handler = new Handler(){
			@Override
			public void handleMessage(Message msg) {
				Log.e("handler", "received....");
				
				if (msg.what == 1) {
					imageView.setImageResource(msg.arg1);
				}
			}
		};
		
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		flag = true;
		clickStart(null);
	}
	
	public void clickStart(View view) {
		//需求：循环播放---耗时任务，更新视图
		//线程中执行耗时任务，
		new Thread(new Runnable() {
			
			private int currentIndex = 0;
	

			@Override
			public void run() {
				while (flag) {
					
					if (currentIndex == imageIds.length) {
						currentIndex = 0;
					}
					//循环获得要显示的图片的id
					int currentId = imageIds[currentIndex ];
					
					//把当前需要显示的图片的id发给主线程
//					Message message = new Message();//不推荐使用，重复创建对象，效率不高
//					Message message = Message.obtain();//可以用，用这个方法创建消息对象的时候，会检查消息回收池中有没有可以利用的消息对象，有的话，直接使用，没有的话，就创建
					Message message = handler.obtainMessage();//可以用
					message.what = 1;
					
					message.arg1 = currentId;
					
					//用handler发送消息
					handler.sendMessage(message);
					
					//变化图片的id
					currentIndex++;
					Log.e("thread", "running....");
					
					SystemClock.sleep(300);
				}
			}
		}).start();
		
		
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		flag = false;
	}
	
	
	
}
