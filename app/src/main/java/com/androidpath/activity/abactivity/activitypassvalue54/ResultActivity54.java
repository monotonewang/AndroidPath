package com.androidpath.activity.abactivity.activitypassvalue54;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.main.BaseActivity;

import java.util.Calendar;

public class ResultActivity54 extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result_layout54);
		TextView scoreTextView = (TextView) findViewById(R.id.score_text);
		TextView descripeTextView = (TextView) findViewById(R.id.descripe_text);

		Intent intent = getIntent();
		/*
		//接收数据的方法一
		String name = intent.getStringExtra("name");
		String age = intent.getStringExtra("age");
		String gender = intent.getStringExtra("gender");*/
		
		//接收数据的方法二
		//先获得bundle对象
		Bundle bundle = intent.getExtras();
		//从bundle中获得数据
		String name = bundle.getString("name");
		String age = bundle.getString("age");
		String gender = bundle.getString("gender");

		// 进行计算，得到分数
		int score = calculateScore(name, age, gender);

		// 展示
		scoreTextView.setText("你的艳遇分数：" + score + "分");

		/*
		 * >90 "你的艳遇指数过高，没事别乱放电啦";
		 *  >70 "你的艳遇指数一般，需要主动出击"; 
		 *  >50 "你还是老老实实的坐车，别想着有艳遇，如果强行为之，小心你的腿"; 
		 *  else "你如果能碰到艳遇，那么彗星就有可能撞地球";
		 */
		String descripe = null;
		if (score > 90) {
			descripe = "你的艳遇指数过高，没事别乱放电啦";
		} else if (score > 70) {
			descripe = "你的艳遇指数一般，需要主动出击";
		} else if (score > 50) {
			descripe = "你还是老老实实的坐车，别想着有艳遇，如果强行为之，小心你的腿";
		} else {
			descripe = "你如果能碰到艳遇，那么彗星就有可能撞地球";
		}

		descripeTextView.setText("你的艳遇总评：" + descripe);

	}

	private int calculateScore(String name, String age, String gender) {
		// TODO Auto-generated method stub
		Calendar calendar = Calendar.getInstance();
		int score = Math.abs((name.hashCode() + age.hashCode()
				+ gender.hashCode() + calendar.get(Calendar.YEAR)
				+ calendar.get(Calendar.DAY_OF_MONTH) + calendar
				.get(Calendar.MONTH)) % 100);
		return score;
	}
}
