package com.androidpath.view.cbk.chabaike240;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.androidpath.R;
import com.androidpath.view.cbk.chabaike240.adapter.NewsAdapterAbs_more;
import com.androidpath.view.cbk.chabaike240.model.NewsEntity;
import com.androidpath.view.cbk.chabaike240.util.Contants;
import com.androidpath.view.cbk.chabaike240.util.DownUtil;
import com.androidpath.view.cbk.chabaike240.util.JsonUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity240 extends Activity implements DownUtil.OnDownComplete {

	private ListView listView;
//	private NewsAdapter newsAdapter;
//	private NewsAdapterAbs newsadapter;
//	private NewsAdapter_more newsAdapter_more;
	private NewsAdapterAbs_more newsAdapterAbs_more;
	
	private List<NewsEntity> datas;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main240);
		
		initView();
		loadDatas();
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
		if(obj != null){
			String json = (String) obj;
			List<NewsEntity> datas = JsonUtil.getNewsByJSON(json);
//			newsadapter.setDatas(datas);
//			this.datas.addAll(datas);
			
			newsAdapterAbs_more.setDatas(datas);
		}
	}

}
