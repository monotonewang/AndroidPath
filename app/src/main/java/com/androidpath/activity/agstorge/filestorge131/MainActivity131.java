package com.androidpath.activity.agstorge.filestorge131;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidpath.R;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity131 extends Activity {

	private Button internalButton;
	private EditText nameedEditText;
	private EditText ageedEditText;
	private SharedPreferences sharedPreferences;

	private Editor editor;
	private Button externalButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main131);

		nameedEditText = (EditText) findViewById(R.id.name_edit);
		ageedEditText = (EditText) findViewById(R.id.age_edit);
		
		try {
			FileInputStream fis = openFileInput("save.txt");
			DataInputStream dis = new DataInputStream(fis);
			
			String name = dis.readUTF();
			int age = dis.readInt();
			nameedEditText.setText(name);
			ageedEditText.setText(age+"");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

	public void clickInternal(View view) {
		String name = nameedEditText.getText().toString();
		String ageString = ageedEditText.getText().toString();
		if (!TextUtils.isEmpty(name)&& !TextUtils.isEmpty(ageString)) {
			//保存到内部文件,
			//参数一：文件名，不需加路径,会自动在/data/data/包名/files/save.txt
			//参数二：文件的权限
			try {
				FileOutputStream fileOutput = openFileOutput("save.txt", Context.MODE_APPEND);
				//name(String)  age(int)
				DataOutputStream dos = new DataOutputStream(fileOutput);
				dos.writeUTF(name);
				dos.writeInt(Integer.parseInt(ageString));
				
				
				fileOutput.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			Toast.makeText(MainActivity131.this, "用户名和年龄不能为空", 1).show();
		}
	}

	public void clickExternal(View view) {
		String name = nameedEditText.getText().toString();
		String ageString = ageedEditText.getText().toString();
		if (!TextUtils.isEmpty(name)&& !TextUtils.isEmpty(ageString)) {
		}
		else {
			Toast.makeText(MainActivity131.this, "用户名和年龄不能为空", 1).show();
			
		}
	}

}
