package com.androidpath.view.listview.adddata81;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.androidpath.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity81 extends Activity {

    private ListView listView;
    private int count = 0;
    private List<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main81);


        listView = (ListView) findViewById(R.id.listview);

        String[] array = {"LOL", "DOTA", "WOW", "斗地主", "偷菜"};
        list = new ArrayList<>();

        for (String str : array) {
            list.add(str);
        }

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1,
                list);

        listView.setAdapter(adapter);
    }

    public void clickAdd(View view) {
        String name = "CS";
        count++;
        //将新数据加入，然后更新视图
        list.add(name + count);

        adapter.notifyDataSetChanged();
    }
}
