package com.androidpath.util.language;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;
import com.androidpath.util.ConstantUtils;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/9 12:16 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class LanguageActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvEnglish:
                updateLanguage(ConstantUtils.LANGUAGE_ENGLISH);
                break;
            case R.id.tvChinese:
                updateLanguage(ConstantUtils.LANGUAGE_CHINESE);
                break;
        }
        System.exit(0);
    }


}
