package com.androidpath.activity.activityjump50;

import android.Manifest;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Toast;

import com.androidpath.R;
import com.androidpath.main.ApplicationMain;
import com.androidpath.main.BaseActivity;

import java.io.File;


public class MainActivity50 extends BaseActivity {

    private final Intent intentCallPhone = new Intent(Intent.ACTION_CALL);
    private final int callPhonePerssion = 1;
    private String TAG = "MainActivity50";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main50);
    }

    // 显式跳转到本应用的其他界面
    public void clickThis(View view) {
        // Intent intent = new Intent(this, SecondActivity50.class);

		/*
         * Intent intent = new Intent(); ComponentName component = new
		 * ComponentName(this, SecondActivity50.class);
		 * intent.setComponent(component );
		 */

        Intent intent = new Intent();
        // 参数一是包名的字符串表示，参数二是类名的字符串表示,注意，类名必须写全名
        ComponentName component = new ComponentName("com.example.day5test",
                "com.example.day5test.SecondActivity50");
        intent.setComponent(component);

        startActivity(intent);
    }

    // 隐式跳转到本应用的其他界面
    public void clickThis2(View view) {
        Intent intent = new Intent();
        intent.setAction("changfajiyao");
        startActivity(intent);
    }

    // 隐式跳转到别的应用的界面
    public void clickOther(View view) {
        Intent intent = new Intent();
        intent.setAction("changtuimeinv");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    // 显式启动拨号
    public void clickDail(View view) {
        Intent intent = new Intent();
        // com.android.dialer/.DialtactsActivity
        ComponentName component = new ComponentName("com.android.dialer",
                "com.android.dialer.DialtactsActivity");
        intent.setComponent(component);
        startActivity(intent);
    }

    // 隐式启动拨号
    public void clickDail2(View view) {
        // 显示拨号键盘
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel://120"));
        startActivity(intent);

    }

    // 跳转到手机桌面
    public void clickDesk(View view) {
        // 创建intent对象，指明action
        Intent intent = new Intent(Intent.ACTION_MAIN);
        // 给intent设置类别
        intent.addCategory(Intent.CATEGORY_HOME);

        startActivity(intent);

    }

    //直接拨号的action必须和data属性配合使用，如果不设置data属性，就会找不到对应的activity
    public void clickCall(View view) {

        // 构建数据对象，数据对象必须用Uri来封装
        Uri uri = Uri.parse("tel:10000");
        intentCallPhone.setData(uri);

        //Permission
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity50.this, new String[]{Manifest.permission.CALL_PHONE}, callPhonePerssion);
        } else {
            startActivity(intentCallPhone);
        }
    }


    /**
     * 请求权限回调
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case callPhonePerssion:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startActivity(intentCallPhone);
                } else {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
                        Toast.makeText(this, "添加了这个就可以打电话了", Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("标题");
                        builder.setMessage("拨打电话").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SystemClock.sleep(500);
                                ActivityCompat.requestPermissions(MainActivity50.this, new String[]{Manifest.permission.CALL_PHONE}, callPhonePerssion);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SystemClock.sleep(500);
                                ApplicationMain.finishAllActivity();
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(0);
                            }
                        }).show();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("手动设置权限");
                        builder.setMessage("您之前已经取消了授权，请到应用里面去设置").setPositiveButton("去设置", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SystemClock.sleep(500);
                                Uri uriPackage=Uri.parse("package://"+"com.androidpath");
                                Intent intent =new Intent(Settings.ACTION_APPLICATION_SETTINGS,uriPackage);
                                startActivity(intent);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SystemClock.sleep(500);
                                ApplicationMain.finishAllActivity();
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(0);
                            }
                        }).show();
                    }
                }
        }
    }

    //	设置data属性启动自定义的activity
    public void clickDataOther(View view) {
        Intent intent = new Intent(this, OtherActivity50.class);
        Uri uri = Uri.parse("house://car/钻戒");
        intent.setData(uri);
        startActivity(intent);
    }

    public void clickSms(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SENDTO);
        //data:启动界面的数据，必须在启动端填
        intent.setData(Uri.parse("smsto://10086"));

        //extra：是附加数据，可以填也可以不填
        intent.putExtra("sms_body", "how old are you!");
        startActivity(intent);
    }

    public void clickView(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        //data:启动界面的数据，必须在启动端填
        intent.setData(Uri.parse("http://www.baidu.com"));
        startActivity(intent);
    }

    //借助系统应用打开图片
    public void clickImage(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        //判断sdk有么有正确的被系统识别
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

            //将要查看的图片文件用uri对象描述
            Uri data = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "p3.jpg"));
            intent.setDataAndType(data, "image/*");

            startActivity(intent);
        } else {
            Toast.makeText(this, "sdk没有找到", Toast.LENGTH_LONG).show();
        }

    }
}
