package com.javapath.array;

import org.junit.Test;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/30 16:21 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class Count {

    private String name;

    public Count(String name) {
        this.name = name;
    }

    /**
     * print 1-100
     */
    @Test
    public void testCount() {
        int i = 0;
        while (i < 100) {
            i++;
            System.out.println(i);
        }

    }

    public static void main(String args[]) {
        int i = 10;
        int j = 20;
        int max = getMax(i, j);
        System.out.println("max=" + max);
    }

    static int getMax(int i, int j) {
        return i > j ? i : j;
    }

}
