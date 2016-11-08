package com.androidpath.view.listview.lvemptyview103;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.androidpath.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity103 extends ListActivity {

	private List<String> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//如果使用的是ListActivity的话，这个类会自动提供一个布局，其中含有一个listview
		//也可以自己去绑定布局,在自己的布局中需要提供一个listview，并且id号必须注册为指定的android.R.id.list, "@android:id/list" 
		setContentView(R.layout.activity_main103);
		
		list = new ArrayList<String>();
		list.add("这是第一项");
		list.add("这是第二项");
		list.add("这是第三项");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, 
				android.R.layout.simple_list_item_1, list);
		
		//直接调用方法来设置适配器给那个默认的listview,系统还会自动给listview设置监听器，只需要重写onListItemClick方法就可处理列表点击事件了
		setListAdapter(adapter);
		
	}
	
	//在点击列表条的时候回调
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Toast.makeText(this, "点击了"+list.get(position), 0).show();
	}
}
