package com.javapath.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2017/1/5 15:39 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class TestList {
    /**
     * 合并两个list
     */
    @Test
    public void tests(){
        List<String> a=new ArrayList<>();
        a.add("hello");
        List<String> a1=new ArrayList<>();
        a1.add("hello1");

        a.addAll(a1);
        for(String ax: a){
            System.out.println(ax);
        }
    }
}
