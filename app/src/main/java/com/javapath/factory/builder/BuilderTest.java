package com.javapath.factory.builder;

import com.javapath.factory.basic.Sender;

import java.util.List;

/**
 *
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/30 10:32 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class BuilderTest {
    public static void main(String args[]) {
        Builder builder = new Builder();
        List<Sender> senders = builder.produceMailSender(10);
        for (int i = 0; i < senders.size(); i++) {
            senders.get(i).sender();
        }
    }
}
