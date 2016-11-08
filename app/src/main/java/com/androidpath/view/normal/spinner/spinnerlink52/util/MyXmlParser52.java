package com.androidpath.view.normal.spinner.spinnerlink52.util;

import android.content.Context;
import android.content.res.XmlResourceParser;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyXmlParser52 {

	public static Map<String, List<String>> parseXml(Context context,
			int xmlResId) {
		// TODO Auto-generated method stub
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		// 1.获得解析器对象，设置解析的源数据来源于指定的资源文件
		XmlResourceParser parser = context.getResources().getXml(xmlResId);

		// 获得解析事件的类型
		try {
			int eventtype = parser.getEventType();
			String provinceName = null;
			List<String > cityList = null;
			// 文档开始，循环开始解析
			if (eventtype == XmlResourceParser.START_DOCUMENT) {
				while (true) {

					if (eventtype == XmlResourceParser.START_TAG) {
						String nodeName = parser.getName();
						// 如果标签名是provice开始，就保存到一个关键字字符串， 同时创建一个list集合，准备保存城市名称
						if (nodeName.equals("province")) {
							provinceName = parser.getAttributeValue(0);
							cityList = new ArrayList<>();
						}

						// 如果标签是city开始，将城市名称放入list集合
						if (nodeName.equals("item")) {
							String cityName = parser.nextText();
							cityList.add(cityName);
						}
					}
					if (eventtype == XmlResourceParser.END_TAG) {
						// 如果标签名是provice结束，就将list和key组成的键值对放入map
						String nodeName = parser.getName();
						if (nodeName.equals("province")) {
							map.put(provinceName, cityList);
						}
					}

					//移动到下一个标签
					eventtype = parser.next();
					// 到文档结束，就退出解析
					if (eventtype == XmlResourceParser.END_DOCUMENT) {
						break;
					}

				}
			}
			

		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return map;
	}

}
