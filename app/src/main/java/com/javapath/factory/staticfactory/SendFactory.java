package com.javapath.factory.staticfactory;

import com.javapath.factory.basic.MailSender;
import com.javapath.factory.basic.SmsSender;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/28 15:37 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class SendFactory {
    public static MailSender sendMail() {
        return new MailSender();
    }

    public static SmsSender sendSms() {
        return new SmsSender();
    }
}
