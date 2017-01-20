package com.javapath.oriented;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2017/1/20 11:17 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class Bus extends Car {
    private String name;

    public Bus(String name) {
        super(name);
        this.name = name;
        System.out.println("bus gouzhao");
    }

    @Override
    public String getName() {
        System.out.println("bus getName");
        return name;
    }
}
