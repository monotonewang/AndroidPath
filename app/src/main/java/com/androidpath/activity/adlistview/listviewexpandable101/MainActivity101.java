package com.androidpath.activity.adlistview.listviewexpandable101;

import android.app.Activity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import com.androidpath.R;

public class MainActivity101 extends Activity {

	private String provinces[];
	private String cities[][];

	public class MyBaseExpandableListAdapter extends BaseExpandableListAdapter {

		// 获得组item的个数
		@Override
		public int getGroupCount() {
			// TODO Auto-generated method stub
			return provinces.length;
		}

		// 得到指定组的子视图个数
		@Override
		public int getChildrenCount(int groupPosition) {
			// TODO Auto-generated method stub
			return cities[groupPosition].length;
		}

		@Override
		public Object getGroup(int groupPosition) {
			// TODO Auto-generated method stub
			return provinces[groupPosition];
		}

		@Override
		public Object getChild(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return cities[groupPosition][childPosition];
		}

		@Override
		public long getGroupId(int groupPosition) {
			// TODO Auto-generated method stub
			return groupPosition;
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return childPosition;
		}

		@Override
		public boolean hasStableIds() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			LinearLayout layout = null;
			if (convertView == null) {
				layout = new LinearLayout(MainActivity101.this);
				layout.setOrientation(LinearLayout.HORIZONTAL);
				TextView textView = new TextView(MainActivity101.this);
				textView.setText(provinces[groupPosition]);
				textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
				textView.setPadding(50, 0, 0, 0);
				layout.addView(textView);
				convertView = layout;
			} else {
				layout = (LinearLayout) convertView;
			}

			return layout;
		}

		@Override
		public View getChildView(int groupPosition, int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			LinearLayout layout = new LinearLayout(MainActivity101.this);
			layout.setOrientation(LinearLayout.HORIZONTAL);

			TextView textView = new TextView(MainActivity101.this);
			textView.setText(cities[groupPosition][childPosition]);
			textView.setPadding(80, 0, 0, 0);
			layout.addView(textView);

			return layout;
		}

		// 设置子item是否可以点击，true就是可以点击
		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return true;
		}

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main101);

		ExpandableListView expandableListView = (ExpandableListView) findViewById(R.id.expandablelist);

		provinces = new String[] { "广东省", "江西省", "湖南省", "福建省" };

		cities = new String[][] { { "深圳市", "广州市", "东莞市", "惠州市", "香港市" },
				{ "南昌市", "九江市", "赣州市", "上饶市" },
				{ "长沙市", "岳阳市", "邵阳市", "湘西自治州", "怀化市" },
				{ "厦门市", "福州市", "泉州市", "南平市", "金门市" } };

		BaseExpandableListAdapter adapter = new MyBaseExpandableListAdapter();
		expandableListView.setAdapter(adapter);

		SimpleExpandableListAdapter adapter2;
	}
}
