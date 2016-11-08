package com.androidpath.storge.sql.sqlserverone151;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

public class MyServerContentProvider extends ContentProvider {

	private MyDBHelper dbHelper;

	//在系统创建provider对象的时候回调，第一访问的时候才会调用，在这进行创建helper对象，的操作
	@Override
	public boolean onCreate() {
		Log.e("MyServerContentProvider", "onCreate...");
		
		dbHelper = new MyDBHelper(getContext(), "test.db");
		
		return false;
	}

	//外界查询数据的时候回调:
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		Log.e("MyServerContentProvider", "query...");
		SQLiteDatabase database = dbHelper.getReadableDatabase();
		
		Cursor cursor = database.query("student", projection, selection, selectionArgs, null, null, sortOrder);
		//在这里不要关闭数据库
		return cursor;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	
	//回调方法，在外边的程序插入数据的时候回调
	//参数一：
	//参数二：就是客户端传过来的要插入的值
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		Log.e("MyServerContentProvider", "insert...");
		SQLiteDatabase database = dbHelper.getWritableDatabase();
		database.insert("student", null, values);
		database.close();
		return null;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
