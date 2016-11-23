package com.androidpath.activity.aalayout.clickreponse31;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

public class ButtonClickListenActivity31 extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main31);
		
		//1.找到事件源
		Button button = (Button) findViewById(R.id.button);
		Button button2 = (Button) findViewById(R.id.button2);
		
		//2.找到监听器对象：----创建对象
		MyListener myListener = new MyListener();
		
		//3.注册监听器对象给事件源,参数就是监听器对象
		button.setOnClickListener(myListener);
		button2.setOnClickListener(myListener);
	}
	
	//定义一个监听器类，实现点击事件监听接口,实现其中的事件处理方法
	public class MyListener implements OnClickListener{

		//在按钮被点击的时候会回调，参数是被点击的按钮对象
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
			if (v.getId() == R.id.button) {
				Toast.makeText(ButtonClickListenActivity31.this, "要下课了！", 1)
				.show();
			}else {
				Toast.makeText(ButtonClickListenActivity31.this, "又上课了！", 1)
				.show();
			}
			
		}
		
	}
	
}
