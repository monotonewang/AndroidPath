package com.javapath.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ubuntu on 17-9-26.
 */

public class ListContainTest {

    /**
     * 测试对象list的Contains
     */
    @Test
    public void testListContain() {
        List<Student> studentList = new ArrayList<>();
        Student student = new Student(1, "1", "beijing");
        Student student1 = new Student(1, "1", "hangzhou");
        Student student2 = new Student(1, "1", "nanjing");
        Student student3 = new Student(1, "1", "shanghai");
        studentList.add(student);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);

        String a = "Student student3=new Student(1,\"1\",\"shanghai\");";
        Student student4 = new Student(1, "1", "shanghai");


        boolean contains = studentList.contains(student3);
        System.out.println("contains" + contains);
    }

    /**
     * 测试字符串list的Contains
     */
    @Test
    public void testListStringContain() {
        List<String> stringList = new ArrayList<>();

        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");

        String a = "Student student3=new Student(1,\"1\",\"shanghai\");";


        boolean contains = stringList.contains("6");
        System.out.println("contains" + contains);
    }
}
