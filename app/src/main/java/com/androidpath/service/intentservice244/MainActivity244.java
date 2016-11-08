package com.androidpath.service.intentservice244;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.ImageView;

import com.androidpath.R;

public class MainActivity244 extends Activity {

	private String[] url = {
			"http://litchiapi.jstv.com/Attachs/Map/7985/9db00649770a4537bf52d334d5e8e2af_cover_padmini.JPG",
			"http://litchiapi.jstv.com/Attachs/Map/7985/d7044fb3462a4b0bb0ac0f83ac4fd5f3_cover_padmini.JPG",
			"http://litchiapi.jstv.com/Attachs/Map/7985/29f3c84b1f024aaf86352c024cd35d3a_cover_padmini.JPG"
	};
	
	private ImageView iv1, iv2, iv3;
	private LocalBroadcastManager localBroadcastManager;
	private MyReceiver myReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main244);
		
		localBroadcastManager = LocalBroadcastManager.getInstance(this);
		myReceiver = new MyReceiver();
		IntentFilter intentFilter = new IntentFilter("android.intent.action.down");
		localBroadcastManager.registerReceiver(myReceiver, intentFilter);
		
		iv1 = (ImageView) findViewById(R.id.iv_id1);
		iv1.setTag(url[0]);
		
		iv2 = (ImageView) findViewById(R.id.iv_id2);
		iv2.setTag(url[1]);
		
		iv3 = (ImageView) findViewById(R.id.iv_id3);
		iv3.setTag(url[2]);
	}
	
	
	class MyReceiver extends BroadcastReceiver{

		@Override
		public void onReceive(Context context, Intent intent) {
			Bitmap bitmap = intent.getParcelableExtra("image");
			String url = intent.getStringExtra("url");
			if(url.equals(iv1.getTag())){
				iv1.setImageBitmap(bitmap);
			} else if(url.equals(iv2.getTag())){
				iv2.setImageBitmap(bitmap);
			} else if(url.equals(iv3.getTag())){
				iv3.setImageBitmap(bitmap);
			}
		}
	}
	
	public void start(View v){
		for(int i = 0; i < url.length; i++){
			Intent intent = new Intent(this, DownLoadService.class);
			intent.putExtra("path", url[i]);
			startService(intent);
		}
	}
}
