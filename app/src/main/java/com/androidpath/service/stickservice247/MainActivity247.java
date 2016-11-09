package com.androidpath.service.stickservice247;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.androidpath.R;

public class MainActivity247 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main247);
		
		startService(new Intent(this, StickService247.class));
	}
}
