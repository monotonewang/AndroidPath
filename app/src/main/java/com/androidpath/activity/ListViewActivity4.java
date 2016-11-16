package com.androidpath.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.main.BaseActivity;
import com.androidpath.util.FileUtils;
import com.androidpath.view.flowlayout.libs.FlowLayout;
import com.androidpath.view.flowlayout.libs.TagAdapter;
import com.androidpath.view.flowlayout.libs.TagFlowLayout;
import com.androidpath.view.listview.adddata81.MainActivity81;
import com.androidpath.view.listview.baseadapter80.MainActivity80;
import com.androidpath.view.listview.baseadapterpack100.MainActivity100;
import com.androidpath.view.listview.firstlistview.MainActivityFirstLV;
import com.androidpath.view.listview.gradview102.MainActivity102;
import com.androidpath.view.listview.listviewdataparse83.MainActivity83;
import com.androidpath.view.listview.listviewexpandable101.MainActivity101;
import com.androidpath.view.listview.listviewjoke90.MainActivity90;
import com.androidpath.view.listview.lvemptyview103.SecondActivity103;
import com.androidpath.view.listview.simpleadapter82.MainActivity82;
import com.androidpath.view.normal.imageviewdeal75.MainActivity75;

import java.util.ArrayList;

public class ListViewActivity4 extends BaseActivity {
    private TagAdapter<String> mAdapter;
    private TagFlowLayout mFlowLayout;
    private String[] mVals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        final LayoutInflater mInflater = LayoutInflater.from(this);
        ArrayList arrayList = FileUtils.getArrayList(this, R.raw.listviewdemo);
        mVals = (String[]) arrayList.toArray(new String[arrayList.size()]);
        mFlowLayout = (TagFlowLayout) findViewById(R.id.listview_flowlayout);
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
                        startActivity(new Intent(ListViewActivity4.this, MainActivityFirstLV.class));
                        break;
                    case 1:
                        startActivity(new Intent(ListViewActivity4.this, MainActivity75.class));
                        break;
                    case 2:
                        startActivity(new Intent(ListViewActivity4.this, MainActivity80.class));
                        break;
                    case 3:
                        startActivity(new Intent(ListViewActivity4.this, MainActivity81.class));
                        break;
                    case 4:
                        startActivity(new Intent(ListViewActivity4.this, MainActivity82.class));
                        break;
                    case 5:
                        startActivity(new Intent(ListViewActivity4.this, MainActivity83.class));
                        break;
                    case 6:
                        startActivity(new Intent(ListViewActivity4.this, MainActivity90.class));
                        break;
                    case 7:
                        startActivity(new Intent(ListViewActivity4.this, MainActivity100.class));
                        break;
                    case 8:
                        startActivity(new Intent(ListViewActivity4.this, MainActivity101.class));
                        break;
                    case 9:
                        startActivity(new Intent(ListViewActivity4.this, MainActivity102.class));
                        break;
                    case 10:
                        startActivity(new Intent(ListViewActivity4.this, SecondActivity103.class));
                        break;
                }
                return true;
            }
        });

    }
}

