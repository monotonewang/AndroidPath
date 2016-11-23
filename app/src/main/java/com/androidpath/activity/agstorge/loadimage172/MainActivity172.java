package com.androidpath.activity.agstorge.loadimage172;

import android.app.Activity;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

public class MainActivity172 extends BaseActivity implements LoaderCallbacks<Bitmap>{
	String urlString = "http://a3.att.hudong.com/50/30/01300000322847123114301689718.jpg";
	private LoaderManager loaderManager;
	private ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main172);
		imageView = (ImageView) findViewById(R.id.imageView);
		
		loaderManager = getLoaderManager();
	}
	
	public void clickDown(View view) {
		/*Bundle bundle = new Bundle();
		bundle.putString("urlString", urlString);*/
		loaderManager.initLoader(1, null, this);
	}

	@Override
	public Loader<Bitmap> onCreateLoader(int id, Bundle args) {
		MyDownLoadLoader loader = new MyDownLoadLoader(this, urlString);
		return loader;
	}

	@Override
	public void onLoadFinished(Loader<Bitmap> loader, Bitmap bitmap) {
		// TODO Auto-generated method stub
		if (bitmap != null) {
			imageView.setImageBitmap(bitmap);
		}
		
	}

	@Override
	public void onLoaderReset(Loader<Bitmap> loader) {
		// TODO Auto-generated method stub
		
	}
}
