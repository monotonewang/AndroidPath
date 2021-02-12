package com.androidpath.activity.aabase;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;

import android.view.View;
import android.widget.Toast;

import com.androidpath.R;
import com.androidpath.activity.aabase.asecondactivity.AlertActivity5;
import com.androidpath.activity.aabase.asecondactivity.AsyncActivity3;
import com.androidpath.activity.aabase.asecondactivity.BroadcastActivity10;
import com.androidpath.activity.aabase.asecondactivity.FragmentActivity6;
import com.androidpath.activity.aabase.asecondactivity.HandlerActivity8;
import com.androidpath.activity.aabase.asecondactivity.LayoutButtonActivity1;
import com.androidpath.activity.aabase.asecondactivity.ListViewActivity4;
import com.androidpath.activity.aabase.asecondactivity.LiveCycleActivity2;
import com.androidpath.activity.aabase.asecondactivity.ServiceActivity11;
import com.androidpath.activity.aabase.asecondactivity.StorgeActivity7;
import com.androidpath.activity.aabase.asecondactivity.ViewPagerActivity9;
import com.androidpath.architecture.ArchitectureActivity;
import com.androidpath.library.retrofit.activity.RetrofitActivity;
import com.androidpath.library.rxjava.RxActivity;
import com.androidpath.util.fontutil.FontsManager;
import com.androidpath.view.ViewActivity;

/**
 * zgjxfuqingwang@gmail.com
 */
public class MainActivity extends BaseActivity {

    private AlertDialog dialog;
    private String TAG = "ContentValues";
    private boolean isFontChange = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onBackPressed() {
        //        super.onBackPressed();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("exit");
        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        });
        dialog = builder.show();
    }

    public void onClick(View view) {
        System.out.println("xxxxxxxxxxxxxxxx onClick");
        switch (view.getId()) {
            case R.id.layoutButton1:
                startActivity(new Intent(MainActivity.this, LayoutButtonActivity1.class));
                break;
            case R.id.activityLiveCycle2:
                startActivity(new Intent(MainActivity.this, LiveCycleActivity2.class));
                break;
            case R.id.asyncDemo3:
                startActivity(new Intent(MainActivity.this, AsyncActivity3.class));
                break;
            case R.id.listViewActivity4:
                startActivity(new Intent(MainActivity.this, ListViewActivity4.class));
                break;
            case R.id.alertActivity5:
                startActivity(new Intent(MainActivity.this, AlertActivity5.class));
                break;
            case R.id.fragmentDemo6:
                startActivity(new Intent(MainActivity.this, FragmentActivity6.class));
                break;
            case R.id.storgeDemo7:
                startActivity(new Intent(MainActivity.this, StorgeActivity7.class));
                break;
            case R.id.handlerDemo8:
                startActivity(new Intent(MainActivity.this, HandlerActivity8.class));
                break;
            case R.id.viewPagerDemo9:
                startActivity(new Intent(MainActivity.this, ViewPagerActivity9.class));
                break;
            case R.id.broadcastDemo10:
                startActivity(new Intent(MainActivity.this, BroadcastActivity10.class));
                break;
            case R.id.serviceDemo11:
                System.out.println("xxxxxxxxxxxxxxxx serviceDemo11");
                startActivity(new Intent(MainActivity.this, ServiceActivity11.class));
                break;
            case R.id.all_settings:
                Toast.makeText(getApplicationContext(), "setting", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(MainActivity.this, RxActivity.class));
                break;
            case R.id.architecture:
                startActivity(new Intent(MainActivity.this, ArchitectureActivity.class));
                break;
            case R.id.view:
                startActivity(new Intent(MainActivity.this, ViewActivity.class));
                break;
            case R.id.library:
                startActivity(new Intent(MainActivity.this, RxActivity.class));
//                startActivity(new Intent(MainActivity.this, RetrofitActivity.class));
                break;
            default:
                break;

        }
    }

    private void changeFontsByActivity() {
        isFontChange = !isFontChange;
        if (isFontChange) {
            FontsManager.initFormAssets(this, "fonts/testFont.ttf");//初始化，传入 typeface
            FontsManager.changeFonts(this);//change activity font
        } else {
            FontsManager.init(Typeface.DEFAULT);
            FontsManager.changeFonts(this);
        }
    }
}
