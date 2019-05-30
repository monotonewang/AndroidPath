package com.androidpath.activity.aiviewpager.webview213;

import android.os.Bundle;
import androidx.annotation.Nullable;
import android.webkit.WebView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

public class MainActivity2131 extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2131);
        WebView webView=findViewById(R.id.web_view);
        webView.loadUrl("file:///android_asset/web/03_home_page_mobile.html");

    }
}
