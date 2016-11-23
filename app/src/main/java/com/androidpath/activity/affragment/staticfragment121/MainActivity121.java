package com.androidpath.activity.affragment.staticfragment121;

import android.os.Bundle;
import android.util.Log;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

public class MainActivity121 extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main121);
		Log.e("MainActivity121", "onCreate.....");
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.e("MainActivity121", "onStart.....");
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.e("MainActivity121", "onRestart.....");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.e("MainActivity121", "onResume.....");
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.e("MainActivity121", "onPause.....");
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.e("MainActivity121", "onStop.....");
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.e("MainActivity121", "onDestroy.....");
	}
	
	
}
