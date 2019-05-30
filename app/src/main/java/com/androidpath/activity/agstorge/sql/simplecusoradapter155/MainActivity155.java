package com.androidpath.activity.agstorge.sql.simplecusoradapter155;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.cursoradapter.widget.SimpleCursorAdapter;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnCloseListener;
import android.widget.SearchView.OnQueryTextListener;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

import java.util.regex.Pattern;

public class MainActivity155 extends BaseActivity {

	private static final String uriString = "content://com.androidpath.sql.mycontentprovider/student";
	private ListView listView;
	private ContentResolver resolver;
	private Cursor cursor;
	private SimpleCursorAdapter adapter;
	private SearchView searchView;

	private boolean isNumber(String newText) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("[0-9]+");

		return pattern.matcher(newText).matches();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main155);

		listView = (ListView) findViewById(R.id.listview);
		searchView = (SearchView) findViewById(R.id.searchview);

		Uri uri = Uri.parse(uriString);

		resolver = getContentResolver();
		cursor = resolver.query(uri, null, null, null, null);

		adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_2, cursor, new String[] {
						"name", "score" }, new int[] { android.R.id.text1,
						android.R.id.text2 },
				SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

		listView.setAdapter(adapter);

		searchView.setOnQueryTextListener(new OnQueryTextListener() {

			// 这个方法是在输入的内容提交的时候回调，参数就是输入的文本
			@Override
			public boolean onQueryTextSubmit(String query) {
				// TODO Auto-generated method stub
				Log.e("onQueryTextSubmit", query);
				return true;
			}

			// 这个方法是在输入的内容发生变化的时候回调，参数就是当前的文本
			@Override
			public boolean onQueryTextChange(String newText) {
				// TODO Auto-generated method stub
				Log.e("onQueryTextChange", newText + "------");

				if (!TextUtils.isEmpty(newText)) {
					// 输入变化的时候重新查询数据
					// 如果是数字的话，就按id搜索
					if (isNumber(newText)) {
						String newUriString = uriString + "/id/" + newText;
						cursor = resolver.query(Uri.parse(newUriString), null,
								null, null, null);
						adapter.swapCursor(cursor);
					} else {
						String newUriString = uriString + "/name/" + newText;
						cursor = resolver.query(Uri.parse(newUriString), null,
								null, null, null);
						adapter.swapCursor(cursor);
					}
				} else {
					cursor = resolver.query(Uri.parse(uriString), null, null,
							null, null);
					adapter.swapCursor(cursor);
				}

				return true;
			}

		});

		// 取消搜索
		searchView.setOnCloseListener(new OnCloseListener() {

			@Override
			public boolean onClose() {
				// TODO Auto-generated method stub
				Log.e("OnCloseListener", "onClose");
				cursor = resolver.query(Uri.parse(uriString), null, null, null,
						null);
				adapter.swapCursor(cursor);
				return true;
			}
		});

	}
}
