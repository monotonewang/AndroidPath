package com.androidpath.library.rxjava;

import org.junit.Test;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/29 15:28 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class RxJavaTest {


    @Test
    public void RxThreadTest4() {
        //main thread
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                System.out.println("Observable thread is : " + Thread.currentThread().getName());
                System.out.println("emit 1");
                emitter.onNext(1);
            }
        });
        //main thread
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("Consumer thread is : " + Thread.currentThread().getName());
                System.out.println("Consumer" + integer);
            }
        };

        observable.subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("After observeOn(mainThread), current thread is: " + Thread.currentThread().getName());
                    }
                })
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        System.out.println("After observeOn(io), current thread is : " + Thread.currentThread().getName());
                    }
                })
                .subscribe(consumer);
    }


    //thread test 3
    @Test
    public void RxThreadTest3() {
        //main thread
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                System.out.println("Observable thread is : " + Thread.currentThread().getName());
                System.out.println("emit 1");
                emitter.onNext(1);
            }
        });
        //main thread
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("Consumer thread is : " + Thread.currentThread().getName());
                System.out.println("Consumer" + integer);
            }
        };

        //observable choose first----but subscribe choose last;
        observable
                .subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
                .observeOn(Schedulers.io())
                .subscribe(consumer);

    }

    @Test
    public void RxThreadTest2() {
        //main thread
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                System.out.println("Observable thread is : " + Thread.currentThread().getName());
                System.out.println("emit 1");
                emitter.onNext(1);
            }
        });
        //main thread
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("Consumer thread is : " + Thread.currentThread().getName());
                System.out.println("consumer=" + integer);
            }
        };
        observable.subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(consumer);
    }


    /**
     * 线程：查看RxJava在哪个线程执行
     */
    @Test
    public void RxThreadTest1() {
        //main thread
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                System.out.println("Observable thread is : " + Thread.currentThread().getName());
                System.out.println("emit 1");
                emitter.onNext(1);
            }
        });
        //main thread
        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("Consumer thread is : " + Thread.currentThread().getName());
                System.out.println("consumer=" + integer);
            }
        };
        observable.subscribe(consumer);

    }

    @Test
    public void RxComsumerTest4() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                System.out.println("emit 1");
                emitter.onNext(1);
                System.out.println("emit 2");
                emitter.onNext(2);
                System.out.println("emit 3");
                emitter.onNext(3);
                System.out.println("onComplete");
                emitter.onComplete();
                System.out.println("emit 4");
                emitter.onNext(4);
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("onNext:" + integer);
            }
        });
    }





}
