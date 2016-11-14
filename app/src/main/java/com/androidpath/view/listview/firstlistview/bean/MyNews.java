package com.androidpath.view.listview.firstlistview.bean;

public class MyNews {
	/*
	 * "list": [ { "rp_type": "101", "num_iid": "524540807157", "deal_num":
	 * "6426", "title": "iphone6s手机壳镜面", "pic_url":
	 * "http://img.alicdn.com/imgextra/i3/26597849/TB2fOPDjpXXXXccXXXXXXXXXXXX_!!26597849.jpg"
	 * , "now_price": 4.8, "show_time": "无", "origin_price": 10, "discount":
	 * 4.8, "start_discount": "2016-01-13 00:00:00", "is_vip_price": 0,
	 * "ling_value": 0, "is_onsale": 1, "total_love_number": 3,
	 * "total_hate_number": 0, "is_buy_sale": 0 },
	 */
	private String title;
	private String pic_url;
	private String now_price;
	private String origin_price;
	private String discount;
	private String start_discount;

	public MyNews(String title, String pic_url, String now_price,
				  String origin_price, String discount, String start_discount) {
		super();
		this.title = title;
		this.pic_url = pic_url;
		this.now_price = now_price;
		this.origin_price = origin_price;
		this.discount = discount;
		this.start_discount = start_discount;
	}

	@Override
	public String toString() {
		return "MyNews [title=" + title + ", pic_url=" + pic_url
				+ ", now_price=" + now_price + ", origin_price=" + origin_price
				+ ", discount=" + discount + ", start_discount="
				+ start_discount + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPic_url() {
		return pic_url;
	}

	public void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	public String getNow_price() {
		return now_price;
	}

	public void setNow_price(String now_price) {
		this.now_price = now_price;
	}

	public String getOrigin_price() {
		return origin_price;
	}

	public void setOrigin_price(String origin_price) {
		this.origin_price = origin_price;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getStart_discount() {
		return start_discount;
	}

	public void setStart_discount(String start_discount) {
		this.start_discount = start_discount;
	}

}
