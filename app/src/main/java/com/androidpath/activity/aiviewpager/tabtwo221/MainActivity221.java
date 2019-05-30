package com.androidpath.activity.aiviewpager.tabtwo221;


import android.content.Context;
import android.os.Bundle;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity221 extends BaseActivity implements OnPageChangeListener, OnClickListener {

	private String[] datas = {"头条", "直播间", "USA NBA BASKETBALL", "科技", "体育在线"};
	private List<Integer> viewWidths;//用来存放所有tab组件的宽度
	
	private HorizontalScrollView hsHorizontalScrollView;
	private LinearLayout ll;
	private LayoutParams layoutParams;
	private View view_nav;
	
	private ViewPager vp;
	private MyPagerAdapter myPagerAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main221);
		
		initView();
	}

	private void initView() {
		hsHorizontalScrollView = (HorizontalScrollView) findViewById(R.id.hsv_id);
		ll = (LinearLayout) findViewById(R.id.ll_tab);
		layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
		view_nav = findViewById(R.id.view_nav);
		
		viewWidths = new ArrayList<Integer>();
		
		for(int i = 0; i < datas.length; i++){
			TextView tv = new TextView(this);
			tv.setText(datas[i]);
			tv.setGravity(Gravity.CENTER);
			tv.setPadding(20, 0, 20, 0);
			tv.setLayoutParams(layoutParams);
			tv.setOnClickListener(this);
			tv.setTag(i);
			ll.addView(tv);
			
			//调用一下组件的测量方法
			tv.measure(0, 0);//通知系统对组件进行测量
			viewWidths.add(tv.getMeasuredWidth());
//			Log.d("print", "tab的宽高---->" + tv.getMeasuredWidth() + "   " + tv.getMeasuredHeight());
		}
		
		//讲第一个tab项的宽度赋给光标
		LayoutParams viewLayoutParams = (LayoutParams) view_nav.getLayoutParams();
		viewLayoutParams.width = viewWidths.get(0);
		view_nav.setLayoutParams(viewLayoutParams);
		
		
		//初始化ViewPager相关
		vp = (ViewPager) findViewById(R.id.vp_id);
		myPagerAdapter = new MyPagerAdapter(this, datas);
		vp.setAdapter(myPagerAdapter);
		vp.setOnPageChangeListener(this);
	}
	
	
	/**
	 * ViewPager的适配器
	 * @author Ken
	 *
	 */
	class MyPagerAdapter extends PagerAdapter{

		private Context context;
		private String[] datas;
		private List<TextView> tvList;
		
		public MyPagerAdapter(Context context, String[] datas){
			this.context = context;
			this.datas = datas;
			
			tvList = new ArrayList<TextView>();
			for(int i = 0; i < datas.length; i++){
				TextView tv = new TextView(context);
				tv.setText(datas[i]);
				tv.setGravity(Gravity.CENTER);
				tv.setTextSize(50);
				tvList.add(tv);
			}
		}
		

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(tvList.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(tvList.get(position));
			return tvList.get(position);
		}
		
		@Override
		public int getCount() {
			return datas.length;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}
	}


	
	/**
	 * ViewPager的监听器
	 */
	@Override
	public void onPageScrollStateChanged(int arg0) {
		
	}
	

	@Override
	public void onPageScrolled(int position, float pyl, int arg2) {
		LayoutParams layoutParams = (LayoutParams) view_nav.getLayoutParams();
		
		//计算光标的移动位置
		int width = 0;
		for(int i = 0; i < position; i++){
			width += viewWidths.get(i);
		}
		width += viewWidths.get(position) * pyl;
		layoutParams.leftMargin = width;
		
		//计算光标的长度
		if(position < viewWidths.size() - 1){
			layoutParams.width = (int) (viewWidths.get(position) + (viewWidths.get(position + 1) - viewWidths.get(position)) * pyl);
		} else {
			layoutParams.width = viewWidths.get(position);
		}
		view_nav.setLayoutParams(layoutParams);
		
		hsHorizontalScrollView.scrollTo(layoutParams.leftMargin - 50, 0);
	}
	

	@Override
	public void onPageSelected(int arg0) {
		
	}

	
	
	@Override
	public void onClick(View v) {
		int index = (Integer) v.getTag();
		vp.setCurrentItem(index);
	}
}
