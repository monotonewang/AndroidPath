package com.androidpath.activity.aiviewpager.tabone220;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.androidpath.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity220 extends Activity implements OnPageChangeListener {

	private HorizontalScrollView horizontalSv;//最外层的横向ScrollView
	private View view;//下面的光标
	private LayoutParams layoutParams;
	
	private ViewPager vp;
	private MyPagerAdapter myPagerAdapter;
	
	private String[] datas = {"头条", "新闻", "娱乐", "在线", "科技", "金融", "体育"};
	
	/**
	 * ScrollView里面只允许有一个子控件
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main220);
		
		initView();
	}

	private void initView() {
		vp = (ViewPager) findViewById(R.id.vp_id);
		myPagerAdapter = new MyPagerAdapter(this, datas);
		vp.setAdapter(myPagerAdapter);
		vp.setOnPageChangeListener(this);
		
		horizontalSv = (HorizontalScrollView) findViewById(R.id.hsv_id);
		view = findViewById(R.id.view_nav);
		layoutParams = (LayoutParams) view.getLayoutParams();
	}
	
	
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
	 * ViewPager 监听方法
	 */
	@Override
	public void onPageScrollStateChanged(int arg0) {
		
	}

	@Override
	public void onPageScrolled(int position, float pyl, int arg2) {
		layoutParams.leftMargin = (int) ((position + pyl) * layoutParams.width);
		view.setLayoutParams(layoutParams);
		
//		horizontalSv.scrollTo(100, 0); //移动到指定的像素位置
//		horizontalSv.scrollBy(100, 0); //在当前的像素位置基础上，再加上指定的像素
		
		horizontalSv.scrollTo(layoutParams.leftMargin - 50, 0);
	}

	@Override
	public void onPageSelected(int arg0) {
		
	}
}
