package com.androidpath.activity.adlistview.baseadapter80.bean;

public class MyMenu80 {
	private int picId;
	private String name;
	public int getPicId() {
		return picId;
	}
	public void setPicId(int picId) {
		this.picId = picId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MyMenu80(int picId, String name) {
		super();
		this.picId = picId;
		this.name = name;
	}
	public MyMenu80() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "MyMenu80 [picId=" + picId + ", name=" + name + "]";
	}
	
}
