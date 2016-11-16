package com.androidpath.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.main.BaseActivity;
import com.androidpath.util.FileUtils;
import com.androidpath.view.container.alertdialog110.MainActivity110;
import com.androidpath.view.container.contextmenu111.MainActivity111;
import com.androidpath.view.container.notification112.MainActivity112;
import com.androidpath.view.container.optionmenu113.MainActivity113;
import com.androidpath.view.container.popupmenu114.MainActivity114;
import com.androidpath.view.flowlayout.libs.FlowLayout;
import com.androidpath.view.flowlayout.libs.TagAdapter;
import com.androidpath.view.flowlayout.libs.TagFlowLayout;
import com.androidpath.view.listview.baseadapterpack100.MainActivity100;
import com.androidpath.view.listview.gradview102.MainActivity102;
import com.androidpath.view.listview.listviewdataparse83.MainActivity83;
import com.androidpath.view.listview.listviewexpandable101.MainActivity101;
import com.androidpath.view.listview.listviewjoke90.MainActivity90;
import com.androidpath.view.listview.lvemptyview103.SecondActivity103;

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
                        startActivity(new Intent(AlertActivity5.this, MainActivity83.class));
                        break;
                    case 6:
                        startActivity(new Intent(AlertActivity5.this, MainActivity90.class));
                        break;
                    case 7:
                        startActivity(new Intent(AlertActivity5.this, MainActivity100.class));
                        break;
                    case 8:
                        startActivity(new Intent(AlertActivity5.this, MainActivity101.class));
                        break;
                    case 9:
                        startActivity(new Intent(AlertActivity5.this, MainActivity102.class));
                        break;
                    case 10:
                        startActivity(new Intent(AlertActivity5.this, SecondActivity103.class));
                        break;
                    case 11:
                        startActivity(new Intent(AlertActivity5.this, SecondActivity103.class));
                        break;
                    case 12:
                        startActivity(new Intent(AlertActivity5.this, SecondActivity103.class));
                        break;
                }
                return true;
            }
        });
    }
}
