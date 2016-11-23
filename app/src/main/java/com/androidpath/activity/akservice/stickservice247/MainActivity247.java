package com.androidpath.activity.akservice.stickservice247;

import android.content.Intent;
import android.os.Bundle;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

public class MainActivity247 extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main247);
		
		startService(new Intent(this, StickService247.class));
	}
}
