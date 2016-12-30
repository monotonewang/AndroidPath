package com.javapath.factory.builder;

import com.javapath.factory.basic.MailSender;
import com.javapath.factory.basic.Sender;
import com.javapath.factory.basic.SmsSender;

import java.util.ArrayList;
import java.util.List;

/**
 * deso: AndroidPath 建造者模式--用来创建复合对象，所谓复合对象就是指某个类具有不同的属性<br/>
 * time: 2016/12/30 10:27 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class Builder {

    private List<Sender> list = new ArrayList<>();

    public List<Sender> produceMailSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
        return list;
    }

    public List<Sender> produceSmsSender(int count) {
        for (int i = 0; i < count; i++) {
            list.add(new SmsSender());
        }
        return list;
    }

}
