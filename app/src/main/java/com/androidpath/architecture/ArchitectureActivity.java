package com.androidpath.architecture;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.architecture.databinding.DataActivity;
import com.androidpath.architecture.meterial.MeterialActivity;
import com.androidpath.project.sqlfunkilanguage.GetLanguageSQLActivity;
import com.androidpath.util.FileUtilssss;
import com.androidpath.view.flowlayout.libs.FlowLayout;
import com.androidpath.view.flowlayout.libs.TagAdapter;
import com.androidpath.view.flowlayout.libs.TagFlowLayout;

import java.util.ArrayList;

public class ArchitectureActivity extends AppCompatActivity implements TagFlowLayout.OnTagClickListener {

    private TagAdapter<String> mAdapter;
    private TagFlowLayout mFlowLayout;
    private String[] mVals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arcgutecture);

        final LayoutInflater mInflater = LayoutInflater.from(this);
        ArrayList arrayList = FileUtilssss.getArrayList(this, R.raw.architeecture);
        mVals = (String[]) arrayList.toArray(new String[arrayList.size()]);
        mFlowLayout = (TagFlowLayout) findViewById(R.id.architecture_flowlayout);
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
                startActivity(new Intent(ArchitectureActivity.this, GetLanguageSQLActivity.class));
                break;
            case 1:
                startActivity(new Intent(ArchitectureActivity.this, MeterialActivity.class));
                break;
            case 2:
                startActivity(new Intent(ArchitectureActivity.this, DataActivity.class));
                break;

        }
        return true;

    }
}
