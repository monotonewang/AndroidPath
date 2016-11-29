package com.androidpath.architecture.mvp.presenter;

import com.androidpath.architecture.mvp.bean.User;
import com.androidpath.architecture.mvp.model.ILoginModel;
import com.androidpath.architecture.mvp.model.LoginModelImpl;
import com.androidpath.architecture.mvp.view.ILoginView;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/29 14:57 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class LoginPresenterImpl implements ILoginPresenter {
    private ILoginModel loginModel;
    private ILoginView loginView;

    public LoginPresenterImpl(ILoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModelImpl(this);
    }


    @Override
    public void loginToServer() {
        String username = loginView.getUsername();
        String password = loginView.getPassword();
        //先展示progress
        loginView.showLogin();
        loginModel.login(username, password);

        User user = new User(username, password);
        loginModel.login2(user);
    }

    @Override
    public void loginSuccend() {
        //登录成功之后关掉progress
        loginView.hideLogin();
        loginView.showSuccessToast();
    }

    @Override
    public void loginFailed() {
        loginView.showFailedToast();
    }

    @Override
    public void clearText() {
        loginView.clearEditText();
    }
}
