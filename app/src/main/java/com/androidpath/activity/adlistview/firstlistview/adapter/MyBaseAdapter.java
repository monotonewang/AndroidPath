package com.androidpath.activity.adlistview.firstlistview.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.activity.adlistview.firstlistview.async.MyAsyncTaskImage;
import com.androidpath.activity.adlistview.firstlistview.bean.MyNews;

import java.util.List;


public class MyBaseAdapter extends BaseAdapter {
	private Context context;
	private List<MyNews> list;
	private String TAG="MyBaseAdapter";

	public MyBaseAdapter(Context context, List<MyNews> list) {
		// TODO Auto-generated constructor stub
		this.context=context;
		this.list=list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}
	/*	private String title;
	private String pic_url;
	private String now_price;
	private String origin_price;
	private String discount;
	private String start_discount;*/
	@SuppressLint("NewApi")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder viewHolder=null;
		if(convertView==null){
			convertView =View.inflate(context, R.layout.headline_news_f_lv, null);
			TextView titleTextView= (TextView) convertView.findViewById(R.id.title_TextView);
			TextView now_priceTextView= (TextView) convertView.findViewById(R.id.now_price);
			TextView origin_priceTextView= (TextView) convertView.findViewById(R.id.origin_price);
			TextView discountsTextView= (TextView) convertView.findViewById(R.id.discount);
			TextView start_discountTextView= (TextView) convertView.findViewById(R.id.discount_time);
			ImageView news_pic=(ImageView) convertView.findViewById(R.id.pic_url);
			viewHolder =new ViewHolder();
			viewHolder.setTitle(titleTextView);
			viewHolder.setNow_price(now_priceTextView);
			viewHolder.setOrigin_price(origin_priceTextView);
			viewHolder.setDiscount(discountsTextView);
			viewHolder.setStart_discount(start_discountTextView);
			viewHolder.setPic_url(news_pic);
			convertView.setTag(viewHolder);
		}else{
			viewHolder=(ViewHolder) convertView.getTag();
		}
		viewHolder.getTitle().setText(list.get(position).getTitle());
		viewHolder.getNow_price().setText(list.get(position).getNow_price());
		viewHolder.getOrigin_price().setText(list.get(position).getOrigin_price());
		viewHolder.getDiscount().setText(list.get(position).getDiscount());
		viewHolder.getStart_discount().setText(list.get(position).getStart_discount());
		ImageView newImage=viewHolder.getPic_url();
		String urlImage=list.get(position).getPic_url();
		newImage.setTag(urlImage);
//		Log.e(TAG, urlImage);
		if(!urlImage.equals("")){
			MyAsyncTaskImage myAsyncTaskImage= new MyAsyncTaskImage(newImage);
			myAsyncTaskImage.execute(urlImage);
		}else{
			newImage.setVisibility(View.GONE);
		}
		return convertView;
	}
}
