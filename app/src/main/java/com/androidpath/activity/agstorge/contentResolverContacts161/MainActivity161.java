package com.androidpath.activity.agstorge.contentResolverContacts161;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.SimpleAdapter;

import com.androidpath.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity161 extends ListActivity {
	// 1、联系人的Uri==> content://com.android.contacts/contacts （对应contacts 表）
	// content://com.android.contacts/raw_contacts（对应raw_contacts表）
	// 2、电话号码的Uri==>  content://com.android.contacts/data/phones（对应data表）
	// 3、EMAIL的URI==>     content://com.android.contacts/data/emails

	// 对应raw_contacts表的Uri对象 content://com.android.contacts/raw_contacts
	Uri rowContactUri = ContactsContract.RawContacts.CONTENT_URI;
	Uri dataUri = ContactsContract.Data.CONTENT_URI;
	Uri phoneDataUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
	private ContentResolver resolver;
	private SimpleAdapter adapter;
	private List<Map<String, Object>> list;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.activity_main);

		resolver = getContentResolver();

		list = queryContact();

		adapter = new SimpleAdapter(this, list,
				android.R.layout.simple_list_item_2, new String[] {
						"contactName", "phone" }, new int[] {
						android.R.id.text1, android.R.id.text2 });

		setListAdapter(adapter);
		
		
	}

	private List<Map<String, Object>> queryContact() {
		List<Map<String, Object>> list = new ArrayList<>();

		// 查询联系人数据
		// 1.查询rawcontacts表，得到contact_id和display_name
		Cursor rowContactCursor = resolver.query(rowContactUri, new String[] {
				"contact_id", "display_name" }, null, null, null);

		// 2.
		// 遍历rowContactCursor，以contact_id作为查询条件，查询该contact_id所对应的data表(raw_contact_id)中的phones信息
		rowContactCursor.moveToFirst();
		while (true) {

			// 得到联系人姓名
			String contactName = rowContactCursor.getString(rowContactCursor
					.getColumnIndex("display_name"));
			int contactId = rowContactCursor.getInt(rowContactCursor
					.getColumnIndex("contact_id"));

			Map<String, Object> map = new HashMap<>();
			// name存入map对象
			map.put("contactName", contactName);
			Log.e("contactName", contactId + ":" + contactName);

			// id作为查询依据，继续查询data表中的电话号码,将电话号码放入map,
			Cursor phoneCursor = resolver.query(phoneDataUri, // 参数一就是要查询的数据表的Uri
					new String[] { "data1" }, "raw_contact_id=?",// 查询data表中的数据的查询条件：按照id查询
					new String[] { contactId + "" }, null);
			phoneCursor.moveToFirst();
			String phone = "";
			while (true) {
				phone += phoneCursor.getString(phoneCursor
						.getColumnIndex("data1")) + "  ";
				if (!phoneCursor.moveToNext()) {
					break;
				}

			}
			Log.e("phone", phone + "");

			map.put("phone", phone);

			// 将map放入list
			list.add(map);

			// 移动到下一条
			if (!rowContactCursor.moveToNext()) {
				break;
			}
		}
		return list;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub

		menu.add(0, 1, 1, "插入联系人信息");

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getItemId() == 1) {
			View dialogView = getLayoutInflater().inflate(
					R.layout.dialog_layout161, null);
			
			final EditText namEditText = (EditText) dialogView.findViewById(R.id.name_edit);
			final EditText phoneEditText = (EditText) dialogView.findViewById(R.id.phone_edit);
			final EditText emailEditText = (EditText) dialogView.findViewById(R.id.email_edit);
			// 弹出一个对话框，让用户输入联系人信息
			new AlertDialog.Builder(this).setTitle("输入联系人信息")
					.setView(dialogView)
					.setPositiveButton("确认", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							// 获得用户的输入，
							String name = namEditText.getText().toString();
							String phone = phoneEditText.getText().toString();
							String email = emailEditText.getText().toString();

							// 将数据存入系统联系人的数据库
							insertToContactDb(name, phone, email);
						}
					}).show();

		}
		return true;
	}

	protected void insertToContactDb(String name, String phone, String email) {
		// 步骤：1、先往raw_contacts表中添加一条空白的数据，目的是先获取到联系人的id，这个id就是用于data表的raw_contact_id
		ContentValues rawContactValue = new ContentValues();
		Uri rawInsertUri = resolver.insert(rowContactUri, rawContactValue);
		//获取id---contact_id
		long contactId = ContentUris.parseId(rawInsertUri);
		
		Log.e("contactId", contactId+"-----");
		
		
		// 步骤2：往data表中先插入display_name。
		// 当插入成功后就往raw_contacts表的display_name中也添加了相同的联系人姓名。
		ContentValues nameValue = new ContentValues();
		nameValue.put("raw_contact_id", contactId);
		nameValue.put("data1", name);
		nameValue.put("data2", name);
		nameValue.put("mimetype", "vnd.android.cursor.item/name");
		resolver.insert(dataUri, nameValue);
		
		//步骤3.往data表中插入电话号码
		ContentValues phoneValue = new ContentValues();
		phoneValue.put("raw_contact_id", contactId);
		phoneValue.put("data1", phone);
		phoneValue.put("data2", 2);//2代表是移动电话， 1代表是座机
		phoneValue.put("mimetype", "vnd.android.cursor.item/phone_v2");
		resolver.insert(dataUri, phoneValue);
		
		//清空原来的数据
		list.clear();
		list.addAll(queryContact());
		
		//通知数据源发生改变，数据源的内容，要保证数据源list集合是之前的那个对象
		adapter.notifyDataSetChanged();
	}

}
