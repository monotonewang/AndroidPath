package com.androidpath.container.actionbar190.list193;

import android.app.ActionBar;
import android.app.ActionBar.OnNavigationListener;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.androidpath.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity193 extends Activity implements OnNavigationListener{

	private GridView gridView;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main193);
		
		gridView = (GridView) findViewById(R.id.gridview);
		
		
		List<HashMap<String, Integer>> gridviewData = new ArrayList<>();
		for (int i = 0; i <61 ; i++) {
			HashMap<String, Integer> hashMap = new HashMap<>();
			hashMap.put("imageId", R.drawable.a0+i);
			
			gridviewData.add(hashMap);
		}
		
		SimpleAdapter gridViewAdapter = new SimpleAdapter(this,
				gridviewData ,
				R.layout.item_layout,
				new String[]{"imageId"}, 
				new int[]{R.id.imageView1});
		gridView.setAdapter(gridViewAdapter);
		
		
		String[] titles = {"显示一列","显示两列","显示三列","显示四列"};
		//设置actionbar--下拉列表
		//1.创建数据适配器
		ArrayAdapter<String> actionAdapter = new ArrayAdapter<>(this,
				android.R.layout.simple_list_item_1,
				titles );
		
		//2.设置actionbar的下拉模式可用
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		
		//3.给actionbar设置下拉列表的事件监听器
		//参数一：就是actionbar的列表的适配器
		//参数二：是列表选项的事件回调接口对象
		actionBar.setListNavigationCallbacks(actionAdapter, this);
		
	}

	

	//但用户选中某个列表条的时候回调
	//参数一就是位置
	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		Log.e("onNavigationItemSelected", itemPosition+":"+itemId);
		gridView.setNumColumns(itemPosition+1);
		return true;
	}
}
