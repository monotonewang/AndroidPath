package com.javapath.oriented;

import org.junit.Test;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/30 14:32 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */
//1-公开给其他类使用 2-类声明 3-类名称
public class MyFirstApp {
    //1-公开给其他类使用 2-声明为静态方法 3-返回值为空 4-方法名 5-传入String数组
    public static void main(String[] args) {
        System.out.println("I Rule");
    }

    @Test
    public void loopy(){
        int x=1;
        System.out.println("before loop");
        while(x<4){
            System.out.println("in the loop");
            System.out.println("value="+x);
            x=x+1;
        }
        System.out.println("after loop");
    }
}
