package com.androidpath.activity.agstorge.loadmanagercontact171;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.androidpath.R;

public class MainActivity171 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main171);
	}
	
	public void clickContact(View view) {
		Intent intent = new Intent(MainActivity171.this,ShowContactActivity171.class);
		startActivity(intent);
	}
	
	
	public void clickSearchContact(View view) {
		Intent intent = new Intent(MainActivity171.this,SearchContactActivity171.class);
		startActivity(intent);
	}
	

	public void clickCustomProvider(View view) {
		Intent intent = new Intent(MainActivity171.this,ShowCustomProviderActivity171.class);
		startActivity(intent);
	}
}
