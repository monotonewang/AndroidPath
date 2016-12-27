package com.androidpath.project.music.parser;

import android.util.Log;

import com.androidpath.project.music.Entity.SongItemsEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


public class JsonParserSongItems {
	public static List<SongItemsEntity> getJSONByString(String json){
		List<SongItemsEntity> list =null;
		if(json!=null){
			try {
				JSONObject jsonObject = new JSONObject(json);
				 JSONObject jsonObject2 = jsonObject.getJSONObject("result");
					JSONArray jsonArray =jsonObject2.getJSONArray("songlist");
				 if(jsonArray==null){
					 Log.e("JsonParserSongItems", "no json Array");
					 return null;
				 }else{
				    TypeToken<List<SongItemsEntity>> tt=new TypeToken<List<SongItemsEntity>>(){};
					list=new Gson().fromJson(jsonArray.toString(), tt.getType());
					return list;
				 }
				
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}else{
			Log.e("JsonParserSongItems", "no json String");
			return null;
		}
		return null;
	}
}
