package com.androidpath.activity.ajbroadcast.serverclient234.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.androidpath.R;

public class MainActivity235 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main235);
	}
	
	public void btnClick(View v){
		Intent intent = new Intent();
		intent.setAction("android.action.intent.abcd");
		sendBroadcast(intent, "android.action.permission.mypermiss");
		
//		Intent intent = new Intent();
//		intent.setAction("android.action.intent.abcd");
//		sendBroadcast(intent);
	}
}
