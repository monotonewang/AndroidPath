package com.androidpath.project.music;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.project.music.ViewApapter.MyFragmentAdapter;
import com.androidpath.project.music.fragment.inter.OnFragmentPublicItemClickListener;
import com.androidpath.project.music.fragment.inter.OnFragmentSongClickListener;
import com.androidpath.project.music.service.MediaPlayerService;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements OnFragmentPublicItemClickListener,OnFragmentSongClickListener {
	
	private LinearLayout linearLayout;
	private HorizontalScrollView horizontalScrollView;
	private View viewNav;
	private ViewPager viewPager;
	/**
	 * data
	 */
	private String listMusicName;
	private String[] datas = {"公共频道", "音乐人频道","歌曲列表","播放界面", "数据"};
	private String[] datas2 = {"公共频道", "音乐人频道",listMusicName,"播放界面", "数据"};
	private List<Integer> viewWiths;
	private List<TextView> textViews;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.music_activity_main);
//		startService(new Intent(this,MediaPlayerService.class));
		startService(new Intent(this, MediaPlayerService.class));
		initView();
	}
	
	private void initView() {
		// TODO Auto-generated method stub
		linearLayout=(LinearLayout) findViewById(R.id.ll_id);
		viewNav=findViewById(R.id.view_nav);
		horizontalScrollView=(HorizontalScrollView) findViewById(R.id.hsv_id);
		viewWiths=new ArrayList<Integer>();
		textViews = new ArrayList<TextView>();
		for (int i = 0; i < datas.length; i++) {
			TextView tv=new TextView(this);
			tv.setText(datas[i]);
			tv.setTextSize(27);
			tv.setTag(i);
			tv.setPadding(30, 10, 30, 10);
			tv.setGravity(Gravity.CENTER);
			tv.setBackgroundResource(R.drawable.music_textview_border);
			
			textViews.add(tv);
			
			linearLayout.addView(tv);
			
			tv.measure(0, 0);
			viewWiths.add(tv.getMeasuredWidth());
			tv.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					int tag2 = (int) v.getTag();
					viewPager.setCurrentItem(tag2);
				}
			});
		}
		//画一个滚动的条
		LayoutParams viewLayoutParams=(LayoutParams) viewNav.getLayoutParams();
		viewLayoutParams.width=viewWiths.get(0);
		viewLayoutParams.height=30;
		viewNav.setBackgroundColor(0xFFFFFF);
		viewNav.setLayoutParams(viewLayoutParams);
		viewPager=(ViewPager) findViewById(R.id.ViewAdapter);
		MyFragmentAdapter myFragmentAdapter=new MyFragmentAdapter(getSupportFragmentManager(),datas2);
		viewPager.setAdapter(myFragmentAdapter);
		textViews.get(0).setTextColor(0xffff0000);
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int postion) {
				if (postion >= 0 && postion <textViews.size()) {
					textViews.get(postion).setTextColor(0xffff0000);
//					Log.e("MainActivity1", (postion)+"");
				}
				if (postion >= 1) {
					textViews.get(postion - 1).setTextColor(0xff050303);
//					Log.e("MainActivity2", (postion-1)+"");
				}
				if (postion < textViews.size() - 1) {
					textViews.get(postion + 1).setTextColor(0xff050303);
				}
			}
			
			@Override
			public void onPageScrolled(int postion, float arg1, int arg2) {
				// TODO Auto-generated method stub
				LayoutParams layoutParams = (LayoutParams) viewNav.getLayoutParams();
				//计算光标的位置
				int width=0;
				for (int i = 0; i < postion; i++) {
					width+=viewWiths.get(i);
				}
				width+=viewWiths.get(postion)*arg1;
				layoutParams.leftMargin=width;
				horizontalScrollView.scrollTo(layoutParams.leftMargin-20, 0);
			}
			
			@Override
			public void onPageScrollStateChanged(int postion) {
				
			}
		});
	}

	@Override
	public void OnFragmentPublicItemClick(String msg,int position) {
		// TODO Auto-generated method stub
		if(msg!=null){
			listMusicName = msg;
//			Log.e("MainActivity", listMusicName);
			viewPager.setCurrentItem(2);
		}
	}

	@Override
	public void OnFragmentSongItemClick(int position) {
		// TODO Auto-generated method stub
		if(String.valueOf(position)!=null){
//			Log.e("MainActivity", listMusicName);
			viewPager.setCurrentItem(3);
		}
	}
	
	
}
