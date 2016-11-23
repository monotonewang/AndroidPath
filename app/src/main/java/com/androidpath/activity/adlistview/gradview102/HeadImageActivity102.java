package com.androidpath.activity.adlistview.gradview102;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;
import com.androidpath.activity.adlistview.gradview102.bean.Person;

import java.util.ArrayList;
import java.util.List;

public class HeadImageActivity102 extends BaseActivity implements OnItemClickListener {

	private List<Person> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_head_image102);
		list = new ArrayList<>();
		list.add(new Person("xusha", R.drawable.img01));
		list.add(new Person("yangyunkuan", R.drawable.img02));
		list.add(new Person("zhuwei", R.drawable.img03));
		list.add(new Person("qiusan", R.drawable.img04));
		list.add(new Person("wenyi", R.drawable.img05));
		list.add(new Person("wuhan", R.drawable.img06));
		list.add(new Person("wangbang", R.drawable.img07));
		list.add(new Person("xiaqi", R.drawable.img08));
		list.add(new Person("wugui", R.drawable.img09));
		
		PersonAdapter adapter = new PersonAdapter(this, list);

		GridView headListGridView = (GridView) findViewById(R.id.head_gridview);
		headListGridView.setAdapter(adapter);

		headListGridView.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		//depend on user slect return back image
		Intent intent = getIntent();
		intent.putExtra("selectedId", list.get(position).getImageId());
		
		setResult(1, intent);
		
		finish();
		
	}
}
