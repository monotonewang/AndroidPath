package com.androidpath.container.optionmenu113;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.androidpath.R;

public class MainActivity113 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main113);
//        ActionBar actionBar = getActionBar();
//        actionBar.setTitle("actionbar");
    }

    //当用户点击menu键的时候回调，在这个方法中，系统会自动创建菜单对象，传参过来，
    //给菜单对象绑定布局
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //得到菜单加载器对象， 然后加载菜单布局
        getMenuInflater().inflate(R.menu.gender_menu, menu);

        return true;
    }

    //单击菜单项的时候回调，参数是就是被点击的item对象
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.man_item) {
            Toast.makeText(this, "选择了" + item.getTitle(), 0).show();
            //进入帮助页面
            return true;
        } else if (id == R.id.girl_item) {
            Toast.makeText(this, "选择了" + item.getTitle(), 0).show();
            //进入开始页面
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
