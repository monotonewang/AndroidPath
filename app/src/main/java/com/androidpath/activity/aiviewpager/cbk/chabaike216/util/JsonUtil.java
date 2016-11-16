package com.androidpath.activity.aiviewpager.cbk.chabaike216.util;


import com.androidpath.activity.aiviewpager.cbk.chabaike216.model.NewsEntity;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;


public class JsonUtil {

	public static List<NewsEntity> getNewsByJSON(String json){
		try {
			JSONObject jsonObject = new JSONObject(json);
			String state = jsonObject.getString("status");
			if(state.equals("ok")){
				jsonObject = jsonObject.getJSONObject("paramz");
				JSONArray jsonArray = jsonObject.getJSONArray("feeds");
				
				TypeToken<List<NewsEntity>> tt = new TypeToken<List<NewsEntity>>(){};
				return new Gson().fromJson(jsonArray.toString(), tt.getType());
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
