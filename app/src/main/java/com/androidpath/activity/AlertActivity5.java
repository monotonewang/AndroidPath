package com.androidpath.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.main.BaseActivity;
import com.androidpath.util.FileUtils;
import com.androidpath.view.container.actionbar190.customview.MainActivity194;
import com.androidpath.view.container.actionbar190.demo190.MainActivity190;
import com.androidpath.view.container.actionbar190.list193.MainActivity193;
import com.androidpath.view.container.actionbar190.provider191.MainActivity191;
import com.androidpath.view.container.actionbar190.tab192.MainActivity192;
import com.androidpath.view.container.alertdialog110.MainActivity110;
import com.androidpath.view.container.contextmenu111.MainActivity111;
import com.androidpath.view.container.dymicaddmenu117.MainActivity117;
import com.androidpath.view.container.notification112.MainActivity112;
import com.androidpath.view.container.optionmenu113.MainActivity113;
import com.androidpath.view.container.popupmenu114.MainActivity114;
import com.androidpath.view.container.subMenu115.MainActivity115;
import com.androidpath.view.container.toastdemo116.MainActivity116;
import com.androidpath.view.flowlayout.libs.FlowLayout;
import com.androidpath.view.flowlayout.libs.TagAdapter;
import com.androidpath.view.flowlayout.libs.TagFlowLayout;

import java.util.ArrayList;

public class AlertActivity5 extends BaseActivity {
    private TagAdapter<String> mAdapter;
    private TagFlowLayout mFlowLayout;
    private String[] mVals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        final LayoutInflater mInflater = LayoutInflater.from(this);
        ArrayList arrayList = FileUtils.getArrayList(this, R.raw.alertdemo);
        mVals = (String[]) arrayList.toArray(new String[arrayList.size()]);
        mFlowLayout = (TagFlowLayout) findViewById(R.id.alert_flowlayout);
        mFlowLayout.setAdapter(mAdapter = new TagAdapter<String>(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.activity_flowlayout_tv,
                        mFlowLayout, false);
                tv.setText(s);
                return tv;
            }
        });
        mFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(AlertActivity5.this, MainActivity110.class));
                        break;
                    case 1:
                        startActivity(new Intent(AlertActivity5.this, MainActivity111.class));
                        break;
                    case 2:
                        startActivity(new Intent(AlertActivity5.this, MainActivity112.class));
                        break;
                    case 3:
                        startActivity(new Intent(AlertActivity5.this, MainActivity113.class));
                        break;
                    case 4:
                        startActivity(new Intent(AlertActivity5.this, MainActivity114.class));
                        break;
                    case 5:
                        startActivity(new Intent(AlertActivity5.this, MainActivity115.class));
                        break;
                    case 6:
                        startActivity(new Intent(AlertActivity5.this, MainActivity116.class));
                        break;
                    case 7:
                        startActivity(new Intent(AlertActivity5.this, MainActivity117.class));
                        break;
                    case 8:
                        startActivity(new Intent(AlertActivity5.this, MainActivity190.class));
                        break;
                    case 9:
                        startActivity(new Intent(AlertActivity5.this, MainActivity191.class));
                        break;
                    case 10:
                        startActivity(new Intent(AlertActivity5.this, MainActivity192.class));
                        break;
                    case 11:
                        startActivity(new Intent(AlertActivity5.this, MainActivity193.class));
                        break;
                    case 12:
                        startActivity(new Intent(AlertActivity5.this, MainActivity194.class));
                        break;
                }
                return true;
            }
        });
    }
}
