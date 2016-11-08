package com.androidpath.view.container.actionbar190.provider191;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;

import com.androidpath.R;

public class MainActivity191 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main191);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main191, menu);
		
		//1.找到子菜单对象
		MenuItem item = menu.findItem(R.id.provider);
		
		//2.通过子菜单对象获得provider对象
		ShareActionProvider provider = (ShareActionProvider) item.getActionProvider();
		provider.setShareIntent(getSharedIntent());
		
		return true;
	}

	private Intent getSharedIntent() {
		// TODO Auto-generated method stub
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.putExtra(Intent.EXTRA_TEXT, "要下课啦，明天要考试！");
		intent.setType("text/plain");
	/*	
		//设置intent的type属性：数据的类型
		intent.setType("image/*");
		File file = new File(Environment.getExternalStorageDirectory(), "zl.jpg");
		//获得代码文件的Uri对象：uri对象实现了Parcelable,可以用intent传递
		Uri uri = Uri.fromFile(file);
		intent.putExtra(Intent.EXTRA_STREAM, uri);*/
		return intent;
	}


}
