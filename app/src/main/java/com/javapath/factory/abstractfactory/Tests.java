package com.javapath.factory.abstractfactory;

import com.javapath.factory.basic.Sender;

import org.junit.Test;

/** 抽象工厂
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/28 16:20 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class Tests {
    @Test
    public void test(){
        Provider provider=new SendMailFactory();
        Sender sender = provider.produce();
        sender.sender();
    }
}
