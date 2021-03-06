package com.androidpath.activity.aabase.asecondactivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;
import com.androidpath.activity.aalayout.autocompletetextView.AutoCompleteTextViewActivity;
import com.androidpath.activity.aalayout.buttonbgcolor40.MainActivity40;
import com.androidpath.activity.aalayout.checkradio41.MainActivity41;
import com.androidpath.activity.aalayout.clickreponse31.ButtonTestActivity31;
import com.androidpath.activity.aalayout.edittext.edittextdemo32.MainActivity32;
import com.androidpath.activity.aalayout.imageviewtest.MainActivity33;
import com.androidpath.activity.aalayout.layoutdemo2.LayoutActivity2;
import com.androidpath.activity.aalayout.quickcontactbadge.QuickContactBadgeActivity;
import com.androidpath.activity.aalayout.ratingbar20180130.RatingBar20180130Activity;
import com.androidpath.activity.aalayout.spinner.spinnerdemo42.MainActivity42;
import com.androidpath.activity.aalayout.spinner.spinnerdemo43.MainActivity43;
import com.androidpath.activity.aalayout.spinner.spinnerlink52.MainActivity52;
import com.androidpath.activity.aalayout.spinner.spinnersimpleAdapter44.MainActivity44;
import com.androidpath.activity.aalayout.viewtest34.MainActivity34;
import com.androidpath.util.FileUtilssss;
import com.androidpath.view.flowlayout.libs.FlowLayout;
import com.androidpath.view.flowlayout.libs.TagAdapter;
import com.androidpath.view.flowlayout.libs.TagFlowLayout;

import java.util.ArrayList;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/16 10:54 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class LayoutButtonActivity1 extends BaseActivity implements TagFlowLayout.OnTagClickListener {
    private TagAdapter<String> mAdapter;
    private TagFlowLayout mFlowLayout;
    private String[] mVals;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_button);
        final LayoutInflater mInflater = LayoutInflater.from(this);
        ArrayList arrayList = FileUtilssss.getArrayList(this, R.raw.layoutbutton);
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
        mFlowLayout.setOnTagClickListener(this);
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
//        RatingBar20180130Activity
//        QuickContactBadgeActivity
//        AutoCompleteTextViewActivity

    }

    @Override
    public boolean onTagClick(View view, int position, FlowLayout parent) {
        switch (position) {
            case 0:
                startActivity(new Intent(LayoutButtonActivity1.this, LayoutActivity2.class));
                break;
            case 1:
                startActivity(new Intent(LayoutButtonActivity1.this, ButtonTestActivity31.class));
                break;
            case 2:
                startActivity(new Intent(LayoutButtonActivity1.this, MainActivity32.class));
                break;
            case 3:
                startActivity(new Intent(LayoutButtonActivity1.this, MainActivity33.class));
                break;
            case 4:
                startActivity(new Intent(LayoutButtonActivity1.this, MainActivity34.class));
                break;
            case 5:
                startActivity(new Intent(LayoutButtonActivity1.this, MainActivity40.class));
                break;
            case 6:
                startActivity(new Intent(LayoutButtonActivity1.this, MainActivity41.class));
                break;
            case 7:
                startActivity(new Intent(LayoutButtonActivity1.this, MainActivity42.class));
                break;
            case 8:
                startActivity(new Intent(LayoutButtonActivity1.this, MainActivity43.class));
                break;
            case 9:
                startActivity(new Intent(LayoutButtonActivity1.this, MainActivity44.class));
                break;
            case 10:
                startActivity(new Intent(LayoutButtonActivity1.this, MainActivity52.class));
                break;
            case 11:
                startActivity(new Intent(LayoutButtonActivity1.this, RatingBar20180130Activity.class));
                break;
            case 12:
                startActivity(new Intent(LayoutButtonActivity1.this, QuickContactBadgeActivity.class));
                break;
            case 13:
                startActivity(new Intent(LayoutButtonActivity1.this, AutoCompleteTextViewActivity.class));
                break;
        }
        return true;
    }
}
