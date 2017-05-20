package com.androidpath.library.rxjava;

import org.junit.Test;

import io.reactivex.Flowable;

/**
 * Created by WangHome on 2017/5/20.
 */

public class RxJavaTest20170520 {

    @Test
    public void test(){
        Flowable.just("Hello world").subscribe(System.out::println);
    }

}
