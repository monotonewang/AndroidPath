package com.androidpath.library.rxjava.test;

import com.androidpath.library.rxjava.entity.Course;
import com.androidpath.library.rxjava.entity.Student;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * RxJava操作符
 *
 * @author monotone
 * @version V1.0 <描述当前版本功能>
 * @value com.androidpath.library.rxjava.test.RxOperatorTest.java
 * @link
 * @since 2017-05-22 09:49:49
 */
public class RxOperatorTest {

    /**
     * 这里被观察者发送的是Integer
     * 观察者接受的是String
     */
    @Test
    public void rxFun1() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                for (int i = 0; i < 3; i++) {
                    e.onNext(i);
                    System.out.println("e-->" + i);
                }

            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(@NonNull Integer integer) throws Exception {
                return "this is result" + integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                System.out.println("result=" + s);
            }
        });
    }

    @Test
    public void rxFun2() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                for (int i = 0; i < 3; i++) {
                    e.onNext(i);
                    System.out.println("e-->" + i);
                }
                e.onComplete();
            }
        }).filter(new Predicate<Integer>() {
            @Override
            public boolean test(@NonNull Integer integer) throws Exception {
                return integer >= 1;
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(@NonNull Integer integer) throws Exception {
                final List<String> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    list.add("I am value " + integer);
                }
//                return Observable.fromArray(list.get(0));
                return Observable.fromIterable(list);
//                return Observable.fromIterable(list).delay(10, TimeUnit.MILLISECONDS);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                System.out.println("consumer=" + s);
            }
        });
    }


    @Test
    public void rxToList() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                for (int i = 0; i < 3; i++) {
                    e.onNext(i);
                    System.out.println("e-->" + i);
                }
                e.onComplete();
            }
        }).filter(new Predicate<Integer>() {
            @Override
            public boolean test(@NonNull Integer integer) throws Exception {
                return integer >= 1;
            }
        }).toList()
                .subscribe(new Consumer<List<Integer>>() {
            @Override
            public void accept(@NonNull List<Integer> integers) throws Exception {
                for (int i = 0; i < integers.size(); i++) {
                    System.out.println("i=" + integers);
                }
            }
        });


//                flatMap(new Function<Integer, ObservableSource<String>>() {
//            @Override
//            public ObservableSource<String> apply(@NonNull Integer integer) throws Exception {
//                final List<String> list = new ArrayList<>();
//                for (int i = 0; i < 3; i++) {
//                    list.add("I am value " + integer);
//                }
////                return Observable.fromArray(list.get(0));
//                return Observable.fromIterable(list);
////                return Observable.fromIterable(list).delay(10, TimeUnit.MILLISECONDS);
//            }
//        }).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(@NonNull String s) throws Exception {
//                System.out.println("consumer="+s);
//            }
//        });
    }

    /**
     * flatmap
     */
    @Test
    public void rxFun3() {
        List<Student> students = new ArrayList<Student>();
        List<Course> courseList = new ArrayList<Course>();
        for (int i = 0; i < 10; i++) {
            Course course = new Course("a", "a");
            courseList.add(course);
        }
        students.add(new Student("a", courseList));
        System.out.println(students);


        Observable.fromArray(students)
                .flatMap(new Function<List<Student>, ObservableSource<Course>>() {
                    @Override
                    public ObservableSource<Course> apply(@NonNull List<Student> students) throws Exception {
                        return Observable.fromArray(students.get(0).getCourseList().get(0));
                    }
                }).subscribe((Consumer<Course>) course -> System.out.println(course));

    }


}
