package com.androidpath.view.cbk.chabaike216.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.view.cbk.chabaike216.custem.CacheImageView;
import com.androidpath.view.cbk.chabaike216.model.NewsEntity;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter_more extends BaseAdapter {
	
	private Context context;
	private List<NewsEntity> datas;
	
	public NewsAdapter_more(Context context){
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
			if(getItemViewType(arg0) == 0){
				arg1 = LayoutInflater.from(context).inflate(R.layout.item_news216, null);
				viewHolder.iv = (CacheImageView) arg1.findViewById(R.id.iv_pic);
				viewHolder.title = (TextView) arg1.findViewById(R.id.tv_title);
				viewHolder.summey = (TextView) arg1.findViewById(R.id.tv_summey);
			} else if(getItemViewType(arg0) == 1){
				arg1 = LayoutInflater.from(context).inflate(R.layout.item_newsmore216, null);
				viewHolder.iv = (CacheImageView) arg1.findViewById(R.id.iv_pic1);
				viewHolder.iv2 = (CacheImageView) arg1.findViewById(R.id.iv_pic2);
				viewHolder.iv3 = (CacheImageView) arg1.findViewById(R.id.iv_pic3);
				viewHolder.title = (TextView) arg1.findViewById(R.id.tv_title);
			}
			
			arg1.setTag(viewHolder);
		}
		
		//进行赋值的操作
		if(getItemViewType(arg0) == 0){
			viewHolder.iv.setUrl(datas.get(arg0).getData().getCover());
			viewHolder.title.setText(datas.get(arg0).getData().getSubject());
			viewHolder.summey.setText(datas.get(arg0).getData().getSummary());
		} else if(getItemViewType(arg0) == 1){
			viewHolder.iv.setUrl(datas.get(arg0).getData().getPics().get(0).getPhoto());
			viewHolder.iv2.setUrl(datas.get(arg0).getData().getPics().get(1).getPhoto());
			viewHolder.iv3.setUrl(datas.get(arg0).getData().getPics().get(2).getPhoto());
			viewHolder.title.setText(datas.get(arg0).getData().getSubject());
		}
		return arg1;
	}
	
	class ViewHolder{
		CacheImageView iv, iv2, iv3;
		TextView title, summey;
	}

	@Override
	public int getItemViewType(int position) {
		List<NewsEntity.Desc.Images> list = datas.get(position).getData().getPics();
		if(list != null && list.size() > 0){
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int getViewTypeCount() {
		return 2;
	}
	
	

}
