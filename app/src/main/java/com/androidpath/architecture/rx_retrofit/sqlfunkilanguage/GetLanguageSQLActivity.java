package com.androidpath.architecture.rx_retrofit.sqlfunkilanguage;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.androidpath.R;
import com.androidpath.architecture.rx_retrofit.sqlfunkilanguage.adapter.BaseEntity;
import com.androidpath.architecture.rx_retrofit.sqlfunkilanguage.adapter.GetLanguageAdapter;
import com.androidpath.architecture.rx_retrofit.sqlfunkilanguage.entity.LanguageResponse;
import com.androidpath.architecture.rx_retrofit.sqlfunkilanguage.http.RetrofitManager;
import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;

import java.util.ArrayList;
import java.util.List;

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
        setContentView(R.layout.activity_get_language);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        SmartRefreshLayout refreshLayout = (SmartRefreshLayout) findViewById(R.id.refreshLayout);
        //设置 Header 为 Material风格
        refreshLayout.setRefreshHeader(new MaterialHeader(this).setShowBezierWave(true));
        //设置 Footer 为 球脉冲
        refreshLayout.setRefreshFooter(new BallPulseFooter(this).setSpinnerStyle(SpinnerStyle.Scale));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        GetLanguageAdapter adapter = new GetLanguageAdapter(null);
        recyclerView.setAdapter(adapter);

        RetrofitManager.init();
        RetrofitManager.createGetLanguageApi().getLanguage()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseEntity<LanguageResponse>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        System.out.println("--------------------------------" + SystemClock.currentThreadTimeMillis() / 1000 + "onSubscribe");
                    }

                    @Override
                    public void onNext(@NonNull BaseEntity<LanguageResponse> responseBaseEntity) {
                        if (responseBaseEntity.getCode() == 0 && responseBaseEntity.data != null && responseBaseEntity.data.lan != null && !responseBaseEntity.data.lan.isEmpty()) {
                            List<LanguageResponse.LanBean> lanList = responseBaseEntity.data.lan;
                            List<LanguageResponse.LanBean> newLanList = new ArrayList<LanguageResponse.LanBean>();

                            for (int k = 0; k < 4; k++) {
                                for (int i = 0; i < lanList.size(); i++) {
                                    newLanList.add(lanList.get(i));
                                }
                            }

                            adapter.setNewData(newLanList);
                        }
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
