package com.androidpath.activity.affragment.dialogframgment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;

import com.androidpath.R;

public class MainActivity120 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main120);
    }

    public void clickAlertDialog(View view) {
        new AlertDialog.Builder(this)
                .setTitle("对话框")
                .setMessage("正文")
                .setIcon(R.drawable.ic_launcher)
                .setPositiveButton("确定", new OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        dialog.dismiss();
                    }
                })
                .show();
    }

    public void clickFragmentDialog(View view) {
        //显示对话框

        MyDialog myDialog = new MyDialog();

        myDialog.show(getFragmentManager(), "tag");


    }
}
