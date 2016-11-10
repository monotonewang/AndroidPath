package com.androidpath.activity.activitypassvalue54;

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
import com.androidpath.main.BaseActivity;

public class MainActivity54 extends BaseActivity implements OnClickListener {

    private EditText nameEditText;
    private EditText ageEditText;
    private RadioGroup genderGroup;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main54);
        nameEditText = (EditText) findViewById(R.id.name_text);
        ageEditText = (EditText) findViewById(R.id.age_text);
        genderGroup = (RadioGroup) findViewById(R.id.gender_group);
        button = (Button) findViewById(R.id.ok_button);


        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        //获得用户的输入，传给下一个界面
        String name = nameEditText.getText().toString();
        String age = ageEditText.getText().toString();
        String gender = null;
        if (genderGroup.getCheckedRadioButtonId() == R.id.man_radio) {
            gender = "男";
        } else {
            gender = "女";
        }

        //判断用户的输入，如果是空的就不跳转
        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(age)) {
            Toast.makeText(this, "姓名和年龄不能为空！", Toast.LENGTH_LONG).show();
        } else {
            //进入下一个界面，将数据传递给下一个界面,
            //创建intent对象，参数二是目标组件的名称
            Intent intent = new Intent(this, ResultActivity54.class);
            /*用intent传递数据的方法一
			intent.putExtra("name", name);
			intent.putExtra("age", age);
			intent.putExtra("gender", gender);*/

//			用intent传递数据的方法二
            //将数据打包到bundle中
            Bundle bundle = new Bundle();
            bundle.putString("name", name);
            bundle.putString("age", age);
            bundle.putString("gender", gender);
            //将bundle放入intent
            intent.putExtras(bundle);

            //启动activity
            startActivity(intent);
        }

    }
}
