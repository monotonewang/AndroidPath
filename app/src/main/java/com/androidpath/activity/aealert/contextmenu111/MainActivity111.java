package com.androidpath.activity.aealert.contextmenu111;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.androidpath.R;

public class MainActivity111 extends Activity {

	private EditText gendereEditText;
	private EditText loveEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main111);
		
		gendereEditText = (EditText) findViewById(R.id.gender_edit);
		loveEditText = (EditText) findViewById(R.id.love_edit);
		
		//2.注册上下文菜单给控件
		registerForContextMenu(gendereEditText);
		registerForContextMenu(loveEditText);
	}
	
	//1.重写方法onCreateContextMenu,这个方法在长按某个控件的时候回调
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		if (v.getId() == R.id.gender_edit) {
			getMenuInflater().inflate(R.menu.gender_menu, menu);
			menu.setHeaderTitle("请选择性别");
			menu.setHeaderIcon(R.drawable.main_tab_yue_click);
		
		}else if (v.getId() == R.id.love_edit) {
			getMenuInflater().inflate(R.menu.love_menu, menu);
			menu.setHeaderTitle("请选择爱好");
			menu.setHeaderIcon(R.drawable.my_like);
		}
	}
	
	//3.重写上下文菜单事件处理方法
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == R.id.man_item ||item.getItemId() == R.id.girl_item ) {
			gendereEditText.setText(item.getTitle());
		}
		else {
			loveEditText.setText(item.getTitle());
		}
		
		return super.onContextItemSelected(item);
	}
}
