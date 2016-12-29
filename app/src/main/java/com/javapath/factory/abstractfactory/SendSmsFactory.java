package com.javapath.factory.abstractfactory;

import com.javapath.factory.basic.Sender;
import com.javapath.factory.basic.SmsSender;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/28 16:20 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class SendSmsFactory implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
