package com.androidpath.activity.aabase.asecondactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;
import com.androidpath.activity.agstorge.asstes195.MainActivity195;
import com.androidpath.activity.agstorge.contentResolverContacts161.MainActivity161;
import com.androidpath.activity.agstorge.contentobserver160.MainActivity160;
import com.androidpath.activity.agstorge.fileStorgetwo132.MainActivity132;
import com.androidpath.activity.agstorge.filestorge131.MainActivity131;
import com.androidpath.activity.agstorge.loadimage172.MainActivity172;
import com.androidpath.activity.agstorge.loadmanagercontact171.MainActivity171;
import com.androidpath.activity.agstorge.loadmanger170.MainActivity170;
import com.androidpath.activity.agstorge.sharedproference130.MainActivity130;
import com.androidpath.activity.agstorge.sql.simplecusoradapter155.MainActivity155;
import com.androidpath.activity.agstorge.sql.sql140.MainActivity140;
import com.androidpath.activity.agstorge.sql.sqlclientone150.MainActivity150;
import com.androidpath.activity.agstorge.sql.sqlclienttwo152.MainActivity152;
import com.androidpath.activity.agstorge.sql.sqldemo154.MainActivity154;
import com.androidpath.activity.agstorge.sql.sqlserverone151.MainActivity151;
import com.androidpath.activity.agstorge.sql.sqlservertwo153.MainActivity153;
import com.androidpath.activity.agstorge.sql.sqltransaction.SQLiteTransactionActivity;
import com.androidpath.util.FileUtilssss;
import com.androidpath.view.flowlayout.libs.FlowLayout;
import com.androidpath.view.flowlayout.libs.TagAdapter;
import com.androidpath.view.flowlayout.libs.TagFlowLayout;

import java.util.ArrayList;

public class StorgeActivity7 extends BaseActivity implements TagFlowLayout.OnTagClickListener {
    private TagAdapter<String> mAdapter;
    private TagFlowLayout mFlowLayout;
    private String[] mVals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storge7);

        final LayoutInflater mInflater = LayoutInflater.from(this);
        ArrayList arrayList = FileUtilssss.getArrayList(this, R.raw.storgedemo);
        mVals = (String[]) arrayList.toArray(new String[arrayList.size()]);
        mFlowLayout = (TagFlowLayout) findViewById(R.id.storge_flowlayout);
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
                startActivity(new Intent(StorgeActivity7.this, MainActivity130.class));
                break;
            case 1:
                startActivity(new Intent(StorgeActivity7.this, MainActivity131.class));
                break;
            case 2:
                startActivity(new Intent(StorgeActivity7.this, MainActivity132.class));
                break;
            case 3:
                startActivity(new Intent(StorgeActivity7.this, MainActivity140.class));
                break;
            case 4:
                startActivity(new Intent(StorgeActivity7.this, MainActivity150.class));
                break;
            case 5:
                startActivity(new Intent(StorgeActivity7.this, MainActivity151.class));
                break;
            case 6:
                startActivity(new Intent(StorgeActivity7.this, MainActivity152.class));
                break;
            case 7:
                startActivity(new Intent(StorgeActivity7.this, MainActivity153.class));
                break;
            case 8:
                startActivity(new Intent(StorgeActivity7.this, MainActivity154.class));
                break;
            case 9:
                startActivity(new Intent(StorgeActivity7.this, MainActivity155.class));
                break;
            case 10:
                startActivity(new Intent(StorgeActivity7.this, MainActivity160.class));
                break;
            case 11:
                startActivity(new Intent(StorgeActivity7.this, MainActivity161.class));
                break;
            case 12:
                startActivity(new Intent(StorgeActivity7.this, MainActivity170.class));
                break;
            case 13:
                startActivity(new Intent(StorgeActivity7.this, MainActivity171.class));
                break;
            case 14:
                startActivity(new Intent(StorgeActivity7.this, MainActivity172.class));
                break;
            case 15:
                startActivity(new Intent(StorgeActivity7.this, MainActivity195.class));
                break;
            case 16:
                startActivity(new Intent(StorgeActivity7.this, SQLiteTransactionActivity.class));
                break;

        }
        return true;

    }
}
