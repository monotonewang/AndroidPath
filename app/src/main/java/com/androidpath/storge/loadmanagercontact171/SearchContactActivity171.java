package com.androidpath.storge.loadmanagercontact171;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.TextUtils;
import android.util.Log;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

import com.androidpath.R;

public class SearchContactActivity171 extends ListActivity implements
		LoaderCallbacks<Cursor> {

	private static final String DISPLAY_NAME = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME;// "display_name"
	private static final String PHONE_NUMBER = ContactsContract.CommonDataKinds.Phone.NUMBER;
	private static final String ID = ContactsContract.CommonDataKinds.Phone._ID;
	Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;// 访问联系人数据库的data表中的电话号码数据的uri
	private SimpleCursorAdapter adapter;

	String[] projects = new String[] { ID, DISPLAY_NAME, PHONE_NUMBER };
	private LoaderManager loaderManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 用的是listactivity，所有布局中一定要包含一个id为android:id="@android:id/list"的listview
		setContentView(R.layout.activity_search_contact171);
		SearchView searchView = (SearchView) findViewById(R.id.searchView);

		// 数据源先填空，等待loader来异步加载数据，加载完成后再置换数据
		adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_2, null, new String[] {
						DISPLAY_NAME, PHONE_NUMBER }, new int[] {
						android.R.id.text1, android.R.id.text2 },
				SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

		setListAdapter(adapter);
		loaderManager = getLoaderManager();

		loaderManager.initLoader(1, null, this);

		searchView.setOnQueryTextListener(new OnQueryTextListener() {

			@Override
			public boolean onQueryTextSubmit(String query) {
				return true;
			}

			@Override
			public boolean onQueryTextChange(String newText) {
				//如果searchview中没有文字了，就全部显示
				if (TextUtils.isEmpty(newText)) {
					//让loader重新加载数据
					loaderManager.restartLoader(1, null,
							SearchContactActivity171.this);
				} else {
					Bundle bundle = new Bundle();
					bundle.putString("key", newText);
					// 当输入的内容发生变化的时候，重新加载数据---由Loader对象进行---Loadermanager才是管理loader的，
					loaderManager.restartLoader(1, bundle,
							SearchContactActivity171.this);
				}
				return true;
			}
		});
	}

	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle bundle) {
		// TODO Auto-generated method stub
		CursorLoader cursorLoader = null;
		if (bundle == null) {
			cursorLoader = new CursorLoader(this, uri, projects, null, null,
					null);
			Log.e("LoaderCallbacks", "onCreateLoader...");
		}else {
			//如果bundle不为空，按照名字进行搜索
			//获得关键字
			String keyString = bundle.getString("key");
			cursorLoader = new CursorLoader(this, uri, projects,
					DISPLAY_NAME+" like ?", 
					new String[]{"%"+keyString+"%"},
					null);
		}

		return cursorLoader;
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
		// TODO Auto-generated method stub
		Log.e("LoaderCallbacks", "onLoadFinished...");
		adapter.swapCursor(data);
	}

	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
		// TODO Auto-generated method stub
		Log.e("LoaderCallbacks", "onLoaderReset...");
		adapter.swapCursor(null);
	}
}
