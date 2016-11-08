package com.androidpath.view.cbk.chabaike216;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.androidpath.R;
import com.androidpath.view.cbk.chabaike216.adapter.NewsAdapterAbs;
import com.androidpath.view.cbk.chabaike216.model.NewsEntity;
import com.androidpath.view.cbk.chabaike216.util.Contants;
import com.androidpath.view.cbk.chabaike216.util.DownUtil;
import com.androidpath.view.cbk.chabaike216.util.JsonUtil;

import java.util.List;

public class MainActivity216 extends Activity implements DownUtil.OnDownComplete {

    private ListView listView;
    //	private NewsAdapter newsAdapter;
    private NewsAdapterAbs newsadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main216);

        initView();
        loadDatas();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.lv);
        newsadapter = new NewsAdapterAbs(this);
        if (listView != null && newsadapter != null) {
            listView.setAdapter(newsadapter);
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
            newsadapter.setDatas(datas);
        }
    }

}
