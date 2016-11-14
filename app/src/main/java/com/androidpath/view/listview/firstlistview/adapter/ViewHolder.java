package com.androidpath.view.listview.firstlistview.adapter;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {
	/*	private String title;
	private String pic_url;
	private String now_price;
	private String origin_price;
	private String discount;
	private String start_discount;*/
	private TextView title;
	private TextView now_price;
	private TextView origin_price;
	private TextView discount;
	private TextView start_discount;
	private ImageView pic_url;
	public TextView getTitle() {
		return title;
	}
	public void setTitle(TextView title) {
		this.title = title;
	}
	public TextView getNow_price() {
		return now_price;
	}
	public void setNow_price(TextView now_price) {
		this.now_price = now_price;
	}
	public TextView getOrigin_price() {
		return origin_price;
	}
	public void setOrigin_price(TextView origin_price) {
		this.origin_price = origin_price;
	}
	public TextView getDiscount() {
		return discount;
	}
	public void setDiscount(TextView discount) {
		this.discount = discount;
	}
	public TextView getStart_discount() {
		return start_discount;
	}
	public void setStart_discount(TextView start_discount) {
		this.start_discount = start_discount;
	}
	public ImageView getPic_url() {
		return pic_url;
	}
	public void setPic_url(ImageView pic_url) {
		this.pic_url = pic_url;
	}
}
