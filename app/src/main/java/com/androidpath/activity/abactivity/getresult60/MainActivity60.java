package com.androidpath.activity.abactivity.getresult60;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.androidpath.R;

public class MainActivity60 extends Activity {

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
		// TODO Auto-generated method stub
		super.onStart();
		Log.e("MainActivity60", "onStart....");
		Toast.makeText(this, "onStart....",0).show();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.e("MainActivity60", "onResume....");
		Toast.makeText(this, "onResume....",0).show();
	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.e("MainActivity60", "onRestart....");
		Toast.makeText(this, "onRestart....",0).show();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.e("MainActivity60", "onPause....");
		Toast.makeText(this, "onPause....",0).show();
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.e("MainActivity60", "onDestroy....");
		Toast.makeText(this, "onDestroy....",0).show();
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.e("MainActivity60", "onStop....");
		Toast.makeText(this, "onStop....",0).show();
	}
}
