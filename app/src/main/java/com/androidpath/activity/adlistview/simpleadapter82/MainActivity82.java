package com.androidpath.activity.adlistview.simpleadapter82;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.androidpath.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity82 extends Activity {

	private List<HashMap<String, Object>> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main82);
		
		ListView listView = (ListView) findViewById(R.id.listview);
		
		//数据源：图片  菜名
		int[] images = {R.drawable.f058,R.drawable.f059,
				R.drawable.f060,R.drawable.f061,R.drawable.f062};
		String[] names = {"蛋炒饭","拿破仑","超级大西瓜","拉菲","大闸蟹"};
		
		
		list = new ArrayList<>();
		
		for (int i = 0; i < names.length; i++) {
			HashMap<String, Object> map = new HashMap<>();
			map.put("itemImage", images[i]);
			map.put("itemText", names[i]);
			list.add(map);
		}
		
		//匹配数据到子视图
		SimpleAdapter simpleAdapter = new SimpleAdapter(this,
				list,//数据：必须是map组成的list
				R.layout.item_layout82,//子视图布局
				new String[]{"itemImage","itemText"},//map中的关键字组成的数组
				new int[]{R.id.item_text, R.id.item_text});//子视图布局中的控件的id组成的数组，要和前一个参数一一对应
		
		listView.setAdapter(simpleAdapter);
		
		//注册listview列表条点击事件的监听器：对比spinner的监听器是监听的列表条选中事件
		listView.setOnItemClickListener(new OnItemClickListener() {

			
			//当列表条被单击的时候回调
			//参数一：被点击的item所属的listview
			//参数二：被点击的item的View对象
			//参数三：被点击的item的位置
			//参数四：也是位置
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity82.this, "选中了："+list.get(position).get("itemText"), Toast.LENGTH_LONG).show();
			}
		});
	}
}
