package com.javapath.oriented;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2017/1/19 17:36 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */
public class PersonTest {
    /**
     * 关于类里面的属性问题。
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        Person person=new Person("zhangsan",1);
        System.out.println("person.name="+person.getName()+"age"+person.getAge());
        Person person1=person;
        person1.setName("lisi");
        person1.setAge(1);
        System.out.println("person1.name="+person1.getName()+"age"+person1.getAge());
        System.out.println("person.name="+person.getName()+"age"+person.getAge());
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void test(){
        Person person=new Person("zhangsan",1);
        System.out.println("person.name="+person.getName()+"age"+person.getAge());
        Person person1=person;
        person1.name="lisi";
        person1.age=1;
        System.out.println("person1.name="+person1.getName()+"age"+person1.getAge());
        System.out.println("person.name="+person.getName()+"age"+person.getAge());
    }
}