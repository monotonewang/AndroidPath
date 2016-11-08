package com.androidpath.container.actionbar190.demo190;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.androidpath.R;

public class SecondActivity190 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second190);
		
		//点击actionbar上面的程序图标，回到主界面
		//1.将程序图标变成可点击的
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);//显示一个向左的箭头，让程序图标变得可以点击
//		actionBar.setDisplayShowTitleEnabled(false);//设置标题是否可见
//		actionBar.setDisplayShowHomeEnabled(false);//设置图标是否可见
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second190, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		
//		当点击应用程序图标，相当于点击了一个id是android.R.id.home的菜单项，
		if (id == android.R.id.home) {
			//回到主界面
			Intent intent = new Intent(this, MainActivity190.class);
			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
			
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
