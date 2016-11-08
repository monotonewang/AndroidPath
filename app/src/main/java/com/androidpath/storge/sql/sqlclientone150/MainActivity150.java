package com.androidpath.storge.sql.sqlclientone150;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.androidpath.R;

public class MainActivity150 extends Activity {

	// uri字符串的结构：
	// 第一部分content：//类似一种协议，只要是要访问contentprovider提供的数据就定义成 content：//
	// 第二部分是主机名，需要与要访问的contentprovider的注册清单的authorities属性匹配
	private String uriString = "content://com.androidpath.sql.sqlserver151.myservercontentprovider";
	private ContentResolver resolver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main150);
		resolver = getContentResolver();
	}

	public void clickInsert(View view) {
		// 把数据插入到服务器的数据库

		Uri uri = Uri.parse(uriString);
		ContentValues values = new ContentValues();
		values.put("name", "xiaqi");
		values.put("score", 59);

		// 2.调用方法插入数据
		resolver.insert(uri, values);
	}

	public void clickQuery(View view) {
		
		//参数一：uri对象，他是到系统中去查找contentprovider对象的依据，会到清单中匹配authorities属性和uri字符串一致的provider。
		Cursor cursor = resolver.query(Uri.parse(uriString), new String[]{"name","score"}, null, null, null);
		
		cursor.moveToFirst();
		while (true) {
			String name = cursor.getString(cursor.getColumnIndex("name"));
			int score = cursor.getInt(cursor.getColumnIndex("score"));
			Log.d("数据", name+":"+score);
			
			boolean isNotLast = cursor.moveToNext();
			if (!isNotLast) {
				break;
			}
		}
	
	}

}
