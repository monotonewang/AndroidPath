package com.androidpath.activity.aealert.notification112;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompat.Builder;
import android.view.View;
import android.widget.RemoteViews;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity112 extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main112);
	}
	
	public void clickCustomNotify(View view){
		Builder builder = new Builder(this)
		.setSmallIcon(R.drawable.ic_launcher);
		
		//创建通知视图对象，这个过程就是将自定义的布局文件实例化的过程
		RemoteViews views = new RemoteViews(getPackageName(), R.layout.custom_noti_layout112);
		//设置通知数据
		views.setTextViewText(R.id.title_text, "这是标题");
		views.setTextViewText(R.id.content_text, "这是正文");
		views.setImageViewBitmap(R.id.imageView,
				BitmapFactory.decodeResource(getResources(),//资源对象
						R.drawable.right_controller_download_pressed));//要转成bitmap对象的资源id
		//把自定义的通知视图设置给通知对象
		builder.setContent(views);
		
		NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

		manager.notify(3, builder.build());
	}
	
	
	
	//发出进度通知
	public void clickProgressNotify(View view) {
		//点击按钮后，下载文件，过程中发送通知更新通知的进度，下载完成时，发送通知提示
		final Builder builder = new Builder(this)
		.setSmallIcon(R.drawable.right_controller_download_pressed)
		.setContentTitle("下载")
		.setDefaults(Notification.DEFAULT_ALL)
		.setContentText("正在下载中，请稍候");
		
		final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		new Thread(){
			
			public void run() {
				try {
					URL url = new URL("http://a1.att.hudong.com/36/65/300001062059132062654118155_950.jpg");
					HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
					
					//让压缩格式无效
					urlConnection.setRequestProperty("Accept-Encoding", "identity");

					
					InputStream inputStream = urlConnection.getInputStream();
					File file = new File(Environment.getExternalStorageDirectory(), "zl.jpg");
					FileOutputStream fos  = new FileOutputStream(file);
					//获取总大小
					int total = urlConnection.getContentLength();
				//得到当前已经下载的字节数
					int currentSize = 0;
					//计算当前进度百分比
					int currentProgress;
					while (true) {
						byte[] buffer = new byte[10];
						int ret = inputStream.read(buffer, 0, buffer.length);
						if (ret == -1) {
							break;
						}
						currentSize += ret;
						
						currentProgress = (int)(currentSize*100.0/total);
						//更新通知的进度:参数一是最大进度值，参数二是当前进度，参数三只可意会不可言传
						builder.setProgress(100, currentProgress, false);
						
						notificationManager.notify(2, builder.build());
						//写入到sd卡，----文件  
						fos.write(buffer, 0, ret);
					}
					//下载完成时，提示
					builder.setContentText("下载完成！");
					Notification notification = builder.build();
					notification.flags |= Notification.FLAG_AUTO_CANCEL;
					notificationManager.notify(2,notification);
					fos.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}.start();
		
	}
	
	//发出普通通知
	public void clickNormolNotify(View view) {
//		1.创建NotificationCompat.Builder对象，进行一些UI设置
	/*    A small icon, set by setSmallIcon()
	    A title, set by setContentTitle()
	    Detail text, set by setContentText()*/
		Builder builder = new Builder(this)
		.setSmallIcon(R.drawable.right_controller_download_pressed)
		.setContentTitle("紧急通知")
		.setContentText("今天晚上不上课了！有事联系班主任！")
		//设置通知的标记位
		.setDefaults(Notification.DEFAULT_ALL);
		
		//如果想要点击通知的时候有响应，就要设置contentIntent
		Intent intent = new Intent(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel://110"));
		
		PendingIntent pendingIntent = PendingIntent.getActivity(this,//上下文
				0, //请求码
				intent,//普通的意图
				PendingIntent.FLAG_ONE_SHOT);//PendingIntent标识位
		builder.setContentIntent(pendingIntent );
		
//		2.通过NotificationCompat.Builder对象的build方法返回一个Notification通知对象
		Notification notification = builder.build();
		
		//要设置通知被点击后就自定消失，可以设置Notification的flag
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		//要设置通知在被用户点击之前一直响铃或振动，继续设置flag
		notification.flags |= Notification.FLAG_INSISTENT;
		
//		3.NotificationManager.notify()发出通知
		//获得通知管理器
		NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		
		//通过通知管理器，发出通知
		manager.notify(0, notification);
	}
	
	
	public void clickBigNotify(View view) {
//		Notification.Builder
		Builder builder = new Builder(this)
		.setSmallIcon(R.drawable.right_controller_download_pressed)
		.setContentTitle("最新消息")
		.setDefaults(Notification.DEFAULT_ALL)
		.setContentText("新华社电股市暴跌深交所提前下班");
		
		//数据源
		String[] items = {"阿里上市两年首次出现股票下跌，马云身家蒸发1000亿","白领炒股亏损跳楼","千锋即将在纽交所挂牌上市"};
		
		//大视图通知的style对象
		NotificationCompat.InboxStyle bigStyle = new NotificationCompat.InboxStyle();
		bigStyle.setBigContentTitle("股市暴跌深交所提前下班");
		
		for (int i = 0; i < items.length; i++) {
			bigStyle.addLine(items[i]);
		}
		
		builder.setStyle(bigStyle);
		
		Notification notification = builder.build();
		notification.flags |= Notification.FLAG_AUTO_CANCEL;
		
		NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
	
		manager.notify(1, notification);
	}
}
