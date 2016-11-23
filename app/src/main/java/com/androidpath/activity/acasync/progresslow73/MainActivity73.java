package com.androidpath.activity.acasync.progresslow73;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;


public class MainActivity73 extends BaseActivity {

	private ImageView imageView;
	int count = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main73);

		imageView = (ImageView) findViewById(R.id.imageview);
	}

	public void clickDownload(View view) {
		//下载图片
//		http://a3.att.hudong.com/50/30/01300000322847123114301689718.jpg
		//这是一个耗时操作，4.0以后明确规定网络连接必须在子线程中执行
		//2.创建异步任务实例
		MyAsyncTask73 myAsyncTask = new MyAsyncTask73(this, imageView);

		//3.开启异步任务
		myAsyncTask.execute("http://a1.att.hudong.com/36/65/300001062059132062654118155_950.jpg");

	}


}
