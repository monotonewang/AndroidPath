package com.androidpath.activity.agstorge.asstes195;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity195 extends BaseActivity {

	private AssetManager assetManager;
	List<Bitmap> list = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main195);
		
		ImageView imageView = (ImageView) findViewById(R.id.imageview);

		// 引用asset中的资源:

		// 1.获得asset资源的管理器
		assetManager = getAssets();

		try {
			//列出asset资源指定目录下的文件的文件名，这个文件名不含路径
			String[] fileNames = assetManager.list("images");

			for (int i = 0; i < fileNames.length; i++) {
				Log.e("name", fileNames[i]);
				
				//打开文件的时候需要加上文件的路径
				InputStream inputStream = assetManager.open("images/"+fileNames[i]);
				Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
				
				list.add(bitmap);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		imageView.setImageBitmap(list.get(5));

	}
}
