package com.androidpath.activity.abactivity.getresult60;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.androidpath.R;

public class SecondActivity60 extends Activity {

	private String[] cityArrays;
	private Spinner spinner;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second60);
		spinner = (Spinner) findViewById(R.id.city_spinner);
		
		cityArrays = new String[] {"纽约","巴黎","罗马","东京","拉斯维加斯"};
		
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cityArrays);
		
		spinner.setAdapter(adapter);
	}
	
	public void clickBack(View view) {
		
		
		Intent intent = getIntent();
		intent.putExtra("city", cityArrays[spinner.getSelectedItemPosition()]);
		
		//将数据传回给启动端
		setResult(1, intent);
		//activity自己退出
		finish();
	}
}
