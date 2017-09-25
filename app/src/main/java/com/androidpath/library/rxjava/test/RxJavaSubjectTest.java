package com.androidpath.library.rxjava.test;

import org.junit.Test;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;

/**
 * Created by ubuntu on 17-9-25.
 */

public class RxJavaSubjectTest {

    @Test
    public void publishSubject(){
        PublishSubject publishSubject=PublishSubject.create();

        publishSubject.onNext(1);
        publishSubject.onNext(2);
        publishSubject.onNext(3);
        publishSubject.onNext(4);
        publishSubject.onNext(5);

        publishSubject.onComplete();
        publishSubject.subscribe(new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(@NonNull Object o) {
                System.out.println("onNext");

            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }

    @Test
    public void ReplaySubject(){
        ReplaySubject replaySubject=ReplaySubject.create();

        replaySubject.onNext(1);
        replaySubject.onNext(2);
        replaySubject.onNext(3);
        replaySubject.onNext(4);
        replaySubject.onNext(5);

        replaySubject.onComplete();
        replaySubject.subscribe(new Observer() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(@NonNull Object o) {
                System.out.println("onNext");

            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }
}
