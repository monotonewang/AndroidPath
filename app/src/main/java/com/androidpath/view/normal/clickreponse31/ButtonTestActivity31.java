package com.androidpath.view.normal.clickreponse31;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.androidpath.R;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/3 15:05 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class ButtonTestActivity31 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_test_layout31);
    }

    //按钮的事件响应方法，必须是public 方法   ，返回值必须是void 参数必须是View型的
    //按钮被点击的时候会回调，参数是系统传过来的被点击的View对象
    public void clickPrint(View view) {
        System.out.println("用属性设置响应！");
        Log.e("ERROTAG", "xcfdfdsfdsf");
        switch (view.getId()) {
            case R.id.text_button:
                Toast.makeText(this,//上下文对象
                        "点击了第一个文字按钮，弹出toast- 跳到buttonclick", //toast的消息内容
                        Toast.LENGTH_LONG)//显示的时间
                        .show();
                SystemClock.sleep(1000);
                Intent intent31 = new Intent(ButtonTestActivity31.this, ButtonClickListenActivity31.class);
                startActivity(intent31);
                break;
            case R.id.icon_button:
                Toast.makeText(this,//上下文对象
                        "点击了第二个的图标按钮，弹出toast-跳到buttonclick", //toast的消息内容
                        Toast.LENGTH_LONG)//显示的时间
                        .show();
                SystemClock.sleep(1000);
                Intent intent32 = new Intent(ButtonTestActivity31.this, ButtonClickListenActivity32.class);
                startActivity(intent32);
                break;
            case R.id.icon_text_button:
                Toast.makeText(this,//上下文对象
                        "点击了第三个文字图片的按钮，弹出toast-跳到buttonclick", //toast的消息内容
                        Toast.LENGTH_LONG)//显示的时间
                        .show();
                SystemClock.sleep(1000);
                Intent intent33 = new Intent(ButtonTestActivity31.this, ButtonClickListenActivity33.class);
                startActivity(intent33);
                break;
            default:
                break;
        }
    }
}
