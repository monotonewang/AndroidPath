package com.javapath.factory.normal;

import com.javapath.factory.basic.MailSender;
import com.javapath.factory.basic.Sender;
import com.javapath.factory.basic.SmsSender;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/28 15:17 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class SendFactory {


    public Sender produce(String type) {
        if (type.equals("mail")) {
            return new MailSender();
        } else if (type.equals("sms")) {
            return new SmsSender();
        } else {
            System.out.println("please input right type");
            return null;
        }
    }


    //thought 2
    //    private String type;
//
//    public SendFactory(String type) {
//        this.type = type;
//    }
//
//    public Sender produce() {
//        if (type.equals("mail")) {
//            return new MailSender();
//        } else if (type.equals("sms")) {
//            return new SmsSender();
//        } else {
//            System.out.println("please input right type");
//            return null;
//        }
//    }
}
