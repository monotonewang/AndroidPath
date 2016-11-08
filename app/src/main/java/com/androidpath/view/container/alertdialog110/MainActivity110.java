package com.androidpath.view.container.alertdialog110;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.androidpath.R;

import java.util.ArrayList;

public class MainActivity110 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main110);
	}

	public void clickAlertDialog(View view) {
		// 1.创建Dialog.Builder对象
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		// 2.进行一个对话框参数的设置
		builder.setIcon(R.drawable.msg_state_fail_resend_pressed)
				.setTitle("警告").setMessage("是否访问百度的官方网站?")
				.setPositiveButton("确定", new OnClickListener() {

					// 在点击确定按钮的时候回调
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent intent = new Intent(Intent.ACTION_VIEW);
						intent.setData(Uri.parse("http://www.baidu.com"));
						startActivity(intent);
					}
				}).setNegativeButton("取消", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						dialog.dismiss();
					}
				});

		// 3.创建对话框
		/*
		 * AlertDialog alertDialog = builder.create(); alertDialog.show();
		 */
		builder.show();
	}

	public void clickSingleDialog(View view) {
		final String[] items = { "美女", "帅哥", "人妖" };

		new AlertDialog.Builder(this).setTitle("请选择你的性别")
				.setSingleChoiceItems(items, 1, new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Toast.makeText(MainActivity110.this, "你是" + items[which],
								0).show();
						dialog.dismiss();
					}
				}).show();
	}

	public void clickMultiDialog(View view) {
		final String[] items = {"鲍鱼","河豚","土豆丝","红烧茄子"};
		
		
		//创建一个集合用于保存选中的选项
		final ArrayList<String > selectedItem = new ArrayList<>();
		
		new AlertDialog.Builder(MainActivity110.this).setTitle("请选择要点的菜")
		.setMultiChoiceItems(items, new boolean[]{false,false,false,false}, new OnMultiChoiceClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked) {
					selectedItem.add(items[which]);
				}else if (selectedItem.contains(items[which])) {
					selectedItem.remove(items[which]);
				}
			}
		})
		.setPositiveButton("确定", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity110.this, "你选择了："+selectedItem.toString(), 0).show();
			}
		})
		.setNegativeButton("取消", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		}).show();
	}

	public void clickProgressDialog(View view) {
//		ProgressDialog.show(this, "下载数据", "正在下载，请稍候");
		ProgressDialog dialog = new ProgressDialog(this);
		dialog.setTitle("下载数据");
		dialog.setMessage("正在下载，请稍候");
		dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		
		dialog.show();
		
//		dialog.dismiss();
	}
}
