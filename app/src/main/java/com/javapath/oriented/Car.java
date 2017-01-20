package com.javapath.oriented;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2017/1/20 11:17 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class Car {
    private String name;

    public Car(String name) {
        this.name = name;
        System.out.println("car gouzhao");
    }

    public String getName() {
        System.out.println("car getName");
        return name;
    }

    int getHeight(){
        return 1;
    }
}
