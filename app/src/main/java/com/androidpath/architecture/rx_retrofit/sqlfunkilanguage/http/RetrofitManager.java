package com.androidpath.architecture.rx_retrofit.sqlfunkilanguage.http;

import com.androidpath.architecture.rx_retrofit.sqlfunkilanguage.http.inter.GetLanguageApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ubuntu on 17-9-27.
 */

public class RetrofitManager {

    private static Retrofit retrofit;
    private static GetLanguageApi getLanguageApi;

    public static void init() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);

        // Log信息拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);//这里可以选择拦截级别

        //Header
        HeaderInterceptor headerInterceptor = new HeaderInterceptor();
        //Url地址处理
        UrlInterceptor urlInterceptor = new UrlInterceptor();

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //设置 Debug Log 模式
        builder.addInterceptor(loggingInterceptor);
        builder.addInterceptor(headerInterceptor);
        builder.addInterceptor(urlInterceptor);

//        builder.addInterceptor(new LoggingInterceptor());//使用自定义的Log拦截器
        OkHttpClient client = builder.build();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://api.hifunki.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static GetLanguageApi createGetLanguageApi() {
        if (getLanguageApi == null) {
            getLanguageApi = retrofit.create(GetLanguageApi.class);

        }
        return getLanguageApi;
    }
}
