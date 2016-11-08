package com.androidpath.storge.sql.sqlservertwo153;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

public class MyContentProvider extends ContentProvider {

	private MyDBHelper dbHelper;
	private static String authority = "com.example.day15providerserver2.mycontentprovider";
	//注册将来可能会用到的uri
	//构造方法的参数：如果没有匹配上，返回的值,一般就设置成-1，
	static private final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	private static final int STUALL = 1;
	private static final int TEAALL = 2;
	private static final int STU_NAME_ALL = 3;
	private static final int STU_SCORE_ALL = 4;
	private static final int STU_ID_SINGLE = 5;
	
	static{
		//参数一：就是authorities属性的字符串
		//参数二：要匹配的参数，可以是数据表名，
		//参数三：如果和这个uri匹配成功，返回的整形值
		
		//可以匹配客户端的uri："content://com.example.day15providerserver2.mycontentprovider/student"
		//如果通过uriMatcher的math方法匹配成功，返回1，可以根据uriMatcher的math方法返回值来做出不同的响应
		uriMatcher.addURI(authority, "student", STUALL);
		
		
		//可以匹配客户端的uri："content://com.example.day15providerserver2.mycontentprovider/student/name/任意文字"
		uriMatcher.addURI(authority, "student/name/*", STU_NAME_ALL);
		
		//可以匹配客户端的uri："content://com.example.day15providerserver2.mycontentprovider/student/score/任意数字"
		uriMatcher.addURI(authority, "student/score/#", STU_SCORE_ALL);
		
		//可以匹配客户端的uri："content://com.example.day15providerserver2.mycontentprovider/student/id/任意数字"
		uriMatcher.addURI(authority, "student/id/#", STU_ID_SINGLE);
		
		
		//可以匹配客户端的uri："content://com.example.day15providerserver2.mycontentprovider/teacher"
		//如果通过uriMatcher的math方法匹配成功，返回2，可以根据uriMatcher的math方法返回值来做出不同的响应
		uriMatcher.addURI(authority, "teacher", TEAALL);
	}

	@Override
	public boolean onCreate() {
		dbHelper = new MyDBHelper(getContext(), "test.db");
		Log.e("MyContentProvider", "onCreate...");
		return true;
		
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		SQLiteDatabase database = dbHelper.getReadableDatabase();
		Cursor cursor = null;
		//判断uri的类型，如果是STU_ID_SINGLE，就返回指定id值得记录
		int ret = uriMatcher.match(uri);
		if (ret == STU_ID_SINGLE) {
			//按照id查找：查找id字段等于指定值的记录
			//得到id号，id在uri中
			long id = ContentUris.parseId(uri);
			
			cursor = database.query("student", null, "_id=?", new String[]{id+"" }, null, null, sortOrder);
		}
		if (ret == STU_NAME_ALL) {
			//按照姓名查找：查找姓名字段中含有指定字符的记录
			//得到uri中携带的姓名
			String searchName = uri.getLastPathSegment();
			cursor = database.query("student", null, "name like ?", new String[]{"%"+searchName+"%"}, null, null, sortOrder);
		}
		if (ret == STUALL) {
			//查询学生表所有数据
			cursor = database.query("student", projection, selection, selectionArgs, null, null, sortOrder);
		}
		//给cursor注册一个内容观察者，当uri指向的数据发生改变的时候，会通知内容观察者，内容观察者会通知所有关联到这个cursor上的loader重新加载数据
		cursor.setNotificationUri(getContext().getContentResolver(), uri);
		return cursor;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	//返回值：应该返回代表这一条插入的数据的Uri
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		Log.e("MyContentProvider", "insert...");
		//对传入的uri进行匹配
		int ret = uriMatcher.match(uri);
		SQLiteDatabase database = dbHelper.getWritableDatabase();
		if (ret == STUALL) {
			//应该将数据插入学生表
			long id = database.insert("student", null, values);
			
			
			//当数据变化的时候，通过contentresolver对象通知内容观察者
			//参数二：null代表通知系统中的所有内容观察者
			getContext().getContentResolver().notifyChange(uri, null);
			
			return uri.withAppendedPath(uri, "/id/"+id);
		}
		else if (ret == TEAALL) {
			//应该将数据插入教师表
			database.insert("teacher", null, values);
		}
		else {
			Log.e("MyContentProvider", "匹配失败...");
		}
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
