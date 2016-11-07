package com.androidpath.async.demoone70;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;

import com.androidpath.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


//有问题的代码
public class MainActivity70 extends Activity {

    private ImageView imageView;
    int count = 0;
    private Bitmap bitmap;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main70);

        imageView = (ImageView) findViewById(R.id.imageview);
    }

    public void clickDownload(View view) {
      /*
		while (true) {
			SystemClock.sleep(100);
			count ++;
			Log.e("count", count+"");
			if (count == 100) {
				break;
			}
		}
		*/

        //下载图片
//		http://a3.att.hudong.com/50/30/01300000322847123114301689718.jpg

        new Thread() {
            public void run() {
                try {
                    URL url = new URL("http://a3.att.hudong.com/50/30/01300000322847123114301689718.jpg");
                    //建立连接
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    InputStream inputStream = connection.getInputStream();

                    bitmap = BitmapFactory.decodeStream(inputStream);

//                    //显示到imageview
//                    imageView.setImageBitmap(bitmap);  //error:子线程不能更新UI
                    Message message=new Message();
                    message.what=0x01;
                    handler.sendMessage(message);

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            ;

        }.start();

        //显示到imageview
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
		        switch (msg.what){
                    case 0x01:
                        //显示到imageview
                        imageView.setImageBitmap(bitmap);
                        break;
                }
            }

        };


    }
}
