package com.androidpath.listview.gradview102;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.listview.gradview102.adapter.MyBaseAdapter;
import com.androidpath.listview.gradview102.bean.Person;

import java.util.List;

public class PersonAdapter extends MyBaseAdapter<Person> {

	private Context context;

	public PersonAdapter(Context context, List<Person> list) {
		super(list);
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			viewHolder = new ViewHolder();
			convertView = View.inflate(context, R.layout.item_layout102, null);
			TextView itemTextView = (TextView) convertView.findViewById(R.id.item_text);
			ImageView itemImageView = (ImageView) convertView.findViewById(R.id.item_image);
			
			viewHolder.itemImageView = itemImageView;
			viewHolder.itemTextView = itemTextView;
			
			convertView.setTag(viewHolder);
		}else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		viewHolder.itemImageView.setImageResource(list.get(position).getImageId());
		viewHolder.itemTextView.setText(list.get(position).getName());
		
		return convertView;
	}
	
	private class ViewHolder{
		TextView itemTextView;
		ImageView itemImageView;
	}

}
