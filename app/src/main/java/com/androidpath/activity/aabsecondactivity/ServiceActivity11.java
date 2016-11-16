package com.androidpath.activity.aabsecondactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;
import com.androidpath.activity.akservice.intentservice248.MainActivity248;
import com.androidpath.activity.akservice.localbroadservice242.MainActivity242;
import com.androidpath.activity.akservice.mediaservice.mediaservice243.MainActivity243;
import com.androidpath.activity.akservice.mediaservice246.MainActivity246;
import com.androidpath.activity.akservice.servicedemo241.MainActivity241;
import com.androidpath.activity.akservice.stickservice247.MainActivity247;
import com.androidpath.util.FileUtils;
import com.androidpath.view.flowlayout.libs.FlowLayout;
import com.androidpath.view.flowlayout.libs.TagAdapter;
import com.androidpath.view.flowlayout.libs.TagFlowLayout;

import java.util.ArrayList;

public class ServiceActivity11 extends BaseActivity implements TagFlowLayout.OnTagClickListener {
    private TagAdapter<String> mAdapter;
    private TagFlowLayout mFlowLayout;
    private String[] mVals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service11);

        final LayoutInflater mInflater = LayoutInflater.from(this);
        ArrayList arrayList = FileUtils.getArrayList(this, R.raw.servicedemo);
        mVals = (String[]) arrayList.toArray(new String[arrayList.size()]);
        mFlowLayout = (TagFlowLayout) findViewById(R.id.sevice_flowlayout);
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
                startActivity(new Intent(ServiceActivity11.this, MainActivity241.class));
                break;
            case 1:
                startActivity(new Intent(ServiceActivity11.this, MainActivity242.class));
                break;
            case 2:
                startActivity(new Intent(ServiceActivity11.this, MainActivity243.class));
                break;
            case 3:
                startActivity(new Intent(ServiceActivity11.this, MainActivity246.class));
                break;
            case 4:
                startActivity(new Intent(ServiceActivity11.this, MainActivity247.class));
                break;
            case 5:
                startActivity(new Intent(ServiceActivity11.this, MainActivity248.class));
                break;
        }
        return true;
    }
}
