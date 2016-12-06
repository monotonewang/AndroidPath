package com.androidpath.activity.aabase.asecondactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;
import com.androidpath.activity.acasync.demoone70.MainActivity70;
import com.androidpath.activity.acasync.demotwo71.MainActivity71;
import com.androidpath.activity.acasync.getimagestrong72.MainActivity72;
import com.androidpath.activity.acasync.progresslow73.MainActivity73;
import com.androidpath.util.FileUtilssss;
import com.androidpath.view.flowlayout.libs.FlowLayout;
import com.androidpath.view.flowlayout.libs.TagAdapter;
import com.androidpath.view.flowlayout.libs.TagFlowLayout;

import java.util.ArrayList;

public class AsyncActivity3 extends BaseActivity {
    private TagAdapter<String> mAdapter;
    private TagFlowLayout mFlowLayout;
    private String[] mVals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        final LayoutInflater mInflater = LayoutInflater.from(this);
        ArrayList arrayList = FileUtilssss.getArrayList(this,R.raw.asyncdemo);
        mVals = (String[]) arrayList.toArray(new String[arrayList.size()]);
        mFlowLayout = (TagFlowLayout) findViewById(R.id.live_cycle_flowlayout);
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
                switch (position){
                    case 0:
                        startActivity(new Intent(AsyncActivity3.this, MainActivity70.class));
                        break;
                    case 1:
                        startActivity(new Intent(AsyncActivity3.this, MainActivity71.class));
                        break;
                    case 2:
                        startActivity(new Intent(AsyncActivity3.this, MainActivity72.class));
                        break;
                    case 3:
                        startActivity(new Intent(AsyncActivity3.this, MainActivity73.class));
                        break;

                }
                return true;
            }
        });
    }
}
