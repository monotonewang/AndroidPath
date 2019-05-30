package com.androidpath.activity.aabase.asecondactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;
import com.androidpath.activity.aiviewpager.actionbar215.MainActivity215;
import com.androidpath.activity.aiviewpager.cbk.chabaike211.MainActivity211;
import com.androidpath.activity.aiviewpager.cbk.chabaike216.MainActivity216;
import com.androidpath.activity.aiviewpager.cbk.chabaike240.MainActivity240;
import com.androidpath.activity.aiviewpager.circle212.MainActivity212;
import com.androidpath.activity.aiviewpager.fragment214.MainActivity214;
import com.androidpath.activity.aiviewpager.tabone220.MainActivity220;
import com.androidpath.activity.aiviewpager.tabtwo221.MainActivity221;
import com.androidpath.activity.aiviewpager.textview210.MainActivity210;
import com.androidpath.activity.aiviewpager.webview213.MainActivity213;
import com.androidpath.activity.aiviewpager.webview213.MainActivity2131;
import com.androidpath.activity.akservice.servicedemo241.MainActivity241;
import com.androidpath.util.FileUtilssss;
import com.androidpath.view.flowlayout.libs.FlowLayout;
import com.androidpath.view.flowlayout.libs.TagAdapter;
import com.androidpath.view.flowlayout.libs.TagFlowLayout;

import java.util.ArrayList;

public class ViewPagerActivity9 extends BaseActivity implements TagFlowLayout.OnTagClickListener {
    private TagAdapter<String> mAdapter;
    private TagFlowLayout mFlowLayout;
    private String[] mVals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager9);
        final LayoutInflater mInflater = LayoutInflater.from(this);
        ArrayList arrayList = FileUtilssss.getArrayList(this, R.raw.viewpagerdemo);
        mVals = (String[]) arrayList.toArray(new String[arrayList.size()]);
        mFlowLayout = (TagFlowLayout) findViewById(R.id.viewpager_flowlayout);
        mFlowLayout.setAdapter(mAdapter = new TagAdapter<String>(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.activity_flowlayout_tv,
                        mFlowLayout, false);
                tv.setText(s);
                return tv;
            }
        });
        mFlowLayout.setOnTagClickListener(this);

    }

    @Override
    public boolean onTagClick(View view, int position, FlowLayout parent) {
        switch (position) {
            case 0:
                startActivity(new Intent(ViewPagerActivity9.this, MainActivity210.class));
                break;
            case 1:
                startActivity(new Intent(ViewPagerActivity9.this, MainActivity211.class));
                break;
            case 2:
                startActivity(new Intent(ViewPagerActivity9.this, MainActivity212.class));
                break;
            case 3:
                startActivity(new Intent(ViewPagerActivity9.this, MainActivity213.class));
                break;
            case 4:
                startActivity(new Intent(ViewPagerActivity9.this, MainActivity214.class));
                break;
            case 5:
                startActivity(new Intent(ViewPagerActivity9.this, MainActivity215.class));
                break;
            case 6:
                startActivity(new Intent(ViewPagerActivity9.this, MainActivity216.class));
                break;
            case 7:
                startActivity(new Intent(ViewPagerActivity9.this, MainActivity220.class));
                break;
            case 8:
                startActivity(new Intent(ViewPagerActivity9.this, MainActivity221.class));
                break;
            case 9:
                startActivity(new Intent(ViewPagerActivity9.this, MainActivity240.class));
                break;
            case 10:
                startActivity(new Intent(ViewPagerActivity9.this, MainActivity2131.class));
                break;
        }
        return true;
    }
}
