package com.androidpath.project.music.adapter;

import android.content.Context;

import com.androidpath.R;
import com.androidpath.project.music.Entity.PublicListEntity;


public class PublicItemAdapter extends AbsBaseAdapter<PublicListEntity> {

	public PublicItemAdapter(Context context, int resid) {
		super(context, R.layout.music_frag_public_music_item_listview1);
	}

	@Override
	public void bindDatas(
			AbsBaseAdapter<PublicListEntity>.ViewHolder viewHolder,
			PublicListEntity data) {
		viewHolder.bindTextView(R.id.textView, data.getName())
		.bindCacheImageView(R.id.iv, data.getThumb());
	}
	
}
