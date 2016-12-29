package com.javapath.factory.abstractfactory;

import com.javapath.factory.basic.MailSender;
import com.javapath.factory.basic.Sender;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/28 16:18 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class SendMailFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
