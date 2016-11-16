package com.androidpath.activity.aealert.popupmenu114;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;

import com.androidpath.R;

public class MainActivity114 extends Activity implements OnMenuItemClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main114);
	}
	
	public void clickPopMenu(View view) {
		//1.用构造方法创建弹出窗菜单对象
		PopupMenu popupMenu = new PopupMenu(this, view);
		
		//2.通过菜单加载器将菜单布局加载到菜单对象中
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.pop_menu, popupMenu.getMenu());
		
		//给菜单对象注册监听器
		popupMenu.setOnMenuItemClickListener(this);
		
		//3.调用popupmenu的show方法显示菜单
		popupMenu.show();
	}

	@Override
	public boolean onMenuItemClick(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.item1:
			Toast.makeText(this, "选中了选项一", 1).show();
			break;
		case R.id.item2:
			Toast.makeText(this, "选中了选项二", 1).show();
			break;
		case R.id.item3:
			Toast.makeText(this, "选中了选项三", 1).show();
			break;

		default:
			break;
		}
		return true;
	}
}
