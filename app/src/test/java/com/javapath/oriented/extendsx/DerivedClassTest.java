package com.javapath.oriented.extendsx;

import org.junit.Test;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2017/1/20 17:40 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */
public class DerivedClassTest {
    @Test
    public void print() throws Exception {
        //无论print是通过派生类调用还是通过基类调动，都是最派生类中的方法被调用，
        //当通过基类调用时，调用被沿着继承层次向上传递
        DerivedClass derivedClass=new DerivedClass();
        BaseClass baseClass=derivedClass;
        derivedClass.print();
        baseClass.print();
    }

}