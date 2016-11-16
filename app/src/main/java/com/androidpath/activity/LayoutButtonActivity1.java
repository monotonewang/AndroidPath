package com.androidpath.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.main.BaseActivity;
import com.androidpath.util.FileUtils;
import com.androidpath.view.flowlayout.libs.FlowLayout;
import com.androidpath.view.flowlayout.libs.TagAdapter;
import com.androidpath.view.flowlayout.libs.TagFlowLayout;
import com.androidpath.view.normal.buttonbgcolor40.MainActivity40;
import com.androidpath.view.normal.buttonselector30.ButtonSelectorActivtiy3;
import com.androidpath.view.normal.checkradio41.MainActivity41;
import com.androidpath.view.normal.clickreponse31.ButtonTestActivity31;
import com.androidpath.view.normal.edittext.edittextdemo32.MainActivity32;
import com.androidpath.view.normal.imageviewtest.MainActivity33;
import com.androidpath.view.normal.layoutdemo2.LayoutActivity2;
import com.androidpath.view.normal.spinner.spinnerdemo42.MainActivity42;
import com.androidpath.view.normal.spinner.spinnerdemo43.MainActivity43;
import com.androidpath.view.normal.spinner.spinnerlink52.MainActivity52;
import com.androidpath.view.normal.spinner.spinnersimpleAdapter44.MainActivity44;
import com.androidpath.view.normal.viewtest34.MainActivity34;

import java.util.ArrayList;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/16 10:54 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */


public class LayoutButtonActivity1 extends BaseActivity {
    private TagAdapter<String> mAdapter;
    private TagFlowLayout mFlowLayout;
    private String[] mVals;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_button);
        final LayoutInflater mInflater = LayoutInflater.from(this);
        ArrayList arrayList = FileUtils.getArrayList(this, R.raw.layoutbutton);
        mVals = (String[]) arrayList.toArray(new String[arrayList.size()]);
        mFlowLayout = (TagFlowLayout) findViewById(R.id.layout_flowlayout);
        mFlowLayout.setAdapter(mAdapter = new TagAdapter<String>(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.activity_flowlayout_tv,
                        mFlowLayout, false);
                tv.setText(s);
                return tv;
            }
        });

//        LayoutDemo2
//        ButtonSelectorDemo3
//        ButtonTestactivity31
//        EditTextDemo32
//        ImageViewTest33
//        ViewTest34
//        ButtonBgColor40
//        CheckRadio41
//        SpinnerDemo42
//        SpinnerDemo43
//        SpinnerSimpleAdapter44
//        SpinnerLink52
        mFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(LayoutButtonActivity1.this, LayoutActivity2.class));
                        break;
                    case 1:
                        startActivity(new Intent(LayoutButtonActivity1.this, ButtonSelectorActivtiy3.class));
                        break;
                    case 2:
                        startActivity(new Intent(LayoutButtonActivity1.this, ButtonTestActivity31.class));
                        break;
                    case 3:
                        startActivity(new Intent(LayoutButtonActivity1.this, MainActivity32.class));
                        break;
                    case 4:
                        startActivity(new Intent(LayoutButtonActivity1.this, MainActivity33.class));
                        break;
                    case 5:
                        startActivity(new Intent(LayoutButtonActivity1.this, MainActivity34.class));
                        break;
                    case 6:
                        startActivity(new Intent(LayoutButtonActivity1.this, MainActivity40.class));
                        break;
                    case 7:
                        startActivity(new Intent(LayoutButtonActivity1.this, MainActivity41.class));
                        break;
                    case 8:
                        startActivity(new Intent(LayoutButtonActivity1.this, MainActivity42.class));
                        break;
                    case 9:
                        startActivity(new Intent(LayoutButtonActivity1.this, MainActivity43.class));
                        break;
                    case 10:
                        startActivity(new Intent(LayoutButtonActivity1.this, MainActivity44.class));
                        break;
                    case 11:
                        startActivity(new Intent(LayoutButtonActivity1.this, MainActivity52.class));
                        break;
                }
                return true;
            }
        });

    }

}
