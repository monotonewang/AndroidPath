package com.demo.java.Observer;

/**
 * Created by 7 on 2016/11/24.
 */
//抽象的被观察者，在其中声明方法（添加、移除观察者，通知观察者）：
public interface Watched {
    public void addWatcher(Watcher watcher);
    public void removeWatcher(Watcher watcher);
    public void notifyWatcher();
}
