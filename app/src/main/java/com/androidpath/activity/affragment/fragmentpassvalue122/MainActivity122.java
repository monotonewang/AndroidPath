package com.androidpath.activity.affragment.fragmentpassvalue122;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.androidpath.R;

public class MainActivity122 extends Activity implements OnCheckedChangeListener,
		MyFragment.OnFragmentItemClickListener {

	private FragmentManager fragmentManager;
	private MyFragment msgFragment;
	private MyFragment contactFragment;
	FragmentTransaction transaction;
	private FindFragment findFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main122);

		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
		radioGroup.setOnCheckedChangeListener(this);

		// fragment的管理器对象
		fragmentManager = getFragmentManager();

		msgFragment = new MyFragment();
		contactFragment = new MyFragment();
		findFragment = new FindFragment();
		// 获得radiogroup中的下标为0的按钮，设置选中第一项
		RadioButton radioButton = (RadioButton) radioGroup.getChildAt(0);
		radioButton.setChecked(true);

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub

		switch (checkedId) {
		case R.id.msg_radio:
			// 添加微信的fragment
			transaction = fragmentManager.beginTransaction();

			// 当选择不同的时候传递不同的url，在fragment中根据传递的参数下载不同的数据
			Bundle bundle = new Bundle();
			bundle.putString("urlString", "www.msg.com");
			msgFragment.setArguments(bundle);
			//将fragment加入到会退栈
//			transaction.addToBackStack(null);
			
			
			transaction.replace(R.id.fragment_container, msgFragment, "微信界面");

			transaction.commit();
			break;
		case R.id.conu_radio:
			// 添加联系人的fragment
			transaction = fragmentManager.beginTransaction();

			bundle = new Bundle();
			bundle.putString("urlString", "www.contact.com");
			contactFragment.setArguments(bundle);
//			transaction.addToBackStack(null);
			
			transaction.replace(R.id.fragment_container, contactFragment,
					"联系人界面");
			transaction.commit();
			break;
		case R.id.find_radio:
			transaction = fragmentManager.beginTransaction();
			transaction.replace(R.id.fragment_container, findFragment);
			transaction.commit();
			break;
		case R.id.me_radio:

			break;
		}
	}

	@Override
	public void OnFragmentItemClick(String msg) {
		// TODO Auto-generated method stub
		Log.e("fragment中的数据传回activity", msg);
	}
}
