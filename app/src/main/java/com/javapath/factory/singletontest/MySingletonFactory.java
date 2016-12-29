package com.javapath.factory.singletontest;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/28 16:50 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

class MySingletonFactory {

    private static MySingleton instance = new MySingleton();

    public static MySingleton getInstance() {
        return MySingletonFactory.instance;
    }
}
