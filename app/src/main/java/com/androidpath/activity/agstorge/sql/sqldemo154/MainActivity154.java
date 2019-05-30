package com.androidpath.activity.agstorge.sql.sqldemo154;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.cursoradapter.widget.SimpleCursorAdapter;
import android.widget.ListView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;
import com.androidpath.activity.agstorge.sql.sqldemo154.bean.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity154 extends BaseActivity {
	private static final String TABALENAME = "person";
	
	private SQLiteDatabase db;
	private List<Person> list;
	private int index = 0;

	private Cursor cursor;

	private SimpleCursorAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main154);
		ListView listView = (ListView) findViewById(R.id.listView);
		
		initData();
		/*1.定义类继承SQLiteOpenHelper，重写构造方法，onCreate方法
		2.在需要使用数据库的时候，创建SQLiteOpenHelper的实例，通过这个对象获得数据库对象
		3.调用数据库对象的方法进行CRUD操作
		*/
		
		//如果是第一次使用软件 ，就会调用MyDBHelper对象中的onCreate方法，通过getWritableDatabase方法返回一个数据库对象
		//如果不是第一次，就通过getWritableDatabase方法直接返回一个数据库对象
		MyDBHelper myDBHelper = new MyDBHelper(this, "my.db", 2);
		db = myDBHelper.getWritableDatabase();
		//不推荐使用直接创建数据库的方式
		//推荐使用SQLiteOpenHelper对数据库进行管理
//		db = openOrCreateDatabase("test.db", MODE_PRIVATE, null);
//		db.execSQL(CREATETABLE);
		
		cursor = db.rawQuery("select * from "+TABALENAME, null);
		
		adapter = new SimpleCursorAdapter(this,//上下文
				android.R.layout.simple_list_item_2, //子视图布局
				cursor,//数据源：是游标
				new String[]{"name","age"},//数据库表中的列名
				new int[]{android.R.id.text1,android.R.id.text2}, //数据要匹配到的控件
				SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);//就填这个值
		listView.setAdapter(adapter);
	}

	private void initData() {
		list = new ArrayList<>();
		list.add(new Person("xusha", 18));
		list.add(new Person("xulaoda", 28));
		list.add(new Person("xulaoer", 20));
		list.add(new Person("xulaosan", 16));
		list.add(new Person("xiaqi", 22));
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main190, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.insert_item) {
//			if (list.size() > index) {
//				ContentValues values = new ContentValues();
//				values.put("name", list.get(index ).getName());
//				values.put("age", list.get(index).getAge());
//				db.insert(TABALENAME, null, values );
//
//				//数据变化后，重新查询数据
//				cursor = db.rawQuery("select * from "+TABALENAME, null);
//				//更换数据
//				adapter.swapCursor(cursor);
//
//				index++;
//			}else {
//				Toast.makeText(this, "数据增加完成，集合中已经没有数据了", 0).show();
//			}
//
//		}
//		return  true;
//	}
}
