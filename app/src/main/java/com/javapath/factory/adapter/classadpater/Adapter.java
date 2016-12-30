package com.javapath.factory.adapter.classadpater;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/30 11:48 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class Adapter extends Source implements Targetable {
    @Override
    public void fun2() {
        System.out.println("this is the targetable method");
    }
}
