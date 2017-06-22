package com.androidpath.activity.abactivity.getresult60;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

public class MainActivity60 extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main60);
		
		Log.e("MainActivity60", "onCreate....");
		Toast.makeText(this, "onCreate....",Toast.LENGTH_SHORT).show();
	}
	
	public void clickSelect(View view) {
		Intent intent = new Intent(this, SecondActivity60.class);
		
		//参数一时intent，参数二是请求码，用正数就行，用于标识请求的类型
		startActivityForResult(intent, 0);
	}
	
	public void clickQuit(View view) {
		this.finish();
	}
	
	//下一个界面退出后回调，参数一是请求码，参数二是结果码
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	
		Toast.makeText(this, "选择了："+data.getStringExtra("city"), 0).show();
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Log.e("MainActivity60", "onStart....");
		Toast.makeText(this, "onStart....", Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.e("MainActivity60", "onResume....");
		Toast.makeText(this, "onResume....",Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.e("MainActivity60", "onRestart....");
		Toast.makeText(this, "onRestart....",Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.e("MainActivity60", "onPause....");
		Toast.makeText(this, "onPause....",Toast.LENGTH_SHORT).show();
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.e("MainActivity60", "onDestroy....");
		Toast.makeText(this, "onDestroy....",Toast.LENGTH_SHORT).show();
	}
	@Override
	protected void onStop() {
		super.onStop();
		Log.e("MainActivity60", "onStop....");
		Toast.makeText(this, "onStop....",Toast.LENGTH_SHORT).show();
	}
}
