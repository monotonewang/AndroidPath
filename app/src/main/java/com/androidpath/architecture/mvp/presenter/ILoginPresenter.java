package com.androidpath.architecture.mvp.presenter;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/29 14:56 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public interface ILoginPresenter {

    void loginToServer();
    //当登陆事件完成时（成功/失败），Model层要通知该方法登陆事件已完成。
    void loginSuccend();
    void loginFailed();
    void clearText();
}
