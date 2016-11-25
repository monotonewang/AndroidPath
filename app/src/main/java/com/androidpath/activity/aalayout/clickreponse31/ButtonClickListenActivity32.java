package com.androidpath.activity.aalayout.clickreponse31;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

public class ButtonClickListenActivity32 extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main31);
		
		//1.找到事件源
		Button button = (Button) findViewById(R.id.button);
		
		//2.给事件源注册监听器对象：匿名内部类对象
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(ButtonClickListenActivity32.this, "用匿名内部类对象监听", Toast.LENGTH_LONG).show();
			}
		});
		
		
		
		/*OnClickListener listener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		};
		button.setOnClickListener(listener);*/
		
		
		
		
	}
	
	
	
}
