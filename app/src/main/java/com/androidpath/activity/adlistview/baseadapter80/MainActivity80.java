package com.androidpath.activity.adlistview.baseadapter80;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ListView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;
import com.androidpath.activity.adlistview.baseadapter80.adapter.MyBaseAdapter80;
import com.androidpath.activity.adlistview.baseadapter80.bean.MyMenu80;

import java.util.ArrayList;
import java.util.List;

public class MainActivity80 extends BaseActivity {

    private String TAG=getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main80);

        ListView listView = (ListView) findViewById(R.id.listview);

        // 数据源：图片 菜名
        List<MyMenu80> list = new ArrayList<>();
        list.add(new MyMenu80(R.drawable.f058, "蛋炒饭"));
        list.add(new MyMenu80(R.drawable.f059, "拿破仑"));
        list.add(new MyMenu80(R.drawable.f060, "超级大西瓜"));
        list.add(new MyMenu80(R.drawable.f061, "拉菲"));
        list.add(new MyMenu80(R.drawable.f062, "大闸蟹"));

        //创建适配器对象
        //定义类继承Baseadapter,重写相应的方法
        final MyBaseAdapter80 adapter = new MyBaseAdapter80(this, list);

        listView.setAdapter(adapter);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            int i = 0;

            @Override
            public void run() {
                i++;
                if (i % 2 == 1) {
                    adapter.setSelect(true);
                } else {
                    adapter.setSelect(false);
                }
                Log.e(TAG, "run: "+i );
                    //再次执行设置颜色
                handler.postDelayed(this, 500);

            }
        }, 1000);


    }
}
