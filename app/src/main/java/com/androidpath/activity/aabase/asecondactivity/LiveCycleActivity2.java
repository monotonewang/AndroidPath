package com.androidpath.activity.aabase.asecondactivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;
import com.androidpath.activity.abactivity.activityjump50.MainActivity50;
import com.androidpath.activity.abactivity.activitylivecircle.LiveCircleActivity;
import com.androidpath.activity.abactivity.activitypassvalue54.MainActivity54;
import com.androidpath.activity.abactivity.applicationpassvalue55.MainActivity55;
import com.androidpath.activity.abactivity.flagdemo74.MainActivity74;
import com.androidpath.activity.abactivity.getresult60.MainActivity60;
import com.androidpath.activity.abactivity.saveinstance76.MainActivity76;
import com.androidpath.activity.abactivity.taskdemo61.MainActivity61;
import com.androidpath.util.FileUtilssss;
import com.androidpath.view.flowlayout.libs.FlowLayout;
import com.androidpath.view.flowlayout.libs.TagAdapter;
import com.androidpath.view.flowlayout.libs.TagFlowLayout;

import java.util.ArrayList;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/16 13:52 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class LiveCycleActivity2 extends BaseActivity {
    private TagAdapter<String> mAdapter;
    private TagFlowLayout mFlowLayout;
    private String[] mVals;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_live_cycle);
        final LayoutInflater mInflater = LayoutInflater.from(this);
        ArrayList arrayList = FileUtilssss.getArrayList(this,R.raw.activitylivecyclesss);
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
        //ActivityJump50
        //ActivityPassValue54
        //ActivityPassValue55
        //ActivityGetResult60
        //ActivityTaskDemo61
        //ActivityFlagDemo74
        //ActivitySaveInstance76
        mFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
               switch (position){
                   case 0:
                       startActivity(new Intent(LiveCycleActivity2.this, MainActivity50.class));
                       break;
                   case 1:
                       startActivity(new Intent(LiveCycleActivity2.this, MainActivity54.class));
                       break;
                   case 2:
                       startActivity(new Intent(LiveCycleActivity2.this, MainActivity55.class));
                       break;
                   case 3:
                       startActivity(new Intent(LiveCycleActivity2.this, MainActivity60.class));
                       break;
                   case 4:
                       startActivity(new Intent(LiveCycleActivity2.this, MainActivity61.class));
                       break;
                   case 5:
                       startActivity(new Intent(LiveCycleActivity2.this, MainActivity74.class));
                       break;
                   case 6:
                       startActivity(new Intent(LiveCycleActivity2.this, MainActivity76.class));
                       break;
                   case 7:
                       startActivity(new Intent(LiveCycleActivity2.this, LiveCircleActivity.class));
                       break;


               }
                return true;
            }
        });
    }
}
