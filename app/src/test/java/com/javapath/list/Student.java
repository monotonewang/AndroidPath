package com.javapath.list;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(address, student.address);
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
