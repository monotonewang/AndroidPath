package com.javapath.factory.basic;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/28 15:15 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class MailSender implements Sender {
    @Override
    public void sender() {
        System.out.println("this is MailSender");
    }
}
