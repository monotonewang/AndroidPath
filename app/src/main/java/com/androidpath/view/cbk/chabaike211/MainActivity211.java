package com.androidpath.view.cbk.chabaike211;


import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.androidpath.R;
import com.androidpath.view.cbk.chabaike211.adapter.NewsAdapter;
import com.androidpath.view.cbk.chabaike211.model.NewsEntity;
import com.androidpath.view.cbk.chabaike211.util.Contants;
import com.androidpath.view.cbk.chabaike211.util.DownUtil;
import com.androidpath.view.cbk.chabaike211.util.JsonUtil;

import java.util.List;

public class MainActivity211 extends Activity implements DownUtil.OnDownComplete {

    private ListView listView;
    private NewsAdapter newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main211);

        initView();
        loadDatas();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.lv);
        newsAdapter = new NewsAdapter(this);
        if (listView != null && newsAdapter != null) {
            listView.setAdapter(newsAdapter);
        }

    }

    private void loadDatas() {
        DownUtil.downJSON(Contants.URL.LZ_NEWS, this);
    }


    @Override
    public void onDownSucc(String url, Object obj) {
        if (obj != null) {
            String json = (String) obj;
            List<NewsEntity> datas = JsonUtil.getNewsByJSON(json);
            newsAdapter.setDatas(datas);
        }
    }

}


