package com.javapath.factory.adapter.objectadapter;

import com.javapath.factory.adapter.classadpater.Source;
import com.javapath.factory.adapter.classadpater.Targetable;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/30 14:04 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class Wrapper implements Targetable {
    private Source source;

    public Wrapper(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void fun1() {
        System.out.println();
    }

    @Override
    public void fun2() {

    }
}
