package com.androidpath.activity.aiviewpager.cbk.chabaike240.adapter;

import android.content.Context;

import com.androidpath.R;
import com.androidpath.activity.aiviewpager.cbk.chabaike240.model.NewsEntity;


public class NewsAdapterAbs extends AbsBaseAdapter<NewsEntity> {

	public NewsAdapterAbs(Context context) {
		super(context, R.layout.item_news240);
	}

	@Override
	public void bindDatas(ViewHolder viewHolder, NewsEntity newsEntity) {
//		CacheImageView civ = (CacheImageView) viewHolder.getView(R.id.iv_pic);
//		civ.setUrl(newsEntity.getData().getCover());
//		
//		TextView tv = (TextView) viewHolder.getView(R.id.tv_title);
//		tv.setText(newsEntity.getData().getSubject());
//		
//		TextView tv2 = (TextView) viewHolder.getView(R.id.tv_summey);
//		tv2.setText(newsEntity.getData().getSummary());
		
		viewHolder
		.bindCacheImageView(R.id.iv_pic, newsEntity.getData().getCover())
		.bindTextView(R.id.tv_title, newsEntity.getData().getSubject())
		.bindTextView(R.id.tv_summey, newsEntity.getData().getSummary());
	}

}
