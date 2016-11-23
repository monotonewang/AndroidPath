package com.androidpath.activity.acasync.getimagestrong72;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

public class MainActivity72 extends BaseActivity {

	private ImageView imageView;
	int count = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main72);

		imageView = (ImageView) findViewById(R.id.imageview);
	}

	public void clickDownload(View view) {
		// 下载图片
		// http://a3.att.hudong.com/50/30/01300000322847123114301689718.jpg
		// 这是一个耗时操作，4.0以后明确规定网络连接必须在子线程中执行
		// 2.创建异步任务实例
		MyAsyncTask72 myAsyncTask = new MyAsyncTask72(this);

		// 给异步任务设置监听器，这个监听器用于监听下载完成事件
		myAsyncTask
				.setOnDownLoadCompletedListener(new MyAsyncTask72.OnDownLoadCompletedListener() {

					@Override
					public void onDownLoadCompleted(Bitmap bitmap) {
						// TODO Auto-generated method stub
						// 显示在imageview上
						imageView.setImageBitmap(bitmap);
					}
				});

		// 3.开启异步任务
		myAsyncTask
				.execute("http://a1.att.hudong.com/36/65/300001062059132062654118155_950.jpg");

		/*
		 * Button button = new Button(this); button.setOnClickListener(new
		 * OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { // TODO Auto-generated method
		 * stub
		 * 
		 * } });
		 */

	}

}
