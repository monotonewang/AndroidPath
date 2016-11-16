package com.androidpath.activity.aabase;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.androidpath.R;
import com.androidpath.activity.aabsecondactivity.AlertActivity5;
import com.androidpath.activity.aabsecondactivity.AsyncActivity3;
import com.androidpath.activity.aabsecondactivity.BroadcastActivity10;
import com.androidpath.activity.aabsecondactivity.FragmentActivity6;
import com.androidpath.activity.aabsecondactivity.HandlerActivity8;
import com.androidpath.activity.aabsecondactivity.LayoutButtonActivity1;
import com.androidpath.activity.aabsecondactivity.ListViewActivity4;
import com.androidpath.activity.aabsecondactivity.LiveCycleActivity2;
import com.androidpath.activity.aabsecondactivity.ServiceActivity11;
import com.androidpath.activity.aabsecondactivity.StorgeActivity7;
import com.androidpath.activity.aabsecondactivity.ViewPagerActivity9;

/**
 * zgjxfuqingwang@gmail.com
 */
public class MainActivity extends BaseActivity {

    private AlertDialog dialog;
    private String TAG = "ContentValues";

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
                startActivity(new Intent(MainActivity.this, ServiceActivity11.class));
                break;
//            case R.id.SurfaceViewBird:
//                startActivity(new Intent(MainActivity.this, SurfaceViewMainActivity.class));
//                break;
//            case R.id.GLSurfaceView:
//                startActivity(new Intent(MainActivity.this, GLSurfaceViewActivity.class));
//                break;
            default:
                break;

        }
    }
}