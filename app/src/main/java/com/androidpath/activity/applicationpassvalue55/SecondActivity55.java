package com.androidpath.activity.applicationpassvalue55;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.main.ApplicationMain;

public class SecondActivity55 extends Activity {

    private ApplicationMain myGloable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second55);

        myGloable = (ApplicationMain) getApplication();
        String gender = myGloable.getGender();
        String name = myGloable.getName();

        TextView msgTextView = (TextView) findViewById(R.id.msg_text);
        String msg = null;
        if (gender.equals("女")) {
            msg = "欢迎" + name + "女士使用测试系统";
        } else {
            msg = "欢迎" + name + "先生使用测试系统";
        }
        msgTextView.setText(msg);
    }
}
