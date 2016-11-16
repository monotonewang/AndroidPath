package com.androidpath.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;
import com.androidpath.broadcast.localboradcastOne232.MainActivity232;
import com.androidpath.broadcast.localboradcastTwo233.MainActivity233;
import com.androidpath.broadcast.sendbroadcast231.MainActivity231;
import com.androidpath.broadcast.serverclient234.client.MainActivity235;
import com.androidpath.broadcast.serverclient234.server.MainActivity234;
import com.androidpath.broadcast.staticdymic230.MainActivity230;
import com.androidpath.util.FileUtils;
import com.androidpath.view.flowlayout.libs.FlowLayout;
import com.androidpath.view.flowlayout.libs.TagAdapter;
import com.androidpath.view.flowlayout.libs.TagFlowLayout;

import java.util.ArrayList;

public class BroadcastActivity extends BaseActivity implements TagFlowLayout.OnTagClickListener {
    private TagAdapter<String> mAdapter;
    private TagFlowLayout mFlowLayout;
    private String[] mVals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        final LayoutInflater mInflater = LayoutInflater.from(this);
        ArrayList arrayList = FileUtils.getArrayList(this, R.raw.broadcastdemo);
        mVals = (String[]) arrayList.toArray(new String[arrayList.size()]);
        mFlowLayout = (TagFlowLayout) findViewById(R.id.broadcast_flowlayout);
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

    //BroadCastReceiver230
    //SendBroadCast231
    //LocalBroadCastOne232
    //LocalBroadCastTwo233
    //BroadCastServer234
    //BroadCastClient235
    @Override
    public boolean onTagClick(View view, int position, FlowLayout parent) {
        switch (position) {
            case 0:
                startActivity(new Intent(BroadcastActivity.this, MainActivity230.class));
                break;
            case 1:
                startActivity(new Intent(BroadcastActivity.this, MainActivity231.class));
                break;
            case 2:
                startActivity(new Intent(BroadcastActivity.this, MainActivity232.class));
                break;
            case 3:
                startActivity(new Intent(BroadcastActivity.this, MainActivity233.class));
                break;
            case 4:
                startActivity(new Intent(BroadcastActivity.this, MainActivity234.class));
                break;
            case 5:
                startActivity(new Intent(BroadcastActivity.this, MainActivity235.class));
                break;
        }
        return true;
    }
}
