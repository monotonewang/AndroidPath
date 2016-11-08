package com.androidpath.storge.sql.sqlserverone151;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDBHelper extends SQLiteOpenHelper {

	private static final String CREATETABLE = "CREATE TABLE student(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, score INTEGER)";

	public MyDBHelper(Context context,String dbName)
	{
		super(context, dbName, null, 1);
	}
	
	//创建数据表
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATETABLE);
		Log.d("MyDBHelper", "onCreate...");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
