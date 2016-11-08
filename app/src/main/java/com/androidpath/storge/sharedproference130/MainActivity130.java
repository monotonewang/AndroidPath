package com.androidpath.storge.sharedproference130;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidpath.R;

public class MainActivity130 extends Activity {

	private Button button;
	private EditText nameedEditText;
	private EditText ageedEditText;
	private String nameString;
	private int age;
	private SharedPreferences sharedPreferences;

	private Editor editor;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main130);
		
		button = (Button) findViewById(R.id.ok_button);
		nameedEditText = (EditText) findViewById(R.id.name_edit);
		ageedEditText = (EditText) findViewById(R.id.age_edit);
		nameString = null;
		age = -1;
		
		//1.获得共享参数对象:
		//参数一：保存的共享参数文件的文件名，不需要加后缀,系统会自动保存成xml格式
		//参数二：文件的权限和模式
		sharedPreferences = this.getSharedPreferences("usermsg", Context.MODE_PRIVATE);
		
		//参数一：关键字
		//参数二：如果关键字指定的值在xml文件中不存在，赋予的默认值,
		nameString = sharedPreferences.getString("name", "wenyi");
		age = sharedPreferences.getInt("age", 18);
		
		nameedEditText.setText(nameString);
		ageedEditText.setText(age+"");
		
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//获得用户输入的信息，保存起来
				String name = nameedEditText.getText().toString();
				String ageString = ageedEditText.getText().toString();
				if (!TextUtils.isEmpty(name)&& !TextUtils.isEmpty(ageString)) {
					Toast.makeText(MainActivity130.this, "登陆成功", 1).show();
					//2.获得editor对象
					editor = sharedPreferences.edit();
					//3.借助editor对象写入数据
					editor.putString("name", name);
					editor.putInt("age", Integer.parseInt(ageString));
					//4.提交
					editor.commit();
					
				}else {
					Toast.makeText(MainActivity130.this, "用户名和年龄不能为空", 1).show();
				}
				
			}
		});
	}
	
	
}
