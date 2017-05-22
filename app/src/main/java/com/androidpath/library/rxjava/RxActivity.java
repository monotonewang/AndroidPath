package com.androidpath.library.rxjava;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

import com.androidpath.R;
import com.androidpath.library.rxjava.test.RxJavaThreadTest;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RxActivity extends AppCompatActivity {

    private String TAG = "RxActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);

        ImageButton imageButton= (ImageButton) findViewById(R.id.iv_rx);
        Drawable drawable= ContextCompat.getDrawable(RxActivity.this,R.mipmap.ic_launcher);


        rxSetBitmap(imageButton, drawable);
        RxJavaThreadTest.rx2();
//        RxFun1();
//        RxFun2();
//        RxDisposableTest3();
//        RxComsumerTest4();
//        RxThreadTest1();
//        RxThreadTest2();
//        RxThreadTest3();
//        RxThreadTest4();
    }

    /**
     * 通过rxjava设置图片
     * @param imageButton
     * @param drawable
     */
    private void rxSetBitmap(final ImageButton imageButton, final Drawable drawable) {
        Observable.create(new ObservableOnSubscribe<Drawable>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Drawable> e) throws Exception {
                e.onNext(drawable);
                e.onComplete();
                System.out.println("subscribe");
            }
        }).subscribe(new Consumer<Drawable>() {
            @Override
            public void accept(@NonNull Drawable drawable) throws Exception {
                imageButton.setImageDrawable(drawable);
            }
        });
    }

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


}
