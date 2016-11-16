package com.androidpath.activity.abactivity.flagdemo74;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.androidpath.R;

public class SecondActivity74 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main74);
	}

	public void clickMain(View view) {
		Intent intent = new Intent(this, MainActivity74.class);

		startActivity(intent);

	}

	public void clickSecond(View view) {
		Intent intent = new Intent(this, SecondActivity74.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
		startActivity(intent);
	}
}
