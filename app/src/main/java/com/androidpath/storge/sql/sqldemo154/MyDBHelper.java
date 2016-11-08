package com.androidpath.storge.sql.sqldemo154;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDBHelper extends SQLiteOpenHelper {
	private static final String TABALENAME = "person";
	private static final String CREATETABLE = "CREATE TABLE " + TABALENAME
			+ "(_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT, age INTEGER)";
	/*//构造方法：
	//参数一：是上下文
	//参数二：数据库的文件名
	//参数三：游标工厂
	//参数四：版本号
	//参数五：错误处理器--不关心
	public MyDBHelper(Context context, String name, CursorFactory factory,
			int version, DatabaseErrorHandler errorHandler) {
		super(context, name, factory, version, errorHandler);
	}*/
		
	//构造方法，系统会自动创建数据库文件
	public MyDBHelper(Context context, String name, int version) {
		
		super(context, name, null, version);
		
		Log.e("MyDBHelper", "构造方法");
	}

	//在第一次打开数据库的时候调用，下一次使用的时候就不会调用这个方法
	//就在这个方法中创建数据表，
	//参数：就是系统根据用户传入的数据库的名字创建出来的数据库的对象
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATETABLE);
		Log.e("MyDBHelper", "onCreate");
	}

	//当数据库的版本更新的时候回调，当版本号发生变化的时候
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		//更新表结构或者删除旧的表
		db.execSQL("DROP TABLE IF EXISTS "+TABALENAME);
		Log.e("MyDBHelper", "onUpgrade");
		//自己调用
		onCreate(db);
	}

}
