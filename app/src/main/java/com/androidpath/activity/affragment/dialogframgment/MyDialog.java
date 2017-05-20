package com.androidpath.activity.affragment.dialogframgment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidpath.R;

public class MyDialog extends DialogFragment {
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Dialog dialog = new AlertDialog.Builder(getActivity())
		.setTitle("这是fragment对话框")
		.setMessage("正文")
		.setIcon(R.drawable.ic_launcher)
		.setPositiveButton("确定", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		}).create();
		
		Log.d("DialogFragment", "onCreateDialog.....");
		return dialog;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		Log.d("DialogFragment", "onCreateView.....");
		return super.onCreateView(inflater, container, savedInstanceState);
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		Log.d("DialogFragment", "onAttach.....");
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("DialogFragment", "onCreate.....");
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		Log.d("DialogFragment", "onActivityCreated.....");
	}

	@Override
	public void onStart() {
		super.onStart();
		Log.d("DialogFragment", "onStart.....");
	}

	@Override
	public void onResume() {
		super.onResume();
		Log.d("DialogFragment", "onResume.....");
	}

	@Override
	public void onPause() {
		super.onPause();
		Log.d("DialogFragment", "onPause.....");
	}

	@Override
	public void onStop() {
		super.onStop();
		Log.d("DialogFragment", "onStop.....");
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		Log.d("DialogFragment", "onDestroyView.....");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d("DialogFragment", "onDestroy.....");
	}
	
	@Override
	public void onDetach() {
		super.onDetach();
		Log.d("DialogFragment", "onDetach.....");
	}
}
