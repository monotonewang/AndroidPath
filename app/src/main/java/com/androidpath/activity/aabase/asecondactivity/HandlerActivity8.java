package com.androidpath.activity.aabase.asecondactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;
import com.androidpath.activity.ahhandler.handercycleiamge181.MainActivity181;
import com.androidpath.activity.ahhandler.handerimage180.MainActivity180;
import com.androidpath.activity.ahhandler.handlerlightcycle182.MainActivity182;
import com.androidpath.activity.ahhandler.handlerlopper184.MainActivity184;
import com.androidpath.activity.ahhandler.updateui183.MainActivity183;
import com.androidpath.util.FileUtils;
import com.androidpath.view.flowlayout.libs.FlowLayout;
import com.androidpath.view.flowlayout.libs.TagAdapter;
import com.androidpath.view.flowlayout.libs.TagFlowLayout;

import java.util.ArrayList;

public class HandlerActivity8 extends BaseActivity implements TagFlowLayout.OnTagClickListener {
    private TagAdapter<String> mAdapter;
    private TagFlowLayout mFlowLayout;
    private String[] mVals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler8);

        final LayoutInflater mInflater = LayoutInflater.from(this);
        ArrayList arrayList = FileUtils.getArrayList(this, R.raw.handlerdemo);
        mVals = (String[]) arrayList.toArray(new String[arrayList.size()]);
        mFlowLayout = (TagFlowLayout) findViewById(R.id.handler_flowlayout);
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
                startActivity(new Intent(HandlerActivity8.this, MainActivity180.class));
                break;
            case 1:
                startActivity(new Intent(HandlerActivity8.this, MainActivity181.class));
                break;
            case 2:
                startActivity(new Intent(HandlerActivity8.this, MainActivity182.class));
                break;
            case 3:
                startActivity(new Intent(HandlerActivity8.this, MainActivity183.class));
                break;
            case 4:
                startActivity(new Intent(HandlerActivity8.this, MainActivity184.class));
                break;
        }
        return true;
    }
}
