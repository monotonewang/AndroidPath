package com.androidpath.listview.baseadapterpack100.bean;

public class Person {
	private String name;
	private int imageId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getImageId() {
		return imageId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public Person(String name, int imageId) {
		super();
		this.name = name;
		this.imageId = imageId;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", imageId=" + imageId + "]";
	}
	
}
