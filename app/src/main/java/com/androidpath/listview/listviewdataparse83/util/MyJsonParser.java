package com.androidpath.listview.listviewdataparse83.util;

import android.util.Log;

import com.androidpath.listview.listviewdataparse83.bean.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MyJsonParser {

	public static List<Weather> parseWeather(String jsonString) {
		// TODO Auto-generated method stub
		List<Weather> list = new ArrayList<>();
		
		try {
			JSONObject jsonObject = new JSONObject(jsonString);
			
			JSONObject dataJsonObject = jsonObject.getJSONObject("data");
			
			JSONArray forecastJsonArray = dataJsonObject.getJSONArray("forecast");
			
			//遍历json数组
			for (int i = 0; i < forecastJsonArray.length(); i++) {
				JSONObject weathJsonObject = forecastJsonArray.getJSONObject(i);
				 /*"fengxiang": "北风",
	                "fengli": "3-4级",
	                "high": "高温 5℃",
	                "type": "晴",
	                "low": "低温 -6℃",
	                "date": "30日星期三"*/
				String fx = weathJsonObject.getString("fengxiang");
				String fl = weathJsonObject.getString("fengli");
				String high = weathJsonObject.getString("high");
				String low = weathJsonObject.getString("low");
				String type = weathJsonObject.getString("type");
				String date = weathJsonObject.getString("date");
				
				//用解析到的数据创建对象
				Weather weather = new Weather(fx, fl, high, type, low, date);
				//将天气对象放入list
				list.add(weather);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Log.e("list", list.toString());
		return list;
	}

}
