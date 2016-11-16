package com.androidpath.activity.ajbroadcast.serverclient234.server;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiverPermssion extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("print", "---->接收到带权限的广播");
	}

}
