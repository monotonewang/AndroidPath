package com.androidpath.activity.aalayout.spinner.spinnerdemo42;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.androidpath.R;

public class MainActivity42 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main42);
		
		Spinner menuSpinner = (Spinner) findViewById(R.id.menu_spinner);
		
		
		//1.获得资源中的字符串数组
		String[] strings = getResources().getStringArray(R.array.menu_array);
		
		
		//2.创建适配器对象,泛型就填要匹配的数据的类型
		/*
		//方法一，直接使用静态方法创建arrayadpter
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
				R.array.menu_array,//数组资源id
				R.layout.item_layout);//子视图id：就是一个textview，
		*/
		
		//方法二，使用构造方法创建
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
				R.layout.item_layout, //根标签是Textview的布局的id号
				strings);//数据源数组
		
/*
		//方法三，使用构造方法创建
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
				R.layout.item_layout_2, //含有一个Textview的布局的id号
				R.id.item_textView,//布局中的要匹配数据的textview的id
				strings);//数据源数组
		*/
		
	
		//3.将适配器设置给控件
		menuSpinner.setAdapter(adapter);
	
	/*	TextView textView = ((TextView)menuSpinner.getSelectedView());
		
		Log.e("", textView.getText().toString());*/
	}
	
}
