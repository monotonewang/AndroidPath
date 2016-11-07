package com.androidpath.async.getimagestrong72;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.androidpath.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//1.定义类继承于asynctask
//三个泛型：
/*Params:主线程要传给子线程的参数的类型-----主线程需要传网络地址---String
 *Progress：进度数据的类型---不显示进度---Void
 *Result：子线程执行结束后返回给主线程的结果的数据类型----返回的是一张图片---Bitmap
 * */
public class MyAsyncTask72 extends AsyncTask<String, Integer, Bitmap> {

	private Context context;
	private ProgressDialog dialog;
	private Integer curretProgress;
	private long totalSize;
	private long currentSize = 0;
	private OnDownLoadCompletedListener listener;


	public MyAsyncTask72(Context context) {
		// TODO Auto-generated constructor stub
		this.context = context;
	}

	// 在UI线程上执行的，主要做一些界面的准备工作,最先执行
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		// Toast.makeText(MainActivity72.this, "onPreExecute", 0).show();
		Log.e("MyAsyncTask72", "onPreExecute");

		// 创建一个进度显示的控件
		dialog = new ProgressDialog(context);
		//进行初始化
		dialog.setTitle("下载美图");
		dialog.setIcon(R.drawable.ic_launcher);
		dialog.setMessage("正在下载，不要着急。。。。。。");
		
		//进度条默认是环状的，这里要显示进度，就设置成条状的
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		dialog.setMax(100);
		
		//开始显示
		dialog.show();
	}

	// 在子线程中执行，参数就是主线程传过来的数据，返回值是线程执行完任务的时候返回的结果，这个结果被返回到onPostExecute方法的参数中
	@Override
	protected Bitmap doInBackground(String... params) {
		// TODO Auto-generated method stub
		Bitmap bitmap = null;
		// 获得url字符串
		String urlString = params[0];
		try {
			URL url = new URL(
					"http://a1.att.hudong.com/36/65/300001062059132062654118155_950.jpg");
			// 建立连接
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			
			//默认情况下，服务端是用gzip压缩的形式放置的数据，
			//这时如果我们调用connection.getContentLength()就无法知道要读取得数据的长度，会返回-1
			//要通过connection.getContentLength()方法获得要读的数据的长度，需要将gzip压缩设置为无效
			//可以调用setRequestProperty（）方法来设置gzip压缩无效
			connection.setRequestProperty("Accept-Encoding", "identity");
			connection.setDoInput(true);
			connection.connect();

			InputStream inputStream = connection.getInputStream();
			//创建一个内存流，用于保存从网络中下载的数据
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			//获得总字节数
			totalSize = connection.getContentLength();
			Log.e("total", totalSize+"");

			// 在下载过程中随时通知更新进度----回调onProgressUpdate方法
			int ret = 0;
			while (true) {
				byte[] buf = new byte[1];
				//读入数据
				ret = inputStream.read(buf, 0, buf.length);
				if (ret == -1) {
					break;
				}
				
				//获得当前已经下载的字节数
				currentSize  += ret;
				
				//当前进度：最大值是100，其实要算百分比
				//当前已经下载的字节数÷总字节数×100
				curretProgress = (int)(currentSize*100.0/totalSize);
//				Log.d("curretProgress", curretProgress+"==========");
				//通知更新进度
				publishProgress(curretProgress);
				
				//写入到内存流
				baos.write(buf, 0, ret);
				
			}
			
			byte[] byteArray = baos.toByteArray();
			
			bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

			/*bitmap = BitmapFactory.decodeStream(inputStream);*/

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Toast.makeText(MainActivity72.this, "doInBackground"+urlString,
		// 0).show();
		Log.e("MyAsyncTask72", "doInBackground");

		return bitmap;
	}

	// 在UI线程上执行，用于更新进度，当在doInBackground调用 publishProgress(Progress...)方法的时候回调
	@Override
	protected void onProgressUpdate(Integer... values) {
		// TODO Auto-generated method stub
		// Toast.makeText(MainActivity72.this, "onProgressUpdate", 0).show();
		super.onProgressUpdate(values);
//		Log.e("MyAsyncTask72", "onProgressUpdate:"+values[0]);

		// 更新进度显示控件的进度
		dialog.setProgress(values[0]);

		
	}

	// 在UI线程上执行，参数是子线程返回的结果，最后执行
	@Override
	protected void onPostExecute(Bitmap result) {
		// TODO Auto-generated method stub
		// Toast.makeText(MainActivity72.this, "onPostExecute", 0).show();
		Log.e("MyAsyncTask72", "onPostExecute");
		// 停止进度显示
		dialog.dismiss();

		// 回调客户端的监听器对象中的方法，更新UId
//		imageView.setImageBitmap(result);
		listener.onDownLoadCompleted(result);
		
		//回调客户端的activity的事件处理方法
		
		super.onPostExecute(result);
	}
	
	//声明接口，这个接口由客户端实现，客户重写其中的事件处理方法
	public interface OnDownLoadCompletedListener {
		void onDownLoadCompleted(Bitmap bitmap);
	}
	
	public void setOnDownLoadCompletedListener(OnDownLoadCompletedListener listener) {
		this.listener = listener;
	}
	
	

}