package com.androidpath.activity.aiviewpager.cbk.chabaike211.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.activity.aiviewpager.cbk.chabaike211.custem.CacheImageView;
import com.androidpath.activity.aiviewpager.cbk.chabaike211.model.NewsEntity;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends BaseAdapter {
	
	private Context context;
	private List<NewsEntity> datas;
	
	public NewsAdapter(Context context){
		this.context = context;
		datas = new ArrayList<NewsEntity>();
	}
	
	public void setDatas(List<NewsEntity> datas){
		this.datas = datas;
		this.notifyDataSetChanged();
	}
	
	public void addDatas(List<NewsEntity> datas){
		this.datas.addAll(datas);
		this.notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return datas.size();
	}

	@Override
	public Object getItem(int arg0) {
		return datas.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	/**
	 * 图片的三级缓存 --> 内存缓存 - 磁盘缓存 - 网络缓存
	 * 
	 */
	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		ViewHolder viewHolder;
		if(arg1 != null){
			viewHolder = (ViewHolder) arg1.getTag();
		} else {
			viewHolder = new ViewHolder();
			arg1 = LayoutInflater.from(context).inflate(R.layout.item_news211, null);
			viewHolder.iv = (CacheImageView) arg1.findViewById(R.id.iv_pic);
			viewHolder.title = (TextView) arg1.findViewById(R.id.tv_title);
			viewHolder.summey = (TextView) arg1.findViewById(R.id.tv_summey);
			arg1.setTag(viewHolder);
		}
		
		//进行赋值的操作
		viewHolder.iv.setUrl(datas.get(arg0).getData().getCover());
		viewHolder.title.setText(datas.get(arg0).getData().getSubject());
		viewHolder.summey.setText(datas.get(arg0).getData().getSummary());
		return arg1;
	}
	
	class ViewHolder{
		CacheImageView iv;
		TextView title, summey;
	}

}
