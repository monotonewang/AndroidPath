package com.androidpath.activity.agstorge.loadmanagercontact171;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import androidx.cursoradapter.widget.SimpleCursorAdapter;
import android.util.Log;

//实现LoaderCallbacks接口，泛型规定的是loader加载的数据的类型
public class ShowContactActivity171 extends ListActivity implements LoaderCallbacks<Cursor>{
	
	private static final String DISPLAY_NAME = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;// "display_name"
	private static final String PHONE_NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;
	private static final String ID = ContactsContract.CommonDataKinds.Phone._ID;
	Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;//访问联系人数据库的data表中的电话号码数据的uri
//	private ContentResolver resolver;
	private SimpleCursorAdapter adapter;
	private LoaderManager loaderManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
//		resolver = getContentResolver();
		
//		cursor = resolver.query(uri, new String[]{ID, DISPLAY_NAME, PHONE_NUMBER}, null, null, null);
		//1.获得loadermanager对象
		loaderManager = getLoaderManager();
		
		//2.通过loadermanager对象创建一个loader对象，这个loader对象负责异步加载数据，并提交结果
		loaderManager.initLoader(1,//是loader的唯一标志
				null,//loadermanager在创建loader的时候需要传递给loader对象的参数，如果不需要参数，就填null,有参数要用bundle对象传递
				this);//回调的接口对象：这个接口中声明了创建loader对象的回调方法，要自定义类实现callback接口，重写方法
		
		
		
		//数据源先填空，等待loader来异步加载数据，加载完成后再置换数据
		adapter = new SimpleCursorAdapter(this, 
				android.R.layout.simple_list_item_2,
				null, 
				new String[]{DISPLAY_NAME, PHONE_NUMBER},
				new int[]{android.R.id.text1,android.R.id.text2},
				SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		
		setListAdapter(adapter);
	}

	
	//当需要创建loader的时候回调：当调用loaderManager.initLoader()的时候
	//参数一：要创建的loader的id
	//参数二：loaderManager传过来的数据
	//在这个方法中，我们创建一个loader并返回
	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		CursorLoader loader = null;
		loader = new CursorLoader(this,
				uri,//CursorLoader要加载的数据的uri
				new String[]{ID, DISPLAY_NAME, PHONE_NUMBER},
				null, null, null);
		Log.e("LoaderCallbacks", "onCreateLoader...");
		return loader;
	}

	//当loader对象异步加载完成数据的时候回调
	//参数一：就是loader对象，用于区分到底是谁的异步任务完成了
	//参数二：加载完成后传回的数据结果
	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
		// TODO Auto-generated method stub
		if (loader.getId() == 1) {
			adapter.swapCursor(cursor);
		}
		Log.e("LoaderCallbacks", "onLoadFinished...");
		
	}

	//当loader被重置的时候回调
	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
		Log.e("LoaderCallbacks", "onLoaderReset...");
	}

	
}
