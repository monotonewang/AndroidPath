package com.androidpath.activity.affragment.dynicaddfragment123;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

//
public class MainActivity123 extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main123);
	}
	
	public void clickAddFragment(View view) {
		TitleFragment titleFragment = new TitleFragment();
		
		//1.获得fragmenManager对象
		FragmentManager fragmentManager = getFragmentManager();
		//2.通过管理器对象开始一个事务
		FragmentTransaction transaction = fragmentManager.beginTransaction();
		//3.调用事务对象的add方法添加fragment到指定的容器中
		transaction.add(R.id.title_frame_cotainer,//要添加到的容器的id号
				titleFragment, //要添加的fragment对象
				"标题栏fragment");//fragment的标签
		
		//4.提交事务
		transaction.commit();
	}
	
	
}
