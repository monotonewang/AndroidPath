package com.javapath.list;

/**
 * Created by ubuntu on 17-9-26.
 */

public class Student {

    int age;
    String name;
    String address;

    public Student(int age, String name, String address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }


    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
