package com.androidpath.activity.akservice.mediaservice246.util;

public interface Constants {

	interface ACTION{
		/**
		 * 
		 */
		String MUSIC_LIST = "android.action.intent.musics";
		
		/**
		 * 
		 */
		String NOTIFICATION_PLAY = "android.action.intent.notification.play";
		
		/**
		 * 通知播放上一曲的action
		 */
		String NOTIFICATION_ABOVE = "android.action.intent.notification.above";
		
		/**
		 * 通知播放下一曲的action
		 */
		String NOTIFICATION_NEXT = "android.action.intent.notification.next";
	}
	
	
	interface KEY{
		/**
		 * 
		 */
		String MUSIC_LIST_KEY = "musics";
		
		/**
		 * 
		 */
		String PLAY_MUSIC_POSITION = "playindex";
	}
	
	interface ID{
		/**
		 * 
		 */
		int NOTIFICATION_ID = 0x11;
	}
	
}
