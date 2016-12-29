package com.javapath.staticvar;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/28 15:59 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class StaticVarTest {
    static int t;//实例变量

    public static void main(String args[]) {
        System.out.println(t);
        //局部变量必须初始化：因为编译器认为局部变量大多数是用来计算使用的，所有为了防止出现空的情况，所以要求必须初始化。
        int t = 1;//局部变量

        System.out.println(t);
        StaticVarTest staticVarTest = new StaticVarTest();
        System.out.println(staticVarTest.t);
    }
}


