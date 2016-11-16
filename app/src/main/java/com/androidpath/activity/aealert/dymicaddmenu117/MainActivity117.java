package com.androidpath.activity.aealert.dymicaddmenu117;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

import com.androidpath.R;

public class MainActivity117 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main117);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0,//组id
				1,//item的id
				1,//item在菜单中的顺序
				"菜单项一");//菜单文字内容
		menu.add(0, 2, 2, "菜单项二");
		
		//添加子菜单并返回子菜单对象
		SubMenu subMenu = menu.addSubMenu(0, 3, 3, "这是一个子菜单");
		subMenu.add(0, 4, 1, "子菜单项一");
		subMenu.add(0, 5, 2, "子菜单项二");
	
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return true;
	}
}
