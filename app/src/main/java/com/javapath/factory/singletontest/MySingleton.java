package com.javapath.factory.singletontest;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/28 16:32 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */
public class MySingleton {
    private static MySingleton ourInstance = null;

    //这里 synchroized 防止多线程环境出错
    public static synchronized MySingleton getInstance() {
        if (ourInstance == null) {
            synchronized (ourInstance) {
                ourInstance = new MySingleton();
            }
        }
        return ourInstance;
    }

    MySingleton() {
        System.out.println("my instance");
    }
}
