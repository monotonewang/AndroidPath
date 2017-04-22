package com.androidpath.activity.ahhandler.updateui183;


import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

public class MainActivity183 extends BaseActivity {

	private  boolean flag = true;
	private TextView textView;
	private int count=0;
	private Handler handler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main183);
		
		textView = (TextView) findViewById(R.id.textView);
		handler = new Handler();
	}

	public void clickStart(View view) {
		//方法四：
		handler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
					textView.setText(count+"");
					count++;
					handler.postDelayed(this, 1000);
				
			}
		}, 0);
		
		
		
		/*new Thread(new Runnable() {
			
			@Override
			public void run() {
				while (flag) {
					//方法一：
					MainActivity183.this.runOnUiThread(new Runnable() {
						//run方法中的代码实际上运行在UI线程上
						@Override
						public void run() {
							textView.setText(""+count);
						}
					});
					
					
//					方法二：利用View对象的post方法
					textView.post(new Runnable() {
						
						@Override
						public void run() {
							textView.setText(""+count);
						}
					});
					
					
					//方法三：
					handler.post(new Runnable() {
						
						@Override
						public void run() {
							textView.setText(""+count);
						}
					});
					
					count ++;
					SystemClock.sleep(1000);
				}
			}
		}).start();*/
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		flag = false;
	}
}
