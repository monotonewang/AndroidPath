package com.javapath.oriented;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2017/1/19 17:34 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
