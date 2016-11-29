package com.androidpath.architecture.mvp.view;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/29 14:56 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public interface ILoginView {
    void showLogin();
    void hideLogin();
    String getUsername();
    String getPassword();
    void clearEditText();
    void showFailedToast();
    void showSuccessToast();
}
