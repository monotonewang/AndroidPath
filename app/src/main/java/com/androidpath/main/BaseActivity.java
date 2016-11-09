package com.androidpath.main;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;

import com.androidpath.util.ConfigUtils;

import java.util.Locale;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/4 17:33 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApplicationMain.addActivity(this);
        updateLanguage(ConfigUtils.getAPPLanguage(BaseActivity.this));
    }

    protected void updateLanguage(int index) {
        Resources rs = getResources();
        Configuration configuration = rs.getConfiguration();
        DisplayMetrics dm = rs.getDisplayMetrics();
//        Locale locales = configuration.locale;
//        Toast.makeText(this, "dlanguage" + locales.getLanguage(), Toast.LENGTH_SHORT).show();
        int languageIndex = ConfigUtils.getAPPLanguage(BaseActivity.this);

        if (languageIndex == 1) {
            configuration.locale = new Locale("en");
        } else if (languageIndex == 2) {
//            configuration.locale = new Locale("zh");
            configuration.locale = Locale.SIMPLIFIED_CHINESE;
        }
        rs.updateConfiguration(configuration, dm);
        ConfigUtils.setAppLanguage(BaseActivity.this, index);
    }
}
