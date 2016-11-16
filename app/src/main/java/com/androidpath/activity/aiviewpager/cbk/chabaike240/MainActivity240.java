package com.androidpath.activity.aiviewpager.cbk.chabaike240;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.widget.ListView;

import com.androidpath.R;
import com.androidpath.activity.aiviewpager.cbk.chabaike240.adapter.NewsAdapterAbs_more;
import com.androidpath.activity.aiviewpager.cbk.chabaike240.model.NewsEntity;
import com.androidpath.activity.aiviewpager.cbk.chabaike240.util.Contants;
import com.androidpath.activity.aiviewpager.cbk.chabaike240.util.DownUtil;
import com.androidpath.activity.aiviewpager.cbk.chabaike240.util.JsonUtil;
import com.androidpath.activity.aiviewpager.cbk.chabaike240.util.NetWorkUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity240 extends Activity implements DownUtil.OnDownComplete {

    private ListView listView;
    //	private NewsAdapter newsAdapter;
//	private NewsAdapterAbs newsadapter;
//	private NewsAdapter_more newsAdapter_more;
    private NewsAdapterAbs_more newsAdapterAbs_more;

    private List<NewsEntity> datas;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main240);
        initView();
        //N
//        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        if (connectivityManager.isActiveNetworkMetered()) {
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//                switch (connectivityManager.getRestrictBackgroundStatus()) {
//                    case connectivityManager.
//                }
//            }
//        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        if (NetWorkUtil.isNetConnected(this)) {
            if (dialog != null) {
                dialog.dismiss();
            }
            loadDatas();
        } else {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("set network");
            builder.setMessage("NetWork disable");
            dialog = builder.setPositiveButton("setting moblie", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));

                }
            }).setNegativeButton("setting wifi", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                }
            }).show();
        }

    }

    private void initView() {
        datas = new ArrayList<NewsEntity>();
        listView = (ListView) findViewById(R.id.lv);
        newsAdapterAbs_more = new NewsAdapterAbs_more(this);
        listView.setAdapter(newsAdapterAbs_more);
    }

    private void loadDatas() {
        DownUtil.downJSON(Contants.URL.LZ_NEWS, this);
    }


    @Override
    public void onDownSucc(String url, Object obj) {
        if (obj != null) {
            String json = (String) obj;
            List<NewsEntity> datas = JsonUtil.getNewsByJSON(json);
//			newsadapter.setDatas(datas);
//			this.datas.addAll(datas);

            newsAdapterAbs_more.setDatas(datas);
        }
    }

}
