package com.androidpath.activity.aealert.actionbar190.demo190;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

public class MainActivity190 extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main190);
		
		ActionBar actionBar = getActionBar();
		actionBar.hide();//隐藏
		actionBar.show();//显示
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main190, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id==R.id.item3) {
			Intent intent = new Intent(this, SecondActivity190.class);
			startActivity(intent);
			
		}
		
		return super.onOptionsItemSelected(item);
	}
}
