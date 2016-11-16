package com.androidpath.activity.abactivity.applicationpassvalue55;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.androidpath.R;
import com.androidpath.main.ApplicationMain;

/**
 * application pass value
 */
public class MainActivity55 extends Activity implements OnClickListener {

    private EditText nameEditText;
    private EditText ageEditText;
    private RadioGroup genderGroup;
    private Button button;
    private Button helpbutton;
    private ApplicationMain myGloable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main55);
        nameEditText = (EditText) findViewById(R.id.name_text);
        ageEditText = (EditText) findViewById(R.id.age_text);
        genderGroup = (RadioGroup) findViewById(R.id.gender_group);
        button = (Button) findViewById(R.id.ok_button);
        helpbutton = (Button) findViewById(R.id.help_button);

        button.setOnClickListener(this);
        helpbutton.setOnClickListener(this);

        // get application Object
        myGloable = (ApplicationMain) getApplication();
    }

    @Override
    public void onClick(View v) {
        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String gender = null;

        // 判断用户的输入，如果是空的就不跳转
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(age)) {
            Toast.makeText(this, "姓名和年龄不能为空！", Toast.LENGTH_LONG).show();
        } else {

            if (genderGroup.getCheckedRadioButtonId() == R.id.man_radio) {
                gender = "男";
            } else {
                gender = "女";
            }

            // 将数据存入application对象中
            myGloable.setName(name);
            myGloable.setAge(age);
            myGloable.setGender(gender);

            // 进入下一个界面，将数据传递给下一个界面,
            if (v.getId() == R.id.ok_button) {
                // 创建intent对象，参数二是目标组件的名称
                Intent intent = new Intent(this, ResultActivity55.class);
                // 启动activity
                startActivity(intent);

            } else if (v.getId() == R.id.help_button) {
                Intent intent = new Intent(this, SecondActivity55.class);
                startActivity(intent);
            }

        }

    }
}
