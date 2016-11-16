package com.androidpath.activity.agstorge.sql.sqlservertwo153;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.widget.ListView;

import com.androidpath.R;

public class MainActivity153 extends Activity {

	private ListView listView;
	private ContentResolver resolver;
	private String stuUriString = "content://com.example.day15providerserver2.mycontentprovider/student";
	private Cursor cursor;
	private SimpleCursorAdapter adapter;
	private Uri uri;
	private Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main153);
		listView = (ListView) findViewById(R.id.listView);
		
		//通过resolver查询provider提供的数据库中学生表的所有数据
		//用listview展示出来
		
		
		resolver = getContentResolver();
		uri = Uri.parse(stuUriString);
		
		
		handler = new Handler();//handler的创建只能在主线程上创建，如果实在是需要在子线程很重创建需要先调用：Looper.prepare();
		
		//创建内容观察者对象，重写数据变化的时候的处理方法
		ContentObserver observer = new ContentObserver(handler) {
			
			//这个方法在观察者所观察的数据发生变化的时候就回调----onChange是运行在子线程上的,子线程不能更新UI
			@Override
			public void onChange(boolean selfChange) {
				//重新查询数据
				Log.e("ContentObserver", "onChange....");
				
				cursor = resolver.query(uri, null, null, null, null);
//				adapter.swapCursor(cursor);//error:子线程不能更新UI
				
				
				//handler.post的功能就是让Runnable对象run方法运行在主线程上
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						adapter.swapCursor(cursor);
					}
				});
				
			}
			
		};
		
		//给内容访问者注册一个内容观察者
		resolver.registerContentObserver(uri,//要监视的uri:uri代表的是数据，其实就要监视的数据
				true, //填true代表非精确匹配，可以匹配第一个参数指定的数据的派生类型
				observer);//内容观察者对象，可以理解为一个监听器对象
		
		cursor = resolver.query(uri, null, null, null, null);
		
		adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_2, 
				cursor,
				new String[]{"name","score"}, 
				new int[]{android.R.id.text1,android.R.id.text2},
				SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		
		listView.setAdapter(adapter);
		
		
		
	}

}
