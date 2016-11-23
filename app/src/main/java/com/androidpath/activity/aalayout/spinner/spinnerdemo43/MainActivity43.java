package com.androidpath.activity.aalayout.spinner.spinnerdemo43;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity43 extends BaseActivity {

	private List<String> list;
	int count = 0;
	private ArrayAdapter<String> adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main43);
		
		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		
		list = new ArrayList<>();
		
		list.add("爱情买卖");
		list.add("纤夫的爱");
		list.add("好汉歌");
		list.add("让我们荡起双桨");
		list.add("黑猫警长");
		list.add("抓泥鳅");
		
		adapter = new ArrayAdapter<>(this,
				android.R.layout.simple_spinner_item,//使用的是安卓提供的布局的textview
				list);
		
		//设置下拉列表每一个子视图的样式
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		spinner.setAdapter(adapter);
		
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			//选中选项的时候回调， 参数一是：被选择的spinner对象
			//参数二是，被选中的子视图对象
			//参数三是，被点击的子视图的位置，从0开始-----用的最多
			//参数四是，被点击的子视图的位置，类型是long
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity43.this, "选择了："+list.get(position), 1).show();
			}

			//在没有选项被选中的时候回调
			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity43.this, "没有选中选项", 1).show();
				
			}
		});
		
	}
	
	//点击添加歌曲
	public void clickAdd(View view) {
		String name = "童年"+count;
		count++;
		
		list.add(name);//数据源发生改变，要通知adapter
		
		adapter.notifyDataSetChanged();//通知系统重新绘制视图
		
	}
	
	//点击删除歌曲	
	public void clickDelete(View view) {
		if (list.size()>0) {
			list.remove(0);
			adapter.notifyDataSetChanged();
		}
		
	}
}
