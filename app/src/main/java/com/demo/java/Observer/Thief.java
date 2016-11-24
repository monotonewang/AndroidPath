package com.demo.java.Observer;

/**
 * Created by 7 on 2016/11/24.
 */
//强盗
public class Thief implements Watcher {
    @Override
    public void update() {
        System.out.println("运输车有行动，强盗准备动手");
    }
}
