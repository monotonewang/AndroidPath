package com.androidpath.library.rxjava;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.androidpath.R;
import com.androidpath.activity.aabase.MainActivity;
import com.androidpath.library.rxjava.dao.User;
import com.androidpath.library.rxjava.dao.UserViewModel;
import com.androidpath.library.rxjava.dao.ViewModelFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 2021年02月12日15:34:04
 * BaseRxJavaSample
 * https://github.com/android/architecture-components-samples
 */
public class RxActivity extends AppCompatActivity {

    private static final String TAG = RxActivity.class.getSimpleName();

    private TextView mUserName;

    private EditText mUserNameInput;

    private Button mUpdateButton;

    private ViewModelFactory mViewModelFactory;

    private UserViewModel mViewModel;

    private final CompositeDisposable mDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);

        mUserName = findViewById(R.id.user_name);
        mUserNameInput = findViewById(R.id.user_name_input);
        mUpdateButton = findViewById(R.id.update_user);

        TextView tvText = findViewById(R.id.tv_text);


        ImageButton imageButton = (ImageButton) findViewById(R.id.iv_rx);
        Button btnNext = (Button) findViewById(R.id.btn_next);
        Drawable drawable = ContextCompat.getDrawable(RxActivity.this, R.mipmap.ic_launcher);

        mViewModelFactory = Injection.provideViewModelFactory(this);
        mViewModel = new ViewModelProvider(this, mViewModelFactory).get(UserViewModel.class);
        mUpdateButton.setOnClickListener(v -> updateUserName());

        mViewModel.getUsers().observe(RxActivity.this, new androidx.lifecycle.Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                System.out.println("observe users yes" + users.toString());
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Disposable subscribe = Observable.create((ObservableOnSubscribe<List<User>>) e -> {
                    List<User> value2 = mViewModel.getUsers2();
//                    List<User> value2 = mViewModel.getUsers().getValue();

                    e.onNext(value2);
                }).observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe(new Consumer<List<User>>() {
                            @Override
                            public void accept(List<User> studentEntity) throws Exception {
                                tvText.setText("插入数据：" + studentEntity.toString());
                            }
                        });
            }
        });

        getLifecycle().addObserver(new LifecycleObserver() {

        });
        intervalTest();

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

    private void updateUserName() {
        String userName = mUserNameInput.getText().toString();
        // Disable the update button until the user name update has been done
        mUpdateButton.setEnabled(false);
        // Subscribe to updating the user name.
        // Re-enable the button once the user name has been updated
        mDisposable.add(mViewModel.updateUserName(userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> {
                            mUpdateButton.setEnabled(true);
                            Log.e(TAG, "yes");
                        },
                        throwable -> Log.e(TAG, "Unable to update username", throwable)));
    }

    private void intervalTest() {
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
