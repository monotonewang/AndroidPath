package com.androidpath.activity.aiviewpager.fragment214;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.util.Log;

import com.androidpath.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity214 extends FragmentActivity {
	
	private ViewPager viewPager;
	private List<ArrayList<String>> datas;
	private MyPagerAdapter myPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main214);
        
        initView();
        loadDatas();
    }
    
	private void initView() {
		viewPager = (ViewPager) findViewById(R.id.vp_fragment);
	}
	

	/**
	 * 构建数据源
	 * 
	 * [[A,B], [A1,B1], [], []]
	 */
	private void loadDatas() {
		datas = new ArrayList<ArrayList<String>>();
		for(int i = 0; i < 5; i++){
			ArrayList<String> datalist = new ArrayList<String>();
			for(int j = 0; j < 20; j++){
				datalist.add(i + "内容：" + (j + 1));
			}
			datas.add(datalist);
		}
		
		myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), datas);
		viewPager.setAdapter(myPagerAdapter);
	}

	/**
	 * ViewPager + fragment适配器
	 * @author Ken
	 * 
	 * FragmentPagerAdapter 和 FragmentStatePagerAdapter 的区别：
	 * 
	 * FragmentPagerAdapter：只会销毁fragment的视图，fragment的对象被保留在了内存中，下次再创建该fragment时，直接从内存中获得该对象，
	 * 						如果页面较少，并且不需要动态更新时，用这种适配器用户体验较好，开销较少
	 * 
	 * FragmentStatePagerAdapter：会直接销毁fragment对象，下次再使用该fragment时，重新创建新的对象。
	 *                           页面较多，并且需要动态更新的时候，需要使用该适配器。
	 *
	 */
	class MyPagerAdapter extends FragmentStatePagerAdapter{

		private List<ArrayList<String>> datas;
		
		public MyPagerAdapter(FragmentManager fm, List<ArrayList<String>> datas) {
			super(fm);
			this.datas = datas;
		}
		
		@Override
		public Fragment getItem(int position) {
			Log.d("print", "---->加载fragment：" + position);
			return ViewPagerFragment.getInstance(datas.get(position));
		}

		@Override
		public int getCount() {
			return datas.size();
		}
	}
}
