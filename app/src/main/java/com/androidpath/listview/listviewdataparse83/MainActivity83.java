package com.androidpath.listview.listviewdataparse83;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.listview.listviewdataparse83.bean.Weather;
import com.androidpath.listview.listviewdataparse83.util.MyHttpUtil;
import com.androidpath.listview.listviewdataparse83.util.MyJsonParser;

import java.util.ArrayList;
import java.util.List;

public class MainActivity83 extends Activity {

	public class MyAsyncTask extends AsyncTask<Void, Void, List<Weather>> {

		@Override
		protected List<Weather> doInBackground(Void... params) {
			// TODO Auto-generated method stub
			//下载数据，
			String url = "http://wthrcdn.etouch.cn/weather_mini?city=%E5%8C%97%E4%BA%AC";
			//调用自定义的工具类进行数据下载
			String jsonString = MyHttpUtil.downLoadString(url);
			Log.e("jsonstring", jsonString);
			
			//进行解析:调用自定义的工具类进行数据解析
			List<Weather> list = MyJsonParser.parseWeather(jsonString);
			
			return list;
		}
		
		
		@Override
		protected void onPostExecute(List<Weather> result) {
			// TODO Auto-generated method stub
			
			//展示结果
			list.addAll(result);
			adapter.notifyDataSetChanged();
			
			
			super.onPostExecute(result);
		}

	}

	public class MyBaseAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return list.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return list.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			View view = getLayoutInflater().inflate(R.layout.item_layout83, null);
			
			TextView fxTextView = (TextView) view.findViewById(R.id.fx_textView);
			fxTextView.setText(list.get(position).getFengxiang());
			
			TextView flTextView = (TextView) view.findViewById(R.id.fl_textView);
			flTextView.setText(list.get(position).getFengli());
			
			TextView highTextView = (TextView) view.findViewById(R.id.high_textView);
			highTextView.setText(list.get(position).getHigh());
			
			TextView dateTextView = (TextView) view.findViewById(R.id.date_textView);
			dateTextView.setText(list.get(position).getDate());
			
			TextView lowTextView = (TextView) view.findViewById(R.id.low_textView);
			lowTextView.setText(list.get(position).getLow());
			
			TextView typeTextView = (TextView) view.findViewById(R.id.type_textView);
			typeTextView.setText(list.get(position).getType());
			
			
			return view;
		}

	}

	private ListView listView;
	private List<Weather> list;
	private BaseAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main83);
		
		listView = (ListView) findViewById(R.id.listview);
		list = new ArrayList<>();
		
		//开启异步任务，开始下载数据，进行解析，
		MyAsyncTask task = new MyAsyncTask();
		task.execute();
		
		
		adapter = new MyBaseAdapter();
		
		listView.setAdapter(adapter);
	}
}
