package com.javapath.factory.abstractfactory;

import com.javapath.factory.basic.Sender;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/28 16:19 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public interface Provider {
     Sender produce();
}
