package com.androidpath.storge.sql.sqlclienttwo152;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.androidpath.R;

public class MainActivity152 extends Activity {

	private ContentResolver resolver;
	private String stuUriString = "content://com.androidpath.sql.sqlclienttwo152.mycontentprovider/student";
	private String teaUriString = "content://com.androidpath.sql.sqlclienttwo152.mycontentprovider/teacher";
	private EditText nameEditText;
	private EditText scoreEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main152);
		resolver = getContentResolver();
	}

	// 将数据插入到学生表
	public void clickStudentInsert(View view) {
		//实例化自定义的对话框布局
		View dialogView = getLayoutInflater().inflate(
				R.layout.stu_dialog_layout152, null);

		nameEditText = (EditText) dialogView.findViewById(R.id.name_edit);
		scoreEditText = (EditText) dialogView.findViewById(R.id.score_edit);

		new AlertDialog.Builder(this).setView(dialogView).setTitle("请输入信息：")
				.setPositiveButton("确定", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						String name = nameEditText.getText().toString();
						int score = Integer.parseInt(scoreEditText.getText()
								.toString());

						Uri uri = Uri.parse(stuUriString);
						ContentValues values = new ContentValues();

						values.put("name", name);
						values.put("score", score);

						resolver.insert(uri, values);
					}
				}).show();

	}

	public void clickTeacherInsert(View view) {
		Uri uri = Uri.parse(teaUriString);
		ContentValues values = new ContentValues();

		values.put("name", "xusha");
		values.put("salary", 2999);
		resolver.insert(uri, values);
	}

	public void clickStudentQurey(View view) {
		// 查询id为1的记录
		// uri字符串定义成："content://com.example.day15providerserver2.mycontentprovider/student/id/1"
		// 通过这个uri查询数据，功能等价于以下查询方式：
		// Cursor cursor = resolver.query(uri, null, "_id=?", new String[]{"1"}, null);
//		Uri uri = Uri.parse(stuUriString + "/id/5");
		
		Uri uri = Uri.parse(stuUriString + "/name/en");
		Cursor cursor = resolver.query(uri, null, null, null, null);
		// 通过这个uri查询数据，功能等价于以下查询方式：
		// Cursor cursor = resolver.query(uri, null, "name like ?", new String[]{"%"+"en"+"%"}, null);
		if (cursor != null) {
			cursor.moveToFirst();
			while (true) {
				String name = cursor.getString(cursor.getColumnIndex("name"));
				int score = cursor.getInt(cursor.getColumnIndex("score"));
				Log.e("根据name含有en查询到", name+":"+score);
				
				if (!cursor.moveToNext()) {
					break;
				}
			}
		}else {
			Log.e("根据name含有en查询到", "没有数据符合条件");
		}
		

	}

}
