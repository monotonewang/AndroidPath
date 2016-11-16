package com.androidpath.activity.adlistview.firstlistview.parser;


import com.androidpath.activity.adlistview.firstlistview.bean.MyNews;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MyJsonParser {
	public static List<MyNews> parserNews(String jsonString) {
		// TODO Auto-generated method stub
		List<MyNews> list = new ArrayList<MyNews>();
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			// JSONObject pJsonObject=jsonObject.getJSONObject("paramz");
			JSONArray fjsonArray = jsonObject.getJSONArray("list");
			for (int i = 0; i < fjsonArray.length(); i++) {
				JSONObject dJsonObject = fjsonArray.getJSONObject(i);
				/*
				 * private String title; private String pic_url; private String
				 * now_price; private String origin_price; private String
				 * discount; private String start_dis_count;
				 */
				String title = dJsonObject.getString("title");
				String pic_url = dJsonObject.getString("pic_url");
				String now_price = dJsonObject.getString("now_price");
				String origin_price = dJsonObject.getString("origin_price");
				String discount = dJsonObject.getString("discount");
				String start_discount = dJsonObject.getString("start_discount");
				MyNews news = new MyNews(title, pic_url, now_price,
						origin_price, discount, start_discount);
				list.add(news);
			}
			return list;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
