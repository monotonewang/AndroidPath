package com.androidpath.view.normal.checkradio41;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.androidpath.R;

public class MainActivity41 extends Activity implements OnCheckedChangeListener, OnClickListener {

	private CheckBox movieBox;//属性：引用，全局变量
	private CheckBox codingBox;
	private CheckBox meetBox;
	private RadioGroup radioGroup;
	private Button button;
	
	
	//回调方法：生命周期方法，当系统创建好activity后就立马调用的
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//绑定布局：实际上系统会自动实例化布局文件中的view控件（new CheckBox(context, attrs)）
		setContentView(R.layout.activity_main41);
		
		
		//找控件的代码应该在绑定布局后
		movieBox = (CheckBox) findViewById(R.id.movie_check);
		codingBox = (CheckBox) findViewById(R.id.coding_check);
		meetBox = (CheckBox) findViewById(R.id.meet_check);
		button = (Button) findViewById(R.id.ok_button);
		radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
		
		//给radiogroup 注册监听器
		/*
		 * RadioGroup.OnCheckedChangeListener，
		 * CompoundButton.OnCheckedChangeListener
		 * 如果在同一个类中使用的接口同名了，这时就要让其中一个接口的名字写上包名+类名的全名，或者写上外部类名+接口名
		 * 
		 * */
		radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
			//参数一是被选择的RadioGroup，参数二就是被选中的Radiobutton的id号
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				Log.e("checkedId", Integer.toHexString(checkedId)+"");
				
				if (checkedId == R.id.radio_all) {
					//全选
					
					movieBox.setChecked(true);
					codingBox.setChecked(true);
					meetBox.setChecked(true);
				}else if (checkedId == R.id.radio_none) {
					//全不选
					movieBox.setChecked(false);
					codingBox.setChecked(false);
					meetBox.setChecked(false);
				}
			}
		});
		
		
		
		
		movieBox.setOnCheckedChangeListener(this);
		codingBox.setOnCheckedChangeListener(this);
		meetBox.setOnCheckedChangeListener(this);
	/*	
		movieBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			//当checkbox的选中状态改变的时候就会回调，参数一是被选择或取消的view对象， 参数二是是否选中
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					Toast.makeText(MainActivity41.this, "选中了看电影", Toast.LENGTH_LONG).show();
				}else {
					Toast.makeText(MainActivity41.this, "取消了了看电影", Toast.LENGTH_LONG).show();
				}
			}
		});*/
		
		
		
		button.setOnClickListener(this);
	}

	
//回调方法
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		/*if (buttonView.getId() == R.id.coding_check) {
			if (isChecked) {
				Toast.makeText(MainActivity41.this, "选中了敲代码", Toast.LENGTH_LONG).show();
			}else {
				Toast.makeText(MainActivity41.this, "取消了了敲代码", Toast.LENGTH_LONG).show();
			}
		}else if (buttonView.getId() == R.id.meet_check) {
			if (isChecked) {
				Toast.makeText(MainActivity41.this, "选中了约会", Toast.LENGTH_LONG).show();
			}else {
				Toast.makeText(MainActivity41.this, "取消了约会", Toast.LENGTH_LONG).show();
			}
		}*/
		
		if (isChecked) {
			Toast.makeText(MainActivity41.this, "选中了"+buttonView.getText().toString(), Toast.LENGTH_LONG).show();
		}else{
			Toast.makeText(MainActivity41.this, "取消了"+buttonView.getText().toString(), Toast.LENGTH_LONG).show();
			
		}
	}



	//回调方法
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		//获取所有选中的选项：遍历所有的checkbox，判断是否选中
		String msg = "";
		if (movieBox.isChecked()) {
			msg += movieBox.getText().toString();
		}
		if (codingBox.isChecked()) {
			msg += "\n"+codingBox.getText().toString();
		}
		if (meetBox.isChecked()) {
			msg += "\n"+meetBox.getText().toString();
		}
		
		Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
		
	}
}
