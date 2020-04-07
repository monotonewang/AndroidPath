package com.androidpath.library.rxjava;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.androidpath.R;
import com.androidpath.activity.aabase.MainActivity;
import com.androidpath.library.rxjava.test.RxJavaThreadTest;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class RxActivity extends AppCompatActivity {

    private String TAG = "RxActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);

        ImageButton imageButton = (ImageButton) findViewById(R.id.iv_rx);
        Button btnNext = (Button) findViewById(R.id.btn_next);
        Drawable drawable = ContextCompat.getDrawable(RxActivity.this, R.mipmap.ic_launcher);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("xxxxxxxxxxxxxxxxxx onClick" + v.toString());
                startActivity(new Intent(RxActivity.this, MainActivity.class));
            }
        });

        System.out.println("xxxxxxxxxxxxxxxxxx start" );

        getLifecycle().addObserver(new LifecycleObserver() {

        });
        Observable.interval(0, 1, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                        System.out.println("xxxxxxxxxxxxxxxxxx onSubscribe" + d.toString());
                    }

                    @Override
                    public void onNext(Long aLong) {
                        System.out.println("xxxxxxxxxxxxxxxxxx onNext" + aLong);
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println("xxxxxxxxxxxxxxxxxx onError" + e.toString());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("xxxxxxxxxxxxxxxxxx onComplete");
                    }
                });

//        rxSetBitmap(imageButton, drawable);
//        RxJavaThreadTest.rx2();
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
     *
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
