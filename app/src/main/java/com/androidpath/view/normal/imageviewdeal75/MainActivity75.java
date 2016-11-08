package com.androidpath.view.normal.imageviewdeal75;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidpath.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity75 extends Activity {

	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main75);
		
		imageView = (ImageView) findViewById(R.id.imag_view);
	}
	
	public void clickSelect(View view) {
		//选择图库中的图片
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
		
		//设置需要获得数据的类型
		intent.setType("image/*");
		
		//启动系统应用，从系统中选择图片返回
		startActivityForResult(intent, 0);
	}
	
	//当用startActivityForResult启动的界面     从其他界面获得数据之后回调
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		//获得图片，   Uri其实就是找到图片的路径
		Uri uri = data.getData();
		
		//content://media/external.....----->
		Toast.makeText(this, uri.toString(), Toast.LENGTH_SHORT).show();
		
		//直接设置如果图片分辨率过高，就会出现oom
//		imageView.setImageURI(uri);
	
		//将图片进行压缩后再显示
		Bitmap bitmap = getBitmap(this, uri);
	
		imageView.setImageBitmap(bitmap);
	}

	private Bitmap getBitmap(Context context,  Uri uri) {
		// TODO Auto-generated method stub
		Bitmap bitmap = null;
		//contentResolver是专门对contentprovider提供的数据进行访问的对象
		ContentResolver contentResolver = context.getContentResolver();
		try {
			
			//利用contentResolver打开图片文件，返回流对象
			InputStream is = contentResolver.openInputStream(uri);
			
			
			//只加载图片的边缘，用于计算原始图片的大小----为了计算采样率
			Options opts = new Options();
			//设置只加载图片的边缘
			opts.inJustDecodeBounds = true;
			//参数一是流对象，参数二是外边距(构造方法填-1代表是不留边距)，参数三是用于存放图片的原始大小的对象
			BitmapFactory.decodeStream(is, new Rect(-1, -1, -1, -1), opts);
			
			//从options对象中获得原始图片的宽高，计算采样率
			int outWidth = opts.outWidth;
			int outHeight = opts.outHeight;
			
			//计算采样率
			int sampleSize = calculateSampleSize(outWidth, outHeight);
			Log.e("sample", " ----------"+sampleSize+"");
			
			//利用计算好的采样率，真正的加载图片
			opts.inSampleSize = sampleSize;
			//设置真正的加载图片
			opts.inJustDecodeBounds = false;
			
			//由于前面使用流的时候，流已经到达了末尾，所以真正加载图片的时候需要重新打开流
			is = contentResolver.openInputStream(uri);
			bitmap = BitmapFactory.decodeStream(is, new Rect(-1, -1, -1, -1), opts);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bitmap;
	}

	private int calculateSampleSize(int outWidth, int outHeight) {
		Point outSize = new Point();
		//按屏幕分辨率进行采样:按照图片和屏幕1：1的比例进行采样
		//获得屏幕分辨率,getsize（）方法的参数是用于保存屏幕的宽高的对象
		getWindowManager().getDefaultDisplay().getSize(outSize);
		
		//得到屏幕的宽高
		int x = outSize.x;
		int y = outSize.y;
		
		int xSample = outWidth/x;
		int ySample = outHeight/y;
		
		return xSample>ySample?xSample:ySample;
	}
}
