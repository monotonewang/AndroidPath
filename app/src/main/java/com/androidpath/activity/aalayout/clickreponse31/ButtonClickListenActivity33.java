package com.androidpath.activity.aalayout.clickreponse31;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.androidpath.R;

public class ButtonClickListenActivity33 extends Activity implements OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main31);

        //1.找到事件源
        Button button = (Button) findViewById(R.id.button);
        Button button2 = (Button) findViewById(R.id.button2);

		/*Button button3 = (Button) findViewById(R.id.icon_button);
		button3.setOnClickListener(this);*/


        //让activity做按钮点击事件的监听器,前提是activity要实现监听接口
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    //会在按钮被点击的时候回调，参数是被点击的那个按钮对象
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v.getId() == R.id.button) {
            Toast.makeText(this, "用activity做监听器，点击按钮一。。。。", 0).show();
        } else {
            Toast.makeText(this, "用activity做监听器，点击按钮er。。。。", 0).show();

        }
    }


}
