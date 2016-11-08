package com.androidpath.broadcast.localboradcastOne232;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;

public class MyFragment extends Fragment implements OnClickListener {

	private LocalBroadcastManager localBroadcastManager;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		localBroadcastManager = LocalBroadcastManager.getInstance(getActivity());
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Button button = new Button(getActivity());
		button.setText("发送本地广播");
		button.setOnClickListener(this);
		LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		button.setLayoutParams(layoutParams);
		return button;
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent();
		intent.setAction("action.intent.abcd");
		localBroadcastManager.sendBroadcast(intent);
	}
}
