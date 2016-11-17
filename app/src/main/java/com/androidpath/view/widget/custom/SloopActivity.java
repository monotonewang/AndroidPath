package com.androidpath.view.widget.custom;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.androidpath.activity.aabase.BaseActivity;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/17 16:51 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class SloopActivity extends BaseActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    SloopView sloopView = new SloopView(this);
    setContentView(sloopView);
  }
}

