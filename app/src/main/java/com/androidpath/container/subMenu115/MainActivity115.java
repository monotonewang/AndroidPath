package com.androidpath.container.subMenu115;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.androidpath.R;

public class MainActivity115 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main115);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main115, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		switch (id) {
		case R.id.file_copy:
			//
			Toast.makeText(this, "选中了文件复制", 0).show();
			break;
		case R.id.file_open:
			//
			Toast.makeText(this, "选中了文件打开", 0).show();
			break;
		case R.id.date_setting:
			//
			Toast.makeText(this, "选中了日期设置", 0).show();
			break;
		case R.id.show_setting:
			//
			Toast.makeText(this, "选中了显示设置", 0).show();
			break;

		default:
			break;
		}
		
		return true;
	}
}
