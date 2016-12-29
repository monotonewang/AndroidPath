package com.javapath.stringtest;

import org.junit.Test;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/29 10:24 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class StringTest {

    @Test
    public void fun1(){
        String s = "hello world";
        String s2 = "hello world";
        System.out.println(s == s2);
        System.out.println(s .equals(s2));
    }
}
