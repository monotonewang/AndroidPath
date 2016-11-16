package com.androidpath.activity.agstorge.contentobserver160;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsManager;
import android.util.Log;

import com.androidpath.R;

public class MainActivity160 extends Activity {
	Uri smsUri = Telephony.Sms.CONTENT_URI;  //包括所有的信息："content://sms"
	Uri inboxUri = Telephony.Sms.Inbox.CONTENT_URI;//收件箱："content://mms/inbox"
	Uri outboxUri = Telephony.Sms.Outbox.CONTENT_URI;//发件箱：
	private ContentResolver resolver;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main160);
		resolver = getContentResolver();
		//查询系统短信
//		querySms();
		
		ContentObserver observer = new ContentObserver(null) {
			@Override
			public void onChange(boolean selfChange) {
				//读出收件箱中的短信(不成功：因为)，得到发件人的地址，
				//读整个短信息表，通过判断第一条是不是收件箱的信息，来确定现在是收到信息还是发出信息
				Cursor cursor = resolver.query(smsUri, null, null, null, null);
				cursor.moveToFirst();
				String address = cursor.getString(cursor.getColumnIndex(Telephony.Sms.ADDRESS));
				int type = cursor.getInt(cursor.getColumnIndex("type"));
				Log.e("address ", address);
				if (type==1 && address.endsWith("556")) {
					//回复一条信息
					SmsManager smsManager = SmsManager.getDefault();
					
//					smsManager.sendTextMessage(destinationAddress, scAddress, text, sentIntent, deliveryIntent)
					smsManager.sendTextMessage(address, null, "i hate you, you can go die", null, null);
				}
			}
		};
		
		
		//监听短信收件箱(不成功)，如果有新短信，就检查是不要拦截的号码
		//监听整个短信数据表（成功），注意：收信息的时候会回调，发信息的时候也会回调观察者的onChange方法
		resolver.registerContentObserver(smsUri, true, observer );
		
	}

	private void querySms() {
		Cursor cursor = resolver.query(inboxUri, null, null, null, null);
		
		cursor.moveToFirst();
		while (true) {
			String address = cursor.getString(cursor.getColumnIndex(Telephony.Sms.ADDRESS));
			String body = cursor.getString(cursor.getColumnIndex(Telephony.Sms.BODY));
			Log.e("收件箱：", address+":"+body);
			if (!cursor.moveToNext()) {
				break;
			}
		}
		
	}
}
