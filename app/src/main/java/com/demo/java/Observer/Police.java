package com.demo.java.Observer;

/**
 * Created by 7 on 2016/11/24.
 */
public class Police implements Watcher {
    @Override
    public void update() {
        System.out.println("运输车有行动，警察护航");
    }
}
