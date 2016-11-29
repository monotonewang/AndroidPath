package com.androidpath.architecture.mvp.model;

import android.os.Handler;

import com.androidpath.architecture.mvp.presenter.ILoginPresenter;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/29 14:56 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class LoginModelImpl implements ILoginModel {

    private ILoginPresenter iLoginPresenter;
    public LoginModelImpl(ILoginPresenter iLoginPresenter){
        this.iLoginPresenter=iLoginPresenter;
    }
    @Override
    public void login(final String name, final String password) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(name.equals("admin")&&password.equals("admin")){
                    iLoginPresenter.loginSuccend();
                }else{
                    iLoginPresenter.loginFailed();
                }
            }
        }, 2000);
    }



//    @Override
//    public void login(final String name, final String password, final OnLoginFinishedListener listener) {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                boolean error=false;
//                if(TextUtils.isEmpty(name)){
//                    listener.onUserNameError();
//                    error=true;
//                }
//                if(TextUtils.isEmpty(password)){
//                    listener.onUserNameError();
//                    error=true;
//                }
//                if(!error){
//                    listener.onSuccess();
//                }
//            }
//        },2000);
//    }
}
