package com.androidpath.spinnersimpleAdapter44;

import android.app.Activity;
import android.os.Bundle;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import com.androidpath.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity44 extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main44);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        String[] names = {"芙蓉姐姐", "潇洒哥", "凤姐", "犀利哥"};
        int[] imageIds = {R.drawable.emoji_095, R.drawable.emoji_096,
                R.drawable.emoji_097, R.drawable.emoji_098,};

        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

        for (int i = 0; i < imageIds.length; i++) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("name", names[i]);
            hashMap.put("icon", imageIds[i]);

            list.add(hashMap);
        }


//		SimpleAdapter(Context context, List<? extends Map<String, ?>> data, int resource, String[] from, int[] to)
        SimpleAdapter adapter = new SimpleAdapter(this,
                list,//数据：是map组成的list集合
                R.layout.item_layout44,//子视图布局的id
                new String[]{"name", "icon"},//集合的元素的关键字组成的数组
                new int[]{R.id.name_text, R.id.icon_image});//子视图中的控件的id数组
        spinner.setAdapter(adapter);

    }


}
