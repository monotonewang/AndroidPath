package com.javapath.factory.more;

import com.javapath.factory.basic.MailSender;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/28 15:34 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class SenderTest {

    public static void main(String args[]) {
        SendFactory sendFactory=new SendFactory();
        MailSender mailSender = sendFactory.sendMail();
        mailSender.sender();
    }
}
