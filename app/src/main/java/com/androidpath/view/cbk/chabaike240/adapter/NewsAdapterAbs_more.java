package com.androidpath.view.cbk.chabaike240.adapter;

import android.content.Context;

import com.androidpath.R;
import com.androidpath.view.cbk.chabaike240.model.NewsEntity;

import java.util.List;


public class NewsAdapterAbs_more extends AbsBaseAdapter_more<NewsEntity> {
	
	public NewsAdapterAbs_more(Context context) {
		super(context, R.layout.item_news240, R.layout.item_newsmore240);
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
	public void bindDatas(ViewHolder viewHolder, NewsEntity data, int position) {
		if(getItemViewType(position) == 0){
			//单图
			viewHolder
			.bindTextView(R.id.tv_title, data.getData().getSubject())
			.bindTextView(R.id.tv_summey, data.getData().getSummary())
			.bindCacheImageView(R.id.iv_pic, data.getData().getCover());
		} else {
			//多图
			viewHolder
			.bindTextView(R.id.tv_title, data.getData().getSubject())
			.bindCacheImageView(R.id.iv_pic1, data.getData().getPics().get(0).getPhoto())
			.bindCacheImageView(R.id.iv_pic2, data.getData().getPics().get(1).getPhoto())
			.bindCacheImageView(R.id.iv_pic3, data.getData().getPics().get(2).getPhoto());
		}
	}

}
