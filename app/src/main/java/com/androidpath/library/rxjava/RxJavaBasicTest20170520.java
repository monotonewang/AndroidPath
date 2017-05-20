package com.androidpath.library.rxjava;

import com.androidpath.activity.aiviewpager.cbk.chabaike240.util.NetWorkUtil;
import com.androidpath.util.NetWorkUtils;

import org.junit.Test;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * http://blog.csdn.net/u012124438/article/details/53730717
 * Created by WangHome on 2017/5/20.
 */

public class RxJavaBasicTest20170520 {

    /**
     * 常规模式
     */
    @Test
    public void RxFun1() {
        //创建一个被观察者Observable：
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });
        //创建观察者Observer
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Integer value) {
                System.out.println("onNext="+value.toString());
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };
        //建立连接
        observable.subscribe(observer);
    }

    /**
     * 链式编程
     */
    @Test
    public void RxFun2() {
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            emitter.onNext(2);
            emitter.onNext(3);
            emitter.onComplete();
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
            }

            @Override
            public void onNext(Integer value) {
                System.out.println("onNext=" + value);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }

    /**
     * 简单创建被观察者，consumer简化了 onComplete onError
     */
    @Test
    public void RxFun3(){
        Observable<String> observable = Observable.just("hello");
        Consumer<String> consumer=new Consumer<String>(){

            @Override
            public void accept(@NonNull String s) throws Exception {
                System.out.println("string="+s);
            }
        };
        observable.subscribe(consumer);
    }

    /**
     * 我们可以为 Observer中的三种状态根据自身需要分别创建一个回调动作，通过Action 来替代onComplete():，通过Consumer来替代 onError(Throwable t)和onNext(T t)
     */
    @Test
    public void rxFun4(){
        Observable<String> observable=Observable.just(NetWorkUtils.getIP("www.baidu.com"));
        Action onCompleteAction=new Action(){

            @Override
            public void run() throws Exception {
                System.out.println("action="+"oncomplete");
            }
        };
        Consumer<String> onNextConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("accept="+"onNextConsumer");
            }
        };
        Consumer<Throwable> onErrorConsumer = new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                System.out.println("accept="+"onErrorConsumer");
            }
        };
        observable.subscribe(onNextConsumer, onErrorConsumer, onCompleteAction);
    }

    /**
     * Observable.just同样可以发送多个参数
     */
    @Test
    public void rxFun5(){
        Observable observable = Observable.just("you", "are", "beautiful");
        Consumer<String> onNextConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("string="+s);
            }
        };
        observable.subscribe(onNextConsumer);
    }


    /**
     * 它就会将两根管道切断, 从而导致下游收不到事件.
     * 注意: 调用dispose()并不会导致Observable不再继续发送事件, Observable会继续发送剩余的事件.
     */
    @Test
    public void RxDisposableTest3() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onComplete();
                e.onNext(3);
            }
        }).subscribe(new Observer<Integer>() {
            private Disposable disposable;//起到拦截的作用
            private int i;

            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe");
                disposable = d;
            }

            @Override
            public void onNext(Integer value) {
                System.out.println("onNext=" + value);
                if (i > 2) {
                    disposable.dispose();
                }
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError");
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }


    @Test
    public void test() {
        Flowable.just("Hello world").subscribe(System.out::println);
    }



}
