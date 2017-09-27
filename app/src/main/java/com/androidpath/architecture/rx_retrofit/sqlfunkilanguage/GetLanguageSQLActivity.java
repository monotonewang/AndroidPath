package com.androidpath.architecture.rx_retrofit.sqlfunkilanguage;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.androidpath.architecture.rx_retrofit.sqlfunkilanguage.entity.LanguageResponse;
import com.androidpath.architecture.rx_retrofit.sqlfunkilanguage.http.RetrofitManager;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ubuntu on 17-9-27.
 */

public class GetLanguageSQLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RetrofitManager.init();
        RetrofitManager.createGetLanguageApi().getLanguage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LanguageResponse>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        System.out.println("--------------------------------" + SystemClock.currentThreadTimeMillis() / 1000 + "onSubscribe");
                    }

                    @Override
                    public void onNext(@NonNull LanguageResponse languageResponse) {
                        System.out.println("--------------------------------" + SystemClock.currentThreadTimeMillis() / 1000 + "onNext");
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        System.out.println("--------------------------------" + SystemClock.currentThreadTimeMillis() / 1000 + "onError");
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("--------------------------------" + SystemClock.currentThreadTimeMillis() / 1000 + "onComplete");
                    }
                });
    }


}
