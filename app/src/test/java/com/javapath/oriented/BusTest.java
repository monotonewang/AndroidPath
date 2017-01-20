package com.javapath.oriented;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2017/1/20 11:38 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */
public class BusTest {
    @org.junit.Test
    public void test() {
        int height=0;
        //        Car car=new Car("baoma");//和子类无光
//        Bus bus=new Bus("baoma");//和父类无关
//        Car car = new Bus("baoma");//向上转型
        Bus bus= (Bus) new Car("baoma");//类型转换错误

//         height = car.getHeight();//对象向上转型的好处是可以调用父类的方法......
        String name = bus.getName();
        System.out.println(name + "height=" + height);
    }
}