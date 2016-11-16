package com.androidpath.activity.adlistview.baseadapterpack100;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.androidpath.R;
import com.androidpath.activity.adlistview.baseadapterpack100.adapter.MyAdapter;
import com.androidpath.activity.adlistview.baseadapterpack100.bean.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity100 extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		List<Person> list = new ArrayList<>();
		list.add(new Person("xusha", R.drawable.img01));
		list.add(new Person("yangyunkuan", R.drawable.img02));
		list.add(new Person("zhuwei", R.drawable.img03));
		list.add(new Person("qiusan", R.drawable.img04));
		list.add(new Person("wenyi", R.drawable.img05));
		list.add(new Person("wuhan", R.drawable.img06));
		list.add(new Person("wangbang", R.drawable.img07));
		list.add(new Person("xiaqi", R.drawable.img08));
		list.add(new Person("wugui", R.drawable.img09));
		
		MyAdapter adapter = new MyAdapter(this, list);
		setListAdapter(adapter);
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		Toast.makeText(this, "点击了第"+position+"条item", Toast.LENGTH_SHORT).show();

	}

}
