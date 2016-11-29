package com.androidpath.architecture.mvp.model;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/29 14:55 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public interface ILoginModel {
    //登陆方法，通过该方法向服务器发送登陆请求。
    void login(String name, String password);
}
