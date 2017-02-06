package com.javapath.oriented;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2017/1/20 11:39 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class Person {
    public String name;//not recommend
    public int age;

    public Person() {
    }

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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
