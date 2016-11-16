package com.androidpath.activity.aealert.actionbar190.customview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

import com.androidpath.R;

public class MainActivity194 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main194);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main194, menu);

		MenuItem item1 = menu.findItem(R.id.searchView);// 将菜单的item实例化
		SearchView searchView = (SearchView) item1.getActionView();// 通过菜单项对象获得其中的searchview对象
		searchView.setOnQueryTextListener(new OnQueryTextListener() {

			@Override
			public boolean onQueryTextSubmit(String query) {
				// TODO Auto-generated method stub
				Log.e("onQueryTextSubmit", query);
				return true;
			}

			@Override
			public boolean onQueryTextChange(String newText) {
				// TODO Auto-generated method stub
				Log.e("onQueryTextChange", newText);
				return true;
			}
		});


		final MenuItem item2 = menu.findItem(R.id.button);
		Button button = (Button) item2.getActionView();
		button.setText("这是随便按钮");
		button.setTextColor(0xffffffff);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.e("onClick", "随便按钮");
			}
		});

		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return super.onOptionsItemSelected(item);
	}
}
