package com.androidpath.project.music.Entity;

import java.io.Serializable;

public class SongLinkEntity implements Serializable {
	private String songId;
	private String songName;
	private String artistName;
	private String albimName;
	private String songPicBig;
	private String songLink;
	
	@Override
	public String toString() {
		return "SongLinkEntity [songId=" + songId + ", songName=" + songName
				+ ", artistName=" + artistName + ", albimName=" + albimName
				+ ", songPicBig=" + songPicBig + ", songLink=" + songLink + "]";
	}
	public SongLinkEntity(String songId, String songName, String artistName,
			String albimName, String songPicBig, String songLink) {
		super();
		this.songId = songId;
		this.songName = songName;
		this.artistName = artistName;
		this.albimName = albimName;
		this.songPicBig = songPicBig;
		this.songLink = songLink;
	}
	public String getSongId() {
		return songId;
	}
	public void setSongId(String songId) {
		this.songId = songId;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getAlbimName() {
		return albimName;
	}
	public void setAlbimName(String albimName) {
		this.albimName = albimName;
	}
	public String getSongPicBig() {
		return songPicBig;
	}
	public void setSongPicBig(String songPicBig) {
		this.songPicBig = songPicBig;
	}
	public String getSongLink() {
		return songLink;
	}
	public void setSongLink(String songLink) {
		this.songLink = songLink;
	}
}
