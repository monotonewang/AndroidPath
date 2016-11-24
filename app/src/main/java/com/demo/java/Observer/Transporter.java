package com.demo.java.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 7 on 2016/11/24.
 */
//具体的被观察者
public class Transporter implements Watched {
    private List<Watcher> list = new ArrayList<Watcher>();
    @Override
    public void addWatcher(Watcher watcher) {
        list.add(watcher);
    }

    @Override
    public void removeWatcher(Watcher watcher) {
        list.add(watcher);
    }

    @Override
    public void notifyWatcher() {
        for (Watcher watcher : list)
        {
            watcher.update();
        }
    }
}
