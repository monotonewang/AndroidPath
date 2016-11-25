package com.androidpath.activity.agstorge.fileStorgetwo132;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

import java.io.File;

public class MainActivity132 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main132);
    }

    @SuppressLint("NewApi")
    public void clickSize(View view) {
        File sdRoot = Environment.getExternalStorageDirectory();

        //api18以上使用  描述文件对象的一些信息的对象
        StatFs statFs = new StatFs(sdRoot.getAbsolutePath());
        double available = statFs.getAvailableBytes() / 1024.0 / 1024.0 / 1024.0;
        double total = statFs.getTotalBytes() / 1024.0 / 1024.0 / 1024.0;
        Toast.makeText(this, "total:" + total + " available:" + available, Toast.LENGTH_LONG).show();
    }

    public void clickPublic(View view) {
        //公有目录是任何应用都可以访问的
        File picPublicFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        Toast.makeText(this, picPublicFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
    }

    public void clickLocal(View view) {
        //私有目录只有本应用程序能访问
//		File localFile = getFilesDir();//内部存储的本应用的私有目录，由于内部存储空间有限，所以大文件最好放在外部存储中
        File localFile = getExternalFilesDir(Environment.DIRECTORY_MUSIC);//外部存储的本应用的私有目录
        Toast.makeText(this, localFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
    }

    public void clickCreateDir(View view) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File sdRoot = Environment.getExternalStorageDirectory();
            Toast.makeText(this, sdRoot.getAbsolutePath(), Toast.LENGTH_LONG).show();

            File myDirFile = new File(sdRoot, "mydir");
            if (!myDirFile.exists()) {
                boolean isCreated = myDirFile.mkdir();
                if (isCreated) {
                    Log.e("isCreated", "成功");
                } else {
                    Log.e("isCreated", "失败");
                }

            }
        } else {
            Toast.makeText(this, "未找到sd卡！", Toast.LENGTH_LONG).show();
        }


    }
}
