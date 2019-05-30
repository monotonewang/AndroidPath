package com.androidpath.view.widget.custom.canvastext;

import android.os.Bundle;
import androidx.annotation.Nullable;

import com.androidpath.activity.aabase.BaseActivity;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/18 17:58 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class PictureActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PictureView pictureView = new PictureView(this);
        setContentView(pictureView);
    }
}
