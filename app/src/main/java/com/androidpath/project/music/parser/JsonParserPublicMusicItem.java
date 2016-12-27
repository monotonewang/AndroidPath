package com.androidpath.project.music.parser;

import android.util.Log;

import com.androidpath.project.music.Entity.PublicListEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JsonParserPublicMusicItem {
	public static List<PublicListEntity> JSONParser(String json){
		List<PublicListEntity> list =null;
		if(json!=null){
			try {
				JSONObject jsonObject = new JSONObject(json);
				String error_code = jsonObject.getString("error_code");
				if(Integer.parseInt(error_code)==22000){
					JSONArray jsonArray1 = jsonObject.getJSONArray("result");
					JSONObject jsonObject2 = jsonArray1.getJSONObject(0);
					JSONArray jsonArray2 = jsonObject2.getJSONArray("channellist");
					TypeToken<List<PublicListEntity>> tt=new TypeToken<List<PublicListEntity>>(){};
					list= new Gson().fromJson(jsonArray2.toString(),tt.getType());
//					Log.e("FragmentPublicListItem", list.toString());
					return list;
				}else{
					Log.e("FragmentPublicListItem", "errcode id wrong");
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
		}else{
			Log.e("FragmentPublicListItem", "no json String in");
		}
		return null;
	}
}
