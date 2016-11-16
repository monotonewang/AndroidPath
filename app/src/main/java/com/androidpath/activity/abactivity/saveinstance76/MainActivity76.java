package com.androidpath.activity.abactivity.saveinstance76;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.androidpath.R;

public class MainActivity76 extends Activity {

    private String TAG = "MainActivity76";
    private EditText editText;
    private MediaPlayer mediaPlayer;

    //参数Bundle savedInstanceState是保护现场的时候存入的数据对象，被系统自动传入该onCreate方法
    //如果activity是第一次正常的启动，该参数的值是null
    //如果activity是被意外终止后重建的，该参数就不为空，而是保护现场的时候存入的数据对象
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main76);
        Log.e(TAG, "onCreate: ");
        editText = (EditText) findViewById(R.id.edit_text);

        //创建播放器对象
        mediaPlayer = MediaPlayer.create(this, R.raw.gz);

        //恢复现场
        if (savedInstanceState != null) {
            Toast.makeText(this, "onCreate" + savedInstanceState.getString("text"), Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(this, "onCreate" + "这是正常的启动", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        Log.e(TAG, "onStart: ");
        mediaPlayer.start();
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onRestoreInstanceState(savedInstanceState);
        Log.e(TAG, "onRestoreInstanceState: ");
        //恢复现场，从bundle中获得保护现场的时候存入的数据
        String text = savedInstanceState.getString("text");
        editText.setText(text);
    }

    @Override
    protected void onRestart() {
        // TODO Auto-generated method stub
        super.onRestart();
        Log.e(TAG, "onRestart: ");
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        // TODO Auto-generated method stub
        super.onWindowFocusChanged(hasFocus);
        Log.e(TAG, "onWindowFocusChanged: ");
    }


    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        Log.e(TAG, "onPause: ");
        mediaPlayer.pause();
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle) {
        // TODO Auto-generated method stub
        super.onSaveInstanceState(bundle);
        Log.e(TAG, "onSaveInstanceState: ");
        //保护现场
        String text = editText.getText().toString();
        if (!TextUtils.isEmpty(text)) {
            bundle.putString("text", text);
        }
    }

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        Log.e(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}
