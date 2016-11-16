package com.androidpath.activity.aiviewpager.webview213;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class MyJS {

	public Context context;
	
	public MyJS(Context context){
		this.context = context;
	}
	
	@JavascriptInterface
	public void js_method(){
		Toast.makeText(context, "---->android端的方法被调用", 1).show();
	}
}
