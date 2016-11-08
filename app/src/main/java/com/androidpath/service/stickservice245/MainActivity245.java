package com.androidpath.service.stickservice245;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.androidpath.R;

public class MainActivity245 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main245);
		
		startService(new Intent(this, StickService.class));
	}
}
