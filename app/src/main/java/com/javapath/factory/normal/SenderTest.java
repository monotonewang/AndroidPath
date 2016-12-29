package com.javapath.factory.normal;

import com.javapath.factory.basic.Sender;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/28 15:18 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class SenderTest {
    /**
     * 普通工厂的案例
     *
     * @param args 参数
     */
    public static void main(String args[]) {
        SendFactory sendFactory = new SendFactory();
        Sender mail = sendFactory.produce("mail");
        mail.sender();

        //thought 2
//        SendFactory sendFactory = new SendFactory("mail");
//        Sender mail = sendFactory.produce();
//        mail.sender();
    }
}
