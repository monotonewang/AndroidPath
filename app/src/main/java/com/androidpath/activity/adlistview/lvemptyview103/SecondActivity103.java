package com.androidpath.activity.adlistview.lvemptyview103;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.androidpath.R;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity103 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second103);
		
		ListView listView = (ListView) findViewById(R.id.listView);
		
		List<String> list = new ArrayList<String>();
		/*list.add("这是第一项");
		list.add("这是第二项");
		list.add("这是第三项");*/
		
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, 
				android.R.layout.simple_list_item_1, list);
		
		listView.setEmptyView(findViewById(R.id.emptyView));
		
		listView.setAdapter(adapter);
	}
}
