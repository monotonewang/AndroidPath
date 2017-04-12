package com.javapath.oriented;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 在此写用途
 *
 * @author monotone
 * @version V1.0 <描述当前版本功能>
 * @value com.javapath.oriented.HashMapTest.java
 * @link
 * @since 2017-03-03 16:38:38
 */
public class HashMapTest {

    @org.junit.Test
    public void tests() {
        int k = 10;
        HashMap<Integer, Boolean> isSelected = new HashMap<>();
        for (int j = 0; j < 100; j++) {
            isSelected.put(0, false);
        }

        Iterator<Integer> iterator = isSelected.keySet().iterator();
        while (iterator.hasNext()) {
            for (int i = 0; i < isSelected.size(); i++) {
                isSelected.put(i, false);
                isSelected.put(k, true);
            }
        }

        System.out.println("通过Map.keySet遍历key和value：");
        for (Integer key : isSelected.keySet()) {
            System.out.println("key= "+ key + " and value= " + isSelected.get(key));
        }
    }
}
