package com.javapath.factory.adapter.classadpater;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/30 11:49 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class AdapterTest {

    public static void main(String[] args){
        Targetable targetable=new Adapter();
        targetable.fun1();
        targetable.fun2();
    }
}
