package com.androidpath.project.music.Entity;

public class PublicListEntity {
	private String name;
	private String thumb;
	private String ch_name;
	@Override
	public String toString() {
		return "PublicListEntity [name=" + name + ", thumb=" + thumb
				+ ", ch_name=" + ch_name + "]";
	}
	public String getCh_name() {
		return ch_name;
	}
	public void setCh_name(String ch_name) {
		this.ch_name = ch_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
}
