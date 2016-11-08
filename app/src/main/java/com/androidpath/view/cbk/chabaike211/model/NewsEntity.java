package com.androidpath.view.cbk.chabaike211.model;

/**
 * 新闻的实体类
 * @author Ken
 *
 */
public class NewsEntity {
	private int id;
	private Desc data;
	
	public static class Desc{
		private String subject;
		private String summary;
		private String cover;
		private String changed;
		
		public String getSubject() {
			return subject;
		}
		public void setSubject(String subject) {
			this.subject = subject;
		}
		public String getSummary() {
			return summary;
		}
		public void setSummary(String summary) {
			this.summary = summary;
		}
		public String getCover() {
			return "http://litchiapi.jstv.com" + cover;
		}
		public void setCover(String cover) {
			this.cover = cover;
		}
		public String getChanged() {
			return changed;
		}
		public void setChanged(String changed) {
			this.changed = changed;
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Desc getData() {
		return data;
	}

	public void setData(Desc data) {
		this.data = data;
	}
	
}
