package com.androidpath.activity.ajbroadcast.staticdymic230;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver2 extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		if(intent.getAction().equals("android.action.intent.myself")){
			Log.d("print", "----->接收到自定义广播");
		} else {
	//		Log.d("print", "----->接收到开机广播！！！！");
			Intent inte = new Intent(context, MainActivity230.class);
			context.startActivity(inte);
		}
	}

}
