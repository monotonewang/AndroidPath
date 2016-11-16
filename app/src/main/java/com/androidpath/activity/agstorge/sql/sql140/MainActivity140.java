package com.androidpath.activity.agstorge.sql.sql140;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.androidpath.R;

public class MainActivity140 extends Activity {
	// CREATE TABLE tb_newwords (_id INTEGER PRIMARY KEY AUTOINCREMENT , words  , detail );
	private static final String TABALENAME = "person";
	private static final String CREATETABLE = "CREATE TABLE " + TABALENAME
			+ "(_id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT, age INTEGER)";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main140);
	}

	// 创建数据库
	public void clickCreateOrOpenDb(View view) {
		// 方法一：用SQLiteDatabase类的静态方法创建数据库,参数一是数据库文件的文件名，这个文件名必须是全名,可以指定保存到外部存储或是保存到内部存储
		// SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase("/data/data/包名/xx.db", factory);

		// 方法二：用上下文对象的方法创建数据库,参数一是数据库文件的文件名,这个文件名不需要加路径，系统会自动创建到自己的内部存储目录/data/data/包名/
		// 参数二：模式，一般用MODE_PRIVATE，
		// 参数三：游标工厂对象，一般穿null,代表系统自动提供游标工厂
		SQLiteDatabase db = this.openOrCreateDatabase("test.db", MODE_PRIVATE,
				null);
		db.close();
	}

	// 创建数据表
	public void clickCreateTable(View view) {
		SQLiteDatabase db = this.openOrCreateDatabase("test.db", MODE_PRIVATE,
				null);
		db.execSQL(CREATETABLE);
		db.close();
	}

	// 插入数据
	public void clickInsert(View view) {
		SQLiteDatabase db = this.openOrCreateDatabase("test.db", MODE_PRIVATE,
				null);
		ContentValues values = new ContentValues();
		// values.put("_id", "1");
		values.put("name", "xusha");
		
		// 参数一：数据表名
		// 参数二：要插入的空数据放在哪个列，如果数据不为空，就填null
		// 参数三：要插入的数据对象
		db.insert(TABALENAME, null, values);
		
		ContentValues values2 = new ContentValues();
		// values.put("_id", "1");
		values2.put("name", "xulaoda");
		values2.put("age", 20);
		// 参数一：数据表名
		// 参数二：要插入的空数据放在哪个列，如果数据不为空，就填null
		// 参数三：要插入的数据对象
		db.insert(TABALENAME, null, values2);
		db.close();
	}

	// 查询数据
	public void clickQuery(View view) {
		SQLiteDatabase db = this.openOrCreateDatabase("test.db", MODE_PRIVATE,
				null);
		
		 /*  public Cursor query(String table, String[] columns, String selection,
		            String[] selectionArgs, String groupBy, String having,
		            String orderBy)*/
		
		/*//方法一：返回值是cursor:借助游标对象可以获得数据
		Cursor cursor = db.query(TABALENAME,//表名
				null,//要查询的列名，是一个数组，如果填null就代表查询所有列
				"name=?",//查询的条件,null全部查,？是占位符，会被后面的参数的数组元素替换
				new String[]{"xusha"},//查询条件的参数
				null, //分组
				null,//分组的参数
				null);//排序的方式 null是默认排序
*/		
		//方法二：
//		select * from exam_books where id<20;
		/*Cursor cursor = db.rawQuery("select * from "+TABALENAME+" where name=?", //sql语句
				new String[]{"xusha"});//查询的条件的置换
*/		
		
		
		//查询所有记录
		Cursor cursor = db.rawQuery("select * from "+TABALENAME, //sql语句
				null);//查询的条件的置换
		//将游标移动到第一条
		cursor.moveToFirst();
		
		//循环读取数据
		while (!cursor.isAfterLast()) {
			//获得列的下标
			int nameIndex = cursor.getColumnIndex("name");
			
			//参数是:要查询的列的下标
			String name = cursor.getString(nameIndex);
			
			//获得列的下标
			int ageIndex = cursor.getColumnIndex("age");
			
			//参数是:要查询的列的下标：
			int age = cursor.getInt(ageIndex);
			
			Log.e("查询到数据：", "name:"+name+" age:"+age);
			
			//移动游标到下一条
			cursor.moveToNext();
		}
		db.close();
		
	}

	// 更新数据
	public void clickUpdate(View view) {
		SQLiteDatabase db = this.openOrCreateDatabase("test.db", MODE_PRIVATE,
				null);
		
		ContentValues values = new ContentValues();
		values.put("name", "xulaosan");
		db.update(TABALENAME, 
				values, //新的值
				"_id=?", //条件
				new String[]{"2"});//条件的参数
		
		db.close();
	}

	// 删除数据
	public void clickDelete(View view) {
		SQLiteDatabase db = this.openOrCreateDatabase("test.db", MODE_PRIVATE,
				null);
		
		db.delete(TABALENAME, "name=?", new String[]{"xusha"});
		db.close();
	}
}
