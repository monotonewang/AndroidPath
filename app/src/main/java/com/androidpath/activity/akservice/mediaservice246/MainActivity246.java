package com.androidpath.activity.akservice.mediaservice246;

import android.Manifest;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.androidpath.R;
import com.androidpath.activity.aabase.ApplicationMain;
import com.androidpath.activity.aabase.BaseActivity;
import com.androidpath.activity.akservice.mediaservice246.modle.MusicEntity;
import com.androidpath.activity.akservice.mediaservice246.service.MediaService246;
import com.androidpath.activity.akservice.mediaservice246.util.Constants;

import java.util.ArrayList;

public class MainActivity246 extends BaseActivity implements OnItemClickListener {

    private ListView lv;
    private SimpleCursorAdapter simpleCursorAdapter;

    private LocalBroadcastManager localBroadcastManager;

    /**
     * 存放拓展卡下的歌曲列表
     */
    private ArrayList<MusicEntity> dataList;

    private Uri map3Uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
//    private Uri map3Uri = MediaStore.Audio.Media.INTERNAL_CONTENT_URI;
    private String colums[] = {MediaStore.Audio.Media._ID,
            MediaStore.Audio.Media.DISPLAY_NAME,
            MediaStore.Audio.Media.DATA};
    private final int readSDCard = 1;
    private String TAG = "MainActivity246";
    private AlertDialog appdialog;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate: ");
        setContentView(R.layout.activity_main246);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
        /**
         * 启动服务
         */
        startService(new Intent(this, MediaService246.class));


        //permission
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity246.this, new String[]{Manifest.permission.CALL_PHONE}, readSDCard);
        } else {
            initView();
            initLoader();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case readSDCard:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (appdialog != null || dialog != null) {
                        dialog.dismiss();
                        appdialog.dismiss();
                    }
                    initView();
                    initLoader();
                } else {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
                        Toast.makeText(this, "添加了这个就可以读取歌曲列表了", Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("标题");
                        dialog = builder.setMessage("读取歌曲").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SystemClock.sleep(500);
                                ActivityCompat.requestPermissions(MainActivity246.this, new String[]{Manifest.permission.CALL_PHONE}, readSDCard);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SystemClock.sleep(500);
                                ApplicationMain.finishAllActivity();
                                Process.killProcess(Process.myPid());
                                System.exit(0);
                            }
                        }).show();
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        builder.setTitle("手动设置权限");
                        //根据包名跳到应用详情页面
//                                Intent intent =new Intent(Settings.ACTION_APPLICATION_SETTINGS);//应用列表界面
//                                Intent intent =new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);//开发人员界面
                        appdialog = builder.setMessage("您之前已经取消了授权，请到应用里面去设置").setPositiveButton("去设置", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SystemClock.sleep(500);
                                Uri uriPackage = Uri.parse("package:" + "com.androidpath");
                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, uriPackage);//根据包名跳到应用详情页面
//                                Intent intent =new Intent(Settings.ACTION_APPLICATION_SETTINGS);//应用列表界面
//                                Intent intent =new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS);//开发人员界面
                                startActivity(intent);
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                SystemClock.sleep(500);
                                ApplicationMain.finishAllActivity();
                                Process.killProcess(Process.myPid());
                                System.exit(0);
                            }
                        }).show();
                    }
                }
                break;
            default:

                break;

        }
    }

    /**
     * 初始化文件
     */
    private void initView() {
        dataList = new ArrayList();

        lv = (ListView) findViewById(R.id.lv_musics);
        simpleCursorAdapter = new SimpleCursorAdapter(this,
                R.layout.item_music246,
                null,
                new String[]{colums[1], colums[2]},
                new int[]{R.id.tv_name, R.id.tv_path},
                CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        if(lv!=null){
            lv.setAdapter(simpleCursorAdapter);
            lv.setOnItemClickListener(this);
        }


        localBroadcastManager = LocalBroadcastManager.getInstance(this);
    }

    /**
     * 初始化loader
     */
    private void initLoader() {
        getLoaderManager().initLoader(1, null, new LoaderCallbacks<Cursor>() {

            @Override
            public Loader<Cursor> onCreateLoader(int id, Bundle args) {
                return new CursorLoader(MainActivity246.this, map3Uri, colums, null, null, null);
            }

            @Override
            public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
                simpleCursorAdapter.swapCursor(data);

                /**
                 * 构建数据列表 传送到Service端
                 */
                for (int i = 0; i < data.getCount(); i++) {
                    data.moveToPosition(i);

                    /**
                     * 从Cursor中获得文件的数据
                     */
                    String name = data.getString(data.getColumnIndex(colums[1]));
                    String path = data.getString(data.getColumnIndex(colums[2]));
                    MusicEntity msEntity = new MusicEntity(name, path);
                    Log.e(TAG, "onLoadFinished: " + msEntity);
                    dataList.add(msEntity);
                }

                Intent intent = new Intent(Constants.ACTION.MUSIC_LIST);
                intent.putExtra(Constants.KEY.MUSIC_LIST_KEY, dataList);
                localBroadcastManager.sendBroadcast(intent);
            }

            @Override
            public void onLoaderReset(Loader<Cursor> loader) {

            }
        });
    }

    /**
     * 歌曲列表点击回调方法
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        //点击列表，启动服务，开始播放歌曲
        Intent intent = new Intent(this, MediaService246.class);
        intent.putExtra(Constants.KEY.PLAY_MUSIC_POSITION, position);
        startService(intent);
    }
}
