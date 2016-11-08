package com.androidpath.view.viewpager.textview210;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidpath.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity210 extends Activity {

	private ViewPager viewPager;
	private List<String> datas;//数据源
	private MyPagerAdapter myPagerAdapter;//适配器
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main210);
        
        init();
    }

    /**
     * 初始化方法
     */
	private void init() {
		viewPager = (ViewPager) findViewById(R.id.vp_id);
		datas = new ArrayList();
		for(int i = 0; i < 5; i++){
			datas.add("����ҳ��" + i);
		}
		
		myPagerAdapter = new MyPagerAdapter(this, datas);
		viewPager.setAdapter(myPagerAdapter);
		viewPager.setOffscreenPageLimit(1);//表示设置离当前显示页面多少页以上的被移除。默认为1，最小也必须为1，不推荐使用该方法。

		/**
		 * ViewPager的监听，大概5.0以后，该方法过时
		 * 推荐使用addOnPageChangeListener
		 */
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			/**
			 * 重新选择当前页时，回调
			 */
			@Override
			public void onPageSelected(int position) {
//				Log.d("print", "��ǰ�±�---->" + position);
			}

			/**
			 * 滑动ViewPager时，一直回调该方法，该方法用于监听ViewPager的滑动偏移量
			 *
			 * 第一个参数：表示当前选中的页面下标
			 * 第二个参数：表示viewpager滑动的百分比偏移量，值范围：0~1，永远不可能为1
			 * 第三个参数：表示Viewpager滑动的像素偏移量
			 */
			@Override
			public void onPageScrolled(int position, float arg1, int arg2) {
//				Log.d("print", "----->" + position + "   " + arg1 + "  " + arg2);
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				switch (arg0) {
					case ViewPager.SCROLL_STATE_DRAGGING:
						//开始滚动时，回调
						Log.d("print", "-----> SCROLL_STATE_DRAGGING");
						break;
					case ViewPager.SCROLL_STATE_SETTLING:
						//结束滚动前，设置最终位置时回调
						Log.d("print", "-----> SCROLL_STATE_SETTLING");
						break;
					case ViewPager.SCROLL_STATE_IDLE:
						//结束滚动时，回调
						Log.d("print", "-----> SCROLL_STATE_IDLE");
						break;
				}
			}
		});
	}
	
	/**
	 * ViewPager适配器
	 * ViewPager特点：只加载当前显示的页面本身，和前一个页面、后一个页面，为了节省资源。
	 *
	 */
	class MyPagerAdapter extends PagerAdapter{

		private Context context;
		private List<String> datas;
		private List<TextView> tvDATAS;
		
		public MyPagerAdapter(Context context, List<String> datas){
			this.context = context;
			this.datas = datas;
			tvDATAS = new ArrayList();
			//对基本数据源做一个转化
			for(int i = 0; i < datas.size(); i++){
				TextView tv = new TextView(context);
				tv.setText(datas.get(i));
				tv.setGravity(Gravity.CENTER);
				tvDATAS.add(tv);
			}
		}

		/**
		 * 从Viewpager中移除Item
		 */
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
//			Log.d("print", "��ǰ�Ƴ����±꣺" + position);
			container.removeView(tvDATAS.get(position));
		}

		/**
		 * 向ViewPager中添加Item
		 */
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
//			Log.d("print", "��ǰ��ӵ��±꣺" + position);
			container.addView(tvDATAS.get(position));
			return tvDATAS.get(position);
		}

		/**
		 * 设置ViewPager共有多少页
		 */
		@Override
		public int getCount() {
			return tvDATAS.size();
		}

		/**
		 * 用于判断Viewpager中的Item是否为一个View
		 */
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}
		
	}
}
