package com.androidpath.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.activity.affragment.dialogframgment.MainActivity120;
import com.androidpath.activity.affragment.dynicaddfragment123.MainActivity123;
import com.androidpath.activity.affragment.fragmentpassvalue122.MainActivity122;
import com.androidpath.activity.affragment.radiofragment124.MainActivity124;
import com.androidpath.activity.affragment.staticfragment121.MainActivity121;
import com.androidpath.main.BaseActivity;
import com.androidpath.util.FileUtils;
import com.androidpath.view.flowlayout.libs.FlowLayout;
import com.androidpath.view.flowlayout.libs.TagAdapter;
import com.androidpath.view.flowlayout.libs.TagFlowLayout;

import java.util.ArrayList;

public class FragmentActivity6 extends BaseActivity implements TagFlowLayout.OnTagClickListener {
    private TagAdapter<String> mAdapter;
    private TagFlowLayout mFlowLayout;
    private String[] mVals;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        final LayoutInflater mInflater = LayoutInflater.from(this);
        ArrayList arrayList = FileUtils.getArrayList(this, R.raw.fragmentdemo);
        mVals = (String[]) arrayList.toArray(new String[arrayList.size()]);
        mFlowLayout = (TagFlowLayout) findViewById(R.id.fragment_flowlayout);
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
    //DialogFragment120
    //StaticFragment121
    //PassValueFragement122
    //DynicAddFragment123
    //RadioFragment124
    @Override
    public boolean onTagClick(View view, int position, FlowLayout parent) {
        switch (position){
            case 0:
                startActivity(new Intent(FragmentActivity6.this, MainActivity120.class));
                break;
            case 1:
                startActivity(new Intent(FragmentActivity6.this, MainActivity121.class));
                break;
            case 2:
                startActivity(new Intent(FragmentActivity6.this, MainActivity122.class));
                break;
            case 3:
                startActivity(new Intent(FragmentActivity6.this, MainActivity123.class));
                break;
            case 4:
                startActivity(new Intent(FragmentActivity6.this, MainActivity124.class));
                break;
        }
        return true;
    }
}
