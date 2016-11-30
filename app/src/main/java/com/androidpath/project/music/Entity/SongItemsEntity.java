package com.androidpath.project.music.Entity;


public class SongItemsEntity {
	private String songid;
	private String title;
	private String artist;
	private String thumb;
	public SongItemsEntity(String songid, String title, String artist, String thumb) {
		super();
		this.songid = songid;
		this.title = title;
		this.artist = artist;
		this.thumb = thumb;
	}
	@Override
	public String toString() {
		return "SongItemsEntity [songid=" + songid + ", title=" + title
				+ ", artist=" + artist + ", thumb=" + thumb + "]";
	}
	public String getSongid() {
		return songid;
	}
	public void setSongid(String songid) {
		this.songid = songid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getThumb() {
		return thumb;
	}
	public void setThumb(String thumb) {
		this.thumb = thumb;
	}
}
