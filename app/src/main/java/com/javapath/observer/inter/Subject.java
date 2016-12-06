package com.javapath.observer.inter;


/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/24 15:51 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

/**
 * 主题（发布者、被观察者）
 */
public interface Subject {

    /**
     * 注册观察者
     */
    void registerObserver(Observer observer);

    /**
     * 移除观察者
     */
    void removeObserver(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObservers();
}
