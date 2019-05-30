package com.androidpath.activity.aabase;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.DisplayMetrics;

import com.androidpath.AndroidApplication;
import com.androidpath.util.ConfigUtils;
import com.androidpath.util.ConstantUtils;

import java.util.Locale;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/4 17:33 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */
//zgjxfuqingwang@gmail.com
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplication.addActivity(this);
        updateLanguage(ConfigUtils.getAPPLanguage(BaseActivity.this));

//        沉浸式
//        StatusBarUtil.setStatusBarTrans(this, false);

//        RefWatcher refWatcher = AndroidApplication.getRefWatcher(this);
//        refWatcher.watch(this);
    }

    protected void updateLanguage(int index) {
        Resources rs = getResources();
        Configuration configuration = rs.getConfiguration();
        DisplayMetrics dm = rs.getDisplayMetrics();
        int languageIndex = ConfigUtils.getAPPLanguage(BaseActivity.this);

        if (languageIndex == ConstantUtils.LANGUAGE_ENGLISH) {
            configuration.locale = new Locale("en");
        } else if (languageIndex == ConstantUtils.LANGUAGE_CHINESE) {
            configuration.locale = Locale.SIMPLIFIED_CHINESE;
        }
        rs.updateConfiguration(configuration, dm);
        ConfigUtils.setAppLanguage(BaseActivity.this, index);
    }
}
