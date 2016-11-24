package com.demo.java.Observer;

/**
 * Created by 7 on 2016/11/24.
 */
//保镖
public class Security implements Watcher {
    @Override
    public void update() {
        System.out.println("运输车有行动，保安贴身保护");
    }
}
