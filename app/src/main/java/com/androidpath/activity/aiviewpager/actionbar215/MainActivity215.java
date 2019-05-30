package com.androidpath.activity.aiviewpager.actionbar215;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.AppCompatActivity;

import com.androidpath.R;

public class MainActivity215 extends AppCompatActivity implements TabListener, OnPageChangeListener {

	private ViewPager viewPager;
	private ActionBar actionBar;
	private String[] datas = {"头条", "热点", "在线直播", "科技", "IT", "娱乐新闻"};
	private MyPagerAdapter myPagerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main215);
		
		initView();
		initActionBar();
		
	}

	private void initView() {
		viewPager = (ViewPager) findViewById(R.id.vp_fragment);
		myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), datas);
		viewPager.setAdapter(myPagerAdapter);
		
		viewPager.setOnPageChangeListener(this);
	}
	
	private void initActionBar() {
		actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		for(int i = 0; i < datas.length; i++){
			Tab tab = actionBar.newTab()
				.setText(datas[i])
				.setIcon(android.R.drawable.ic_menu_help)
				.setTabListener(this);
			
			actionBar.addTab(tab);
		}
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction arg1) {
		viewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		
	}
	
	
	/**
	 * ViewPager的适配器
	 */
	class MyPagerAdapter extends FragmentPagerAdapter{

		private String[] datas;
		
		public MyPagerAdapter(FragmentManager fm, String[] datas) {
			super(fm);
			this.datas = datas;
		}

		@Override
		public Fragment getItem(int position) {
			return ActionBarFragment.getInstance(datas[position]);
		}

		@Override
		public int getCount() {
			return datas.length;
		}
		
	}


	@Override
	public void onPageScrollStateChanged(int arg0) {
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		
	}

	@Override
	public void onPageSelected(int position) {
		Tab tab = actionBar.getTabAt(position);
		actionBar.selectTab(tab);
	}
}
