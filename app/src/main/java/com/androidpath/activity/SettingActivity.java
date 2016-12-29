package com.androidpath.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/29 11:05 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class SettingActivity extends BaseActivity {

    @BindView(R.id.tv_clear)
    TextView tvClear;
    @BindView(R.id.tv_size)
    TextView tvSize;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_setting);
        ButterKnife.bind(this);
        init();
    }

    private void init() {

    }


    @OnClick({R.id.tv_clear, R.id.tv_size})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_clear:
                break;
            case R.id.tv_size:
                break;
        }
    }
}
