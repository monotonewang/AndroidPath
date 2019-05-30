package com.androidpath.activity.aiviewpager.circle212;

import android.os.Bundle;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity212 extends BaseActivity implements OnPageChangeListener, OnClickListener {
	
	private ViewPager viewPager;
	private List<ImageView> datas;
	private MyPagerAdapter myPagerAdapter;
	
	private LinearLayout ll_nav;
	private LinearLayout.LayoutParams layoutParams;//定义一个布局参数，用于设置控件中的布局属性

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main212);
        
        initView();
        loadDatas();
    }

	/**
     * 初始化控件
     */
	private void initView() {
		viewPager = (ViewPager) findViewById(R.id.vp_welcome);
		//设置ViewPager的监听
		viewPager.setOnPageChangeListener(this);
		ll_nav = (LinearLayout) findViewById(R.id.ll_nav);
		ll_nav.setGravity(Gravity.CENTER);
		
		layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParams.leftMargin = 10;
		layoutParams.rightMargin = 10;
	}
	
	/**
	 * 加载数据的方法
	 */
	private void loadDatas() {
		datas = new ArrayList<ImageView>();
		for(int i = 1; i <= 3; i++){
			//通过资源名称，获得资源id
			int resid = getResources().getIdentifier("slide" + i, "drawable", getPackageName());
			ImageView iv = new ImageView(this);
			iv.setImageResource(resid);
			datas.add(iv);
		}
		myPagerAdapter = new MyPagerAdapter();
		viewPager.setAdapter(myPagerAdapter);
		
		//初始化一下那个导航图标
		/**
		 * 布局标签中，所有layout_为前缀的属性，表示该属性是作用于父控件或相对控件的。
		 * 在java对象中，没有响应的属性进行设置
		 */
		for(int i = 0; i < datas.size(); i++){
			ImageView iv = new ImageView(this);
//			iv.setLayoutParams(layoutParams);
			iv.setTag(i);
			iv.setOnClickListener(this);
			if(i == 0){
				iv.setImageResource(R.drawable.page);
			} else {
				iv.setImageResource(R.drawable.page_now);
			}
			ll_nav.addView(iv, layoutParams);
		}
	}
	
	class MyPagerAdapter extends PagerAdapter{

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(datas.get(position));
//			container.removeViewAt(position);
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(datas.get(position));
			return datas.get(position);
		}

		@Override
		public int getCount() {
			return datas.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}
	}

	/**
	 * ViewPager的监听方法
	 */
	@Override
	public void onPageScrollStateChanged(int arg0) {
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		
	}

	@Override
	public void onPageSelected(int position) {
		//把所有点设置为未被选中
		for(int i = 0; i < ll_nav.getChildCount(); i++){
			ImageView iv = (ImageView) ll_nav.getChildAt(i);
			iv.setImageResource(R.drawable.page_now);
		}
		
		//把下标为position的点，设置为被选中
		ImageView iv = (ImageView) ll_nav.getChildAt(position);
		iv.setImageResource(R.drawable.page);
	}

	/**
	 * ImageView的点击监听事件
	 */
	@Override
	public void onClick(View arg0) {
		int index = (Integer) arg0.getTag();
		viewPager.setCurrentItem(index);
	}
}
