package com.androidpath.library.rxjava.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

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
                for(int i=0;i<3;i++){
                    e.onNext(i);
                    System.out.println("e-->"+i);
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
    public void rxFun2(){
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                for(int i=0;i<3;i++){
                    e.onNext(i);
                    System.out.println("e-->"+i);
                }
                e.onComplete();
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(@NonNull Integer integer) throws Exception {
                final List<String> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    list.add("I am value " + integer);
                }
                return Observable.fromIterable(list).delay(10, TimeUnit.MILLISECONDS);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NonNull String s) throws Exception {
                System.out.println(s);
            }
        });
    }
}
