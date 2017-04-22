package com.androidpath.activity.adlistview.baseadapterpack100.adapter;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidpath.R;
import com.androidpath.activity.adlistview.baseadapterpack100.bean.Person;

import java.util.List;


public class MyAdapter extends MyBaseAdapter<Person> {

	private Context context;

	public MyAdapter(Context context, List<Person> list) {
		super(list);
		
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder = null;
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.item_layout100, null);
			ImageView itemImageView = (ImageView) convertView.findViewById(R.id.item_image);
			TextView itemTextView = (TextView) convertView.findViewById(R.id.item_text);
			Button itemButton = (Button) convertView.findViewById(R.id.item_button);
			viewHolder = new ViewHolder();
			viewHolder.itemImageView = itemImageView;
			viewHolder.itemTextView = itemTextView;
			viewHolder.itemButton = itemButton;
			
			convertView.setTag(viewHolder);
		}
		viewHolder = (ViewHolder) convertView.getTag();
		
		viewHolder.itemImageView.setImageResource(list.get(position).getImageId());
		viewHolder.itemTextView.setText(list.get(position).getName());
		
		final int index = position;
		viewHolder.itemButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(context, "点击了第"+index+"条的按钮", 0).show();
			}
		});
		
		return convertView;
	}
	
	private class ViewHolder {
		
		ImageView itemImageView;
		TextView itemTextView;
		Button itemButton;
	}

	
	
}
