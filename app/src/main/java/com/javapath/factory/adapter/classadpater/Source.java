package com.javapath.factory.adapter.classadpater;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/30 11:46 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */
//http://blog.csdn.net/zhangerqing/article/details/8239539
//类的适配器模式：适配器模式将某个类的接口转换成客户端期望的另一个接口表示，目的是消除由于接口不匹配所造成的类的兼容性问题
public class Source {
    public void fun1(){
        System.out.println("this is original method");
    }
}
