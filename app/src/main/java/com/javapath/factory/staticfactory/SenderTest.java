package com.javapath.factory.staticfactory;

import com.javapath.factory.basic.MailSender;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/28 15:39 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class SenderTest {

    public static void main(String arg[]) {
        MailSender mailSender = SendFactory.sendMail();
        mailSender.sender();
    }
}
