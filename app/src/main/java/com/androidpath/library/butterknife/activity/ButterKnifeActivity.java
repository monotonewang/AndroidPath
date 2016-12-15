package com.androidpath.library.butterknife.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/15 15:48 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class ButterKnifeActivity extends BaseActivity {

    @BindView(R.id.etUsername)
    EditText etUsername;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.tvLogin)
    TextView tvLogin;
    private String TAG = "ButterKnifeActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butterknife);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.etUsername, R.id.etPassword, R.id.tvLogin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.etUsername:
                break;
            case R.id.etPassword:
                break;
            case R.id.tvLogin:
                if (etUsername.getText().toString().equals("admin") && etUsername.getText().toString().equals("admin")) {
                    Toast.makeText(this, "login success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "login failed", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
