package com.androidpath.listview.listviewjoke90;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.androidpath.R;
import com.androidpath.listview.listviewjoke90.util.MyHttpUtil;


public class BitmapAsynTask extends AsyncTask<String, Void, Bitmap> {

	private ImageView picImageView;
	private String downUrl;

	public BitmapAsynTask(ImageView picImageView) {
		// TODO Auto-generated constructor stub
		this.picImageView = picImageView;
	}

	@Override
	protected Bitmap doInBackground(String... params) {
		// TODO Auto-generated method stub
		Bitmap bitmap = MyHttpUtil.downloadBitmap(params[0]);
		//获得异步任务执行下载的对应的url
		downUrl = params[0];
		return bitmap;
	}
	
	@Override
	protected void onPostExecute(Bitmap bitmap) {
		//判断当前显示的imageview是不是和下载完成的图片是对应关系的
		//可以通过发起异步任务的时候的url和下载完成时的url是否相同来判断
		
		//获取当前imagview要显示的图片的url
		String url = (String) picImageView.getTag();
		if (downUrl.equals(url)) {
			//设置成可见
			picImageView.setImageResource(R.drawable.ic_launcher);
			picImageView.setVisibility(View.VISIBLE);
			picImageView.setImageBitmap(bitmap);
		}else {
			Log.e("BitmapAsynTask", "图片错位了！");
		}
	}

}
