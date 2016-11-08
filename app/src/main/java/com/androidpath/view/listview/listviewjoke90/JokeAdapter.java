package com.androidpath.view.listview.listviewjoke90;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.view.listview.listviewjoke90.bean.Joke;

import java.util.List;

public class JokeAdapter extends BaseAdapter {

	private Context context;
	private List<Joke> list;

	public JokeAdapter(Context context, List<Joke> list) {
		// TODO Auto-generated constructor stub
		this.context = context;
		this.list = list;
		
	}

	@Override
	public int getCount() {
		Log.e("JokeAdapter", "getCount...."+list.size());
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
		ViewHolder viewHolder = null;
		//convertView：如果加载item的时候recycle中没有预先加载，就是null的，需要自己加载布局,将该找的控件找出来存入ViewHolder,在把viewHolder对象存入convertview,以备复用
		//如果recycle中预先加载过了，系统就会把对应的position的子视图对象传回给convertView参数，利用convertView获得控件对象即可而不需要重新实例化布局和找控件
		//通过布局加载器，将子视图对象实例化
		if (convertView == null) {
			convertView = View.inflate(context, R.layout.item_layout90
					, null);
			TextView authorTextView = (TextView) convertView.findViewById(R.id.author_textview);
			TextView contentTextView = (TextView) convertView.findViewById(R.id.content_textview);
			ImageView picImageView = (ImageView) convertView.findViewById(R.id.pic_imageview);
			
			//新建item的时候就要将控件找出来，用ViewHolder保存，
			//还要将viewholder存入convertView
			viewHolder = new ViewHolder(authorTextView, contentTextView, picImageView);
			//将viewholder存入convertView，如果复用的时候convertview会被系统传回，我们利用convertview就可以得到viewholder
			convertView.setTag(viewHolder);
			Log.e("JokeAdapter", "新建 item， getView...."+position);
		}else {
			Log.e("JokeAdapter", "复用 item， getView...."+position);
			//复用item的时候就要从convertView中获得viewholder 
			viewHolder = (ViewHolder) convertView.getTag();
		}
	
		viewHolder.getAuthorTextView().setText(list.get(position).getAuthor());
		viewHolder.getContentTextView().setText(list.get(position).getContent());
		
		String picUrl = list.get(position).getPicUrl();
		//下载picUrl指向的图片，设置给imageView;
		ImageView imageView = viewHolder.getPicImageView();
		//记录当前imagview和picurl的对应关系
		imageView.setTag(picUrl);
		if (!picUrl.equals("")) {
			//开启异步任务下载图片:有可能图片还没下完，当前显示的item就被滑动到看不见的地方，当图片下载完成后就可能会被设置到错误的位置,这就图片错位
			//要考虑处理图片错位，原则就是没有图片的就不用显示imageview 有图片的才显示imageview，并且保证图片不错位
			
			//保证图片不错位：如果下载完图片的时候对应位置的imageview没有被滑走的话，才将图片设置上去，如果划走了就不设置了
			//通过判断当前下载完成的图片是不是该getview方法中正在显示的item的对应的图片
			BitmapAsynTask bitmapTask = new BitmapAsynTask(imageView);
			bitmapTask.execute(picUrl);
		}else {
//			没有图片的就不用显示imageview
			//INVISIBLE: 不显示imageview但要占用布局空间
//			GONE: 不显示imageview并且不用占用布局空间
			imageView.setVisibility(View.GONE);
		}
		
		
		return convertView;
	}
	
	//ViewHolder的作用是将item子视图中个所有控件绑定在一起作为整体操作
	public class ViewHolder{
		private TextView authorTextView;
		private TextView contentTextView;
		private ImageView picImageView ;
		public TextView getAuthorTextView() {
			return authorTextView;
		}
		public void setAuthorTextView(TextView authorTextView) {
			this.authorTextView = authorTextView;
		}
		public TextView getContentTextView() {
			return contentTextView;
		}
		public void setContentTextView(TextView contentTextView) {
			this.contentTextView = contentTextView;
		}
		public ImageView getPicImageView() {
			return picImageView;
		}
		public void setPicImageView(ImageView picImageView) {
			this.picImageView = picImageView;
		}
		public ViewHolder(TextView authorTextView, TextView contentTextView,
				ImageView picImageView) {
			super();
			this.authorTextView = authorTextView;
			this.contentTextView = contentTextView;
			this.picImageView = picImageView;
		}
		public ViewHolder() {
			super();
			// TODO Auto-generated constructor stub
		}
	}

}
