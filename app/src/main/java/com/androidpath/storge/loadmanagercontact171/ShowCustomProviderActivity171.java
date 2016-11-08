package com.androidpath.storge.loadmanagercontact171;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

public class ShowCustomProviderActivity171 extends ListActivity implements LoaderCallbacks<Cursor>{
	private String stuUriString = "content://com.example.providerserver2.mycontentprovider/student";
	private SimpleCursorAdapter adapter;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LoaderManager loaderManager = getLoaderManager();
		
		loaderManager.initLoader(1, null, this);
		adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, null,
				new String[]{"name","score"}, 
				new int[]{android.R.id.text1,android.R.id.text2},
				SimpleCursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
		setListAdapter(adapter);
	}

	@Override
	public Loader<Cursor> onCreateLoader(int id, Bundle args) {
		// TODO Auto-generated method stub
		CursorLoader loader = new CursorLoader(this, Uri.parse(stuUriString), null, null, null, null);
		
		return loader;
	}

	@Override
	public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
		// TODO Auto-generated method stub
		adapter.swapCursor(data);
	}

	@Override
	public void onLoaderReset(Loader<Cursor> loader) {
		// TODO Auto-generated method stub
		adapter.swapCursor(null);
	};
}
