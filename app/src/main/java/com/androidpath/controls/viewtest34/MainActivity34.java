package com.androidpath.controls.viewtest34;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.androidpath.R;

public class MainActivity34 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.textview_test_layout34);
		setContentView(R.layout.activity_main34);


        System.out.println("马上下课！");
        Log.e("ERROR", "自己弄出来的错误级别的日志");
        Log.d("Debug", "自己弄出来的调试级别的日志");

//        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.root_layout);
//
//        // 通过id号从布局文件中找到控件对象，在布局中必须给控件的id属性赋值
//        TextView textView = (TextView) findViewById(R.id.textView1);
//        textView.setText("要下课啦！");
//        // 参数一是单位， 参数二是大小 xml textsize 22sp
//        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
//        // 代码中颜色是用0xaaRRGGBB ,必须是八位十六进制数
//        textView.setTextColor(0xFFE2428C);
//
//        // 用构造方法创建textview对象,参数是上下文对象
//        // 上下文：程序的运行环境的描述对象,填this就代表上下文对象就是本activity
//        TextView textView2 = new TextView(this);
//        //将textview对象放入布局中
//        linearLayout.addView(textView2);
////        relativeLayout.addView(textView2);
//        textView2.setText("要过圣诞节啦！");
//        // 参数一是单位， 参数二是大小 xml textsize 22sp
//        textView2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
//        // 代码中颜色是用0xaaRRGGBB ,必须是八位十六进制数
//        textView2.setTextColor(0xFFE2428C);
//
//
//        TextView textView3 = new TextView(this);
//        //将textview对象放入布局中
//        linearLayout.addView(textView3);
////        relativeLayout.addView(textView3);
//        textView3.setText(100 + "");
//        // 参数一是单位， 参数二是大小 xml textsize 22sp
//        textView3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
//        // 代码中颜色是用0xaaRRGGBB ,必须是八位十六进制数
//        textView3.setTextColor(0xFFE2428C);
    }
}
