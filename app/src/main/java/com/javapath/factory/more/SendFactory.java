package com.javapath.factory.more;

import com.javapath.factory.basic.MailSender;
import com.javapath.factory.basic.SmsSender;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/28 15:31 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class SendFactory  {

    public MailSender sendMail() {
        return new MailSender();
    }

    public SmsSender sendSms(){
        return new SmsSender();
    }
}
