package com.androidpath.controls.spinner.spinnerlink52;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.androidpath.R;
import com.androidpath.controls.spinner.spinnerlink52.util.MyXmlParser52;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity52 extends Activity {

	private List<String> cityList;
	private Map<String, List<String>> map;
	private List<String> provinceList;
	private ArrayAdapter<String> cityAdapter;
	private ArrayAdapter<String> proviceAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main52);
		
	
		
		Spinner provinceSpinner = (Spinner) findViewById(R.id.province_spinner);
		Spinner citySpinner = (Spinner) findViewById(R.id.city_spinner);
		
		//1.获得数据
		map = MyXmlParser52.parseXml(this, R.xml.city52);
		Log.e("activity", map+"");
		
		//从map中获得所有的省份名称，装入list
		Set<String> keyset = map.keySet();
		provinceList = new ArrayList<>();
		cityList = new ArrayList<>();
		
		
		//遍历由省份名称组成的集合，存入到list中
		for (String province : keyset) {
			provinceList.add(province);
		}
		
		proviceAdapter = new ArrayAdapter<>(this, 
				android.R.layout.simple_spinner_item,
				provinceList);
		cityAdapter = new ArrayAdapter<>(this, 
				android.R.layout.simple_spinner_item,
				cityList);
		
		
		//3.先适配省份，从map中获得所有的关键字
		provinceSpinner.setAdapter(proviceAdapter);
		citySpinner.setAdapter(cityAdapter);
		
		//4.根据选择的不同省份，适配城市给城市的spinner
		provinceSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				//清空城市集合中的原有数据
				cityList.clear();
				//将用户选中的省份对应的城市列表加入到城市集合中
				cityList.addAll(map.get(provinceList.get(position)));
				//通知适配器数据源发生变化，要更新视图
				cityAdapter.notifyDataSetChanged();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
