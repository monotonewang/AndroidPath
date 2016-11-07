package com.androidpath.listview.listviewjoke90.util;

import com.androidpath.listview.listviewjoke90.bean.Joke;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;



public class MyParserUtil {

	public static List<Joke> parseJson(String jsonString) {
		List<Joke> list = new ArrayList<>();
		
		//
		/*{
		    "status": "000000",
		    "desc": null,
		    "detail": [
		        {
		            "id": 37369,
		            "xhid": 37369,
		            "author": "欧巴芭芭拉",
		            "content": "你是什么样的蛋糕",
		            "picUrl": "http://img.appd.lengxiaohua.cn/2016/01/01/182acd7ef7f34_o.jpg",
		            "status": "1"
		        },*/
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			
			JSONArray jsonArray = jsonObject.getJSONArray("detail");
			
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject tempJsonObject = jsonArray.getJSONObject(i);
				
				Joke tempJoke = new Joke();
				tempJoke.setAuthor(tempJsonObject.getString("author"));
				tempJoke.setContent(tempJsonObject.getString("content"));
				tempJoke.setPicUrl(tempJsonObject.getString("picUrl"));
				
				list.add(tempJoke);
			}
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}

}
