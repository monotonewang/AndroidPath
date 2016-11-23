package com.androidpath.activity.abactivity.taskdemo61;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

public class MainActivity61 extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main61);
	}

	// 点击进入第一个界面
	public void clickFirst(View view) {
		Intent intent = new Intent(this, MainActivity61.class);
		startActivity(intent);
	}

	// 点击进入第二个界面
	public void clickSecond(View view) {
		Intent intent = new Intent(this, SecondActivity61.class);
		startActivity(intent);
	}

	// 点击进入第三个界面
	public void clickThird(View view) {
		Intent intent = new Intent(this, ThirdActivity61.class);
		startActivity(intent);
	}

	// 点击进入第四个界面
	public void clickFourth(View view) {
		Intent intent = new Intent(this, FourthActivity61.class);
		startActivity(intent);
	}
}
