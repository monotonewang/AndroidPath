package com.androidpath.listview.listviewjoke90.bean;
/*{
    "id": 37369,
    "xhid": 37369,
    "author": "欧巴芭芭拉",
    "content": "你是什么样的蛋糕",
    "picUrl": "http://img.appd.lengxiaohua.cn/2016/01/01/182acd7ef7f34_o.jpg",
    "status": "1"
},*/
public class Joke {
	private String author,content,picUrl;

	public Joke(String author, String content, String picUrl) {
		super();
		this.author = author;
		this.content = content;
		this.picUrl = picUrl;
	}

	public Joke() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	@Override
	public String toString() {
		return "Joke [author=" + author + ", content=" + content + ", picUrl="
				+ picUrl + "]";
	}
	
}
