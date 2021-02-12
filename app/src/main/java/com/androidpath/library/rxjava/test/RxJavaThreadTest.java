package com.androidpath.library.rxjava.test;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
//import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by WangHome on 2017/5/20.
 */

public class RxJavaThreadTest {

    /**
     * 线程调度
     * Observable RxNewThread
     * Consumer AndroidMainThread
     */
    public static void rx1() {
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
//                System.out.println("thread subscribe name=" + Thread.currentThread());
//                System.out.println("subscribe" + "e-->1");
//                e.onNext(1);
//            }
//        }).subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Integer>() {
//                    @Override
//                    public void accept(@NonNull Integer integer) throws Exception {
//                        System.out.println("thread accept name=" + Thread.currentThread());
//                        System.out.println("integer" + integer);
//                    }
//                });
    }

    /**
     * RxNewThread
     * RxCachedThread cacheThread就是io线程
     */
    public static void rx2() {
//        Observable.create((ObservableOnSubscribe<Integer>) e -> {
//            for (int i = 0; i < 5; i++) {
//                e.onNext(i);
//                System.out.println("Observable name=" + Thread.currentThread());
//                System.out.println("subscribe" + "e-->1"+i);
//            }
//
//
//            e.onComplete();
//        }).subscribeOn(Schedulers.newThread())
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .observeOn(Schedulers.io())
//                .subscribe(integer -> {
//                    System.out.println("Observer name=" + Thread.currentThread());
//                    System.out.println("integer" + integer);
//                });
    }
}
