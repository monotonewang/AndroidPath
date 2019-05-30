package com.androidpath.activity.ajbroadcast.localboradcastTwo233;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;


public class TextFragment extends Fragment {
	
	private LocalBroadcastManager localBroadcastManager;
	private TextView tv;
	private int count;
	private MyReceiver myReceiver;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		localBroadcastManager = LocalBroadcastManager.getInstance(getActivity());
		myReceiver = new MyReceiver();
		IntentFilter intentFilter = new IntentFilter();
		intentFilter.addAction("action.intent.abcd");
		localBroadcastManager.registerReceiver(myReceiver, intentFilter);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		tv = new TextView(getActivity());
		LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		tv.setText("默认的内容");
		tv.setLayoutParams(layoutParams);
		return tv;
	}
	
	class MyReceiver extends BroadcastReceiver{
		@Override
		public void onReceive(Context arg0, Intent arg1) {
			tv.setText("修改后的内容" + ++count);
		}
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if(myReceiver != null){
			localBroadcastManager.unregisterReceiver(myReceiver);
		}
	}
}
