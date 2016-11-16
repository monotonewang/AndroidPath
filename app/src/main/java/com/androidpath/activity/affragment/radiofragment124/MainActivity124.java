package com.androidpath.activity.affragment.radiofragment124;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.androidpath.R;

public class MainActivity124 extends Activity implements OnCheckedChangeListener {

	private FragmentManager fragmentManager;
	private MsgFragment msgFragment;
	private ContantFragment contantFragment;
	FragmentTransaction transaction ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main124);

		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
		radioGroup.setOnCheckedChangeListener(this);

		//fragment的管理器对象
		fragmentManager = getFragmentManager();
		msgFragment = new MsgFragment();
		contantFragment = new ContantFragment();

		//获得radiogroup中的下标为0的按钮，设置选中第一项
		RadioButton radioButton = (RadioButton) radioGroup.getChildAt(0);
		radioButton.setChecked(true);

		//先将所有的fragment加入到容器中，在选中某个选项的时候，隐藏其他的fragment 显示想要看见的
		transaction = fragmentManager.beginTransaction();
		transaction.add(R.id.fragment_container, msgFragment);
		transaction.add(R.id.fragment_container, contantFragment);
		transaction.commit();

	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub

		switch (checkedId) {
		case R.id.msg_radio:
			//添加微信的fragment
			transaction = fragmentManager.beginTransaction();

			//替换
//			transaction.replace(R.id.fragment_container, msgFragment, "微信界面");

			transaction.hide(contantFragment);
			transaction.show(msgFragment);

			transaction.commit();
			break;
		case R.id.conu_radio:
			//添加联系人的fragment
			transaction = fragmentManager.beginTransaction();
//			transaction.replace(R.id.fragment_container,contantFragment, "联系人界面");

			transaction.hide(msgFragment);
			transaction.show(contantFragment);

			transaction.commit();
			break;

		default:
			break;
		}
	}
}
