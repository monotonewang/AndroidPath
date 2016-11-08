package com.androidpath.view.listview.baseadapter80.adapter;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.view.listview.baseadapter80.bean.MyMenu80;

import java.util.List;

//定义如何将数据源集合中的数据匹配成子视图对象
public class MyBaseAdapter80 extends BaseAdapter {

	private List<MyMenu80> list;
	private Context context;

	//自定义的构造方法，为了接收数据集合
	public MyBaseAdapter80(Context context, List<MyMenu80> list) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.list = list;
	}

	//回调方法，系统在绘制adapterview的时候首先回调该方法
	//计算总共要绘制的item的个数，如果返回0，就不绘制
	//如果返回1，就绘制一个item
	//所以，一般就是数据有多少条就返回多少
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	
	//返回指定位置上的数据对象
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	//子视图的view对象的id号，一般就把item所处的位置作为id
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	
	//系统通过回调这个getView方法来绘制每一个item的视图，getCount返回多少，getview就绘制多少个item的视图
	//返回值就是绘制好的子视图对象
	
	//参数一：是正在绘制的item的位置
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		//实例化item_layout,获得其中的view控件，给View控件设置数据
		View view = View.inflate(context,//上下文
				R.layout.item_layout80,//要实例化的布局的id
				null);//一般填空
		
		
		//从子视图对象中找到UI控件
		ImageView itemImageView = (ImageView) view.findViewById(R.id.item_image);
		itemImageView.setImageResource(list.get(position).getPicId());
		
		TextView itemTextView = (TextView) view.findViewById(R.id.item_text);
		itemTextView.setText(list.get(position).getName());
		
		return view;
	}

}
