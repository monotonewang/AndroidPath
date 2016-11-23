package com.androidpath.activity.aalayout.buttonbgcolor40;

import android.app.Activity;
import android.os.Bundle;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

public class MainActivity40 extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //绑定布局：实际上系统会自动实例化布局文件中的view控件（new Button(context, attrs)）
        setContentView(R.layout.activity_main40);


    }

}
