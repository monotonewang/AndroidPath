package com.androidpath.activity.acasync.networkconn;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;
import com.androidpath.util.NetWorkUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/19 10:10 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class NetWorkConn20161219 extends BaseActivity {
    @BindView(R.id.tv_networkconn)
    AppCompatTextView tvNetworkconn;
    @BindView(R.id.tv_result)
    AppCompatTextView tvResult;
    private boolean isConnected;
    private String TAG = "HTTPAsyncTask";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_networkconn);
        ButterKnife.bind(this);
        isConnected = NetWorkUtils.checkNetworkConnection(this);
        tvNetworkconn.setTextSize(200);
        if (isConnected) {
            tvNetworkconn.setText("connect");
        } else {
            tvNetworkconn.setText("not connected");
        }
    }


    @OnClick({R.id.tv_networkconn, R.id.tv_result})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_networkconn:
                Log.e(TAG, "onClick: "+"onclick" );
                HTTPAsyncTask httpAsyncTask = new HTTPAsyncTask();
                httpAsyncTask.execute(null,null,null);
                httpAsyncTask.setOnDownLoadListener(new HTTPAsyncTask.onDownLoadListener() {
                    @Override
                    public void OnDownLoadComplete(String str) {
                        tvResult.setText(str);
                    }
                });
                break;
            case R.id.tv_result:
                break;
        }
    }


}
