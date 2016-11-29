package com.androidpath.architecture.mvp.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;
import com.androidpath.architecture.mvp.presenter.LoginPresenterImpl;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/29 14:56 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */
//http://tangpj.com/2016/09/23/mvp-structure-one/  -->juejin
//http://blog.csdn.net/lmj623565791/article/details/46596109  -->csdn
//http://www.jianshu.com/p/4bcf53995fc3   -->jianshu
public class LoginActivity extends BaseActivity implements ILoginView{
    private LoginPresenterImpl loginPresenter;
    private ProgressBar progressBar;
    private EditText username;
    private EditText password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mvp);
        username = (EditText) findViewById(R.id.edit_username);
        password = (EditText) findViewById(R.id.edit_password);
        Button login= (Button) findViewById(R.id.btn_login);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        Button clear = (Button) findViewById(R.id.btn_clear);

        loginPresenter=new LoginPresenterImpl(this);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.clearText();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(loginPresenter==null){
                    Toast.makeText(LoginActivity.this, "null", Toast.LENGTH_SHORT).show();
                }else{
                    loginPresenter.loginToServer();
                }
            }
        });
    }

    @Override
    public void showLogin() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLogin() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public String getUsername() {
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void clearEditText() {
        username.setText("");
        password.setText("");
    }

    @Override
    public void showFailedToast() {
        Toast.makeText(this,"登录失败",Toast.LENGTH_LONG).show();
    }

    @Override
    public void showSuccessToast() {
        Toast.makeText(this,"登录成功",Toast.LENGTH_LONG).show();
    }
}
