package com.javapath.factory.singletontest;

import org.junit.Test;

/**
 * 单例模式
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/28 16:57 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class TestSingleton {

    @Test
    public void testSingleton() {
        MySingletonFactory.getInstance();
    }
    
}
