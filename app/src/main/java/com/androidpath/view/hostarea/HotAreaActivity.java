package com.androidpath.view.hostarea;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.androidpath.R;
import com.androidpath.main.BaseActivity;
import com.androidpath.view.hostarea.entity.HotArea;
import com.androidpath.view.hostarea.utils.FileUtils;
import com.androidpath.view.hostarea.view.HotClickView;

import java.io.InputStream;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/16 10:21 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class HotAreaActivity extends BaseActivity implements HotClickView.OnClickListener {
    private HotClickView mHotView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotarea);
        initParam();
        initDatas();
    }

    private void initParam() {
        mHotView = (HotClickView) findViewById(R.id.a_main_hotview);
//        mHotView.setCanMove(false);
//        mHotView.setCanScale(false);
    }

    protected void initDatas() {
        AssetManager assetManager = getResources().getAssets();
        InputStream imgInputStream = null;
        InputStream fileInputStream = null;
        try {
            imgInputStream = assetManager.open("china.png");
            fileInputStream = assetManager.open("china.xml");
            mHotView.setImageBitmap(fileInputStream, imgInputStream, HotClickView.FIT_XY);
            mHotView.setOnClickListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            FileUtils.closeInputStream(imgInputStream);
            FileUtils.closeInputStream(fileInputStream);
        }
    }


    @Override
    public void OnClick(View view, HotArea hotArea) {
        Toast.makeText(HotAreaActivity.this, "你点击了" + hotArea.getDesc(), Toast.LENGTH_SHORT).show();
    }

}
