package com.androidpath.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/4 17:33 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationMain.addActivity(this);
    }
}
