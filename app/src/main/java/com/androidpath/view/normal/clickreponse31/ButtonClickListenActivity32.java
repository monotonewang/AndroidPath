package com.androidpath.view.normal.clickreponse31;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.androidpath.R;

public class ButtonClickListenActivity32 extends Activity {
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
				Toast.makeText(ButtonClickListenActivity32.this, "用匿名内部类对象监听", 1).show();
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
