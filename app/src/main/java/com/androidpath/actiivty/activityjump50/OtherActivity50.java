package com.androidpath.actiivty.activityjump50;

import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.main.BaseActivity;

public class OtherActivity50 extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other50);
		TextView textView = (TextView) findViewById(R.id.textview);
		
		//获得启动它的组件传送的数据，显示在textview上
		Uri uri = getIntent().getData();
		String msg = uri.getScheme()+":"+uri.getHost()+"/"+uri.getPath();
		textView.setText(msg);
	}
}
