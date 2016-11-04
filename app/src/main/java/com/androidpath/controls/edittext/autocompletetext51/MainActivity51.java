package com.androidpath.controls.edittext.autocompletetext51;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.androidpath.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity51 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main51);
		AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.edit_text);
		EditText editText = (EditText) findViewById(R.id.text_view);
		
		//给edittext注册一个文本输入变化的监听器
		editText.addTextChangedListener(new TextWatcher() {
			
			//文本正在变化的时候回调
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				Log.e("onTextChanged", s.toString());
			}
			
			//文本正在变化之前回调
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				Log.e("beforeTextChanged", s.toString());
			}
			//文本正在变化之后回调
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Log.e("afterTextChanged", s.toString());
			}
		});
		
		List<String> list = new ArrayList<>();
		
		list.add("红烧肉");
		list.add("红烧茄子");
		list.add("红烧鱼");
		list.add("红烧豆腐");
		list.add("红焖大虾");
		list.add("叉烧包");
		list.add("手撕包菜");
		list.add("手撕牛肉");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
		
		autoCompleteTextView.setAdapter(adapter);
		
	}
}
