package com.androidpath.view.container.actionbar190.tab192;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

import com.androidpath.R;

public class MainActivity192 extends Activity implements TabListener {

	private MyFragment contactFragment;
	private MyFragment msgFragment;
	private MyFragment findFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main192);
		
		initFragment();

		// 1.设置action的模式
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// 2.添加tab
		// 通过actionbar创建tab对象，做一些设置，设置监听器对象
		Tab tab1 = actionBar.newTab().setText("联系人").setTabListener(this);

		// 将tab加入actionbar
		actionBar.addTab(tab1);

		// 通过actionbar创建tab对象，做一些设置，设置监听器对象
		Tab tab2 = actionBar.newTab().setText("微信").setTabListener(this);

		// 将tab加入actionbar
		actionBar.addTab(tab2);

		// 通过actionbar创建tab对象，做一些设置，设置监听器对象
		Tab tab3 = actionBar.newTab().setText("发现").setTabListener(this);

		// 将tab加入actionbar
		actionBar.addTab(tab3);

	}

	private void initFragment() {
		contactFragment = new MyFragment("这是联系人界面", 0xffff0000);
		
		msgFragment = new MyFragment("这是微信界面", 0xffffff00);
		findFragment = new MyFragment("这是发现界面", 0xffff00ff);
	}

	// 选中某个页面的时候回调
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		Log.e("onTabSelected", tab.getText() + ":" + tab.getPosition());

		String title = tab.getText().toString();
		// 加入对应的fragment
		if (title.equals("联系人")) {
			ft.replace(R.id.container, contactFragment);
		} else if (title.equals("微信")) {
			ft.replace(R.id.container, msgFragment);
		} else if (title.equals("发现")) {
			ft.replace(R.id.container, findFragment);
		}
	}

	// 切换到另一界面的时候回调，参数是前一个被选中的页面
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		Log.e("onTabUnselected", tab.getText() + ":" + tab.getPosition());
	}

	// 不切换页面，再次选中的时候回调
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		Log.e("onTabReselected", tab.getText() + ":" + tab.getPosition());
	}
}
