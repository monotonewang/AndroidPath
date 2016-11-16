package com.androidpath.activity.aealert.toastdemo116;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.androidpath.R;

public class MainActivity116 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main116);
    }

    public void clickToast(View view) {
        Toast toast = Toast.makeText(this, "调整toast位置", 1);
        toast.setGravity(Gravity.TOP | Gravity.LEFT,//位置
                0, //x方向的偏移量
                50);//y方向的偏移量
        toast.show();
    }

    public void clickCustomToast(View view) {
        Toast toast = new Toast(this);

        View toastView = getLayoutInflater().inflate(R.layout.toast_layout116, null);
        TextView contenTextView = (TextView) toastView.findViewById(R.id.toast_text);
        contenTextView.setText("这是自定义布局的toast");

        toast.setView(toastView);

        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }
}
