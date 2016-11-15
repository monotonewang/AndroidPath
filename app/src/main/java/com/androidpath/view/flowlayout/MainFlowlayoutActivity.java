package com.androidpath.view.flowlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.androidpath.R;
import com.androidpath.main.BaseActivity;
import com.androidpath.util.language.LanguageActivity;
import com.androidpath.view.flowlayout.libs.FlowLayout;
import com.androidpath.view.flowlayout.libs.TagAdapter;
import com.androidpath.view.flowlayout.libs.TagFlowLayout;
import com.androidpath.view.normal.buttonselector30.ButtonSelectorActivtiy3;
import com.androidpath.view.normal.clickreponse31.ButtonTestActivity31;
import com.androidpath.view.normal.layoutdemo2.LayoutActivity2;

import java.util.Set;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/15 19:23 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */
//zgjxfuqingwang@gmail.com
public class MainFlowlayoutActivity extends BaseActivity {
    private TagAdapter<String> mAdapter;
    private String[] mVals = new String[]
            {"layoutdemo2", "languagesettings", "buttonselectordemo3 ", "buttontestactivity31", "edittextdemo32", "imageviewtest33",
                    "viewtest34", "handview", "buttonbgcolor40", "checkradio41", "spinnerdemo42",
                    "spinnerdemo43", "aysncdemotwo71", "activityjump50", "activitypassvalue50", "autoCompleteText51", "spinnerlink52", "activitypassvalue55", "getresult60", "taskdemo61", "aysncdemoone70",
                    "aysncgetimage72", "Weclome", "Button ImageView", "TextView", "Helloworld",
                    "Android", "Weclome Hello", "Button Text", "TextView", "Hello", "Android", "Weclome Hi ", "Button", "TextView", "Hello",
                    "Android", "Weclome", "Button ImageView", "TextView", "Helloworld",
                    "Android", "Weclome Hello", "Button Text", "TextView", "Hello", "Android", "Weclome Hi ", "Button", "TextView", "Hello",
                    "Android", "Weclome", "Button ImageView", "TextView", "Helloworld",
                    "Android", "Weclome Hello", "Button Text", "TextView", "Hello", "Android", "Weclome Hi ", "Button", "TextView", "Hello",
                    "Android", "Weclome", "Button ImageView", "TextView", "Helloworld",
                    "Android", "Weclome Hello", "Button Text", "TextView", "Hello", "Android", "Weclome Hi ", "Button", "TextView", "Hello",
                    "Android", "Weclome", "Button ImageView", "TextView", "Helloworld",
                    "Android", "Weclome Hello", "Button Text", "TextView", "Hello", "Android", "Weclome Hi ", "Button", "TextView", "Hello",
                    "Android", "Weclome", "Button ImageView", "TextView", "Helloworld",
                    "Android", "Weclome Hello", "Button Text", "TextView"};
    private TagFlowLayout mFlowLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final LayoutInflater mInflater = LayoutInflater.from(this);
        setContentView(R.layout.activity_flowlayout);
        mFlowLayout = (TagFlowLayout) findViewById(R.id.main_flowlayout);
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
//                Toast.makeText(getActivity(), mVals[position], Toast.LENGTH_SHORT).show();
                Toast.makeText(MainFlowlayoutActivity.this, position + "", Toast.LENGTH_SHORT).show();
                switch (position){
                    case 0:
                        startActivity(new Intent(MainFlowlayoutActivity.this, LayoutActivity2.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainFlowlayoutActivity.this, LanguageActivity.class));
                        break;

                    case 2:
                        startActivity(new Intent(MainFlowlayoutActivity.this, ButtonSelectorActivtiy3.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainFlowlayoutActivity.this, ButtonTestActivity31.class));
                        break;
                    default:

                        break;
                }
//                view.setVisibility(View.GONE);
                return true;
            }
        });
        mFlowLayout.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {
//                getActivity().setTitle("choose:" + selectPosSet.toString());
            }
        });
    }
}
