package com.androidpath.activity.aiviewpager.webview213;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.androidpath.R;

public class MainActivity213 extends Activity {

	private WebView webView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main213);
		
		initView();
	}

	private void initView() {
		webView = (WebView) findViewById(R.id.wv_id);
//		webView.loadUrl("http://www.baidu.com");
//		webView.loadData("<html><head></head><body><input name=\"user\" type=\"password\"/></body></html>", "text/html;charset=utf-8",null);
	
		webView.getSettings().setJavaScriptEnabled(true);//设置WebView支持JS
		webView.getSettings().setDefaultTextEncodingName("utf-8");//设置解码时的字符集
		webView.getSettings().setLoadWithOverviewMode(true);
		webView.getSettings().setUseWideViewPort(true);
		webView.getSettings().setSupportZoom(true);
		webView.getSettings().setBuiltInZoomControls(true);
		
		webView.setWebChromeClient(new WebChromeClient());//设置WebView支持特殊的JS，比如alert
		webView.setWebViewClient(new WebViewClient(){
			@Override
			public void onPageStarted(WebView view, String url, Bitmap favicon) {
				super.onPageStarted(view, url, favicon);
//				Log.d("print", "----->开始载入");
			}
			
			@Override
			public void onPageFinished(WebView view, String url) {
				super.onPageFinished(view, url);
//				Log.d("print", "----->载入完成");
			}
			
		});//设置WebView所有的超链接在本视图打开
	
		webView.addJavascriptInterface(new MyJS(this), "app");
		webView.loadUrl("file:///android_asset/login.html");
	}
	
	public void btnClick(View v){
		//android端调用js端的方法
		webView.loadUrl("javascript:android_method()");
	}
}
