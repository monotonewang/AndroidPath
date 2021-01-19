package com.example.http_common;

import android.content.Context;


import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Interceptor;
import okhttp3.JavaNetCookieJar;
import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Desc: 需要在程序启动时，进行初始化操作。
 * 步骤：
 * 1、实例化{@link #getInstance()}
 * 2、设置系统域名{@link #domain(String)}
 * 3、cookie自动化管理{@link #addCookieManager(Context)}(可选)
 * 4、创建retrofit实例{@link #build()}
 * <p>
 * 文件上传,下载使用{@link com.steptowin.core.http.okhttp.OkHttpRequest}
 * @Author: zg
 * @Time: 2016-03-30前
 */
public class RetrofitClientKt {
    private static RetrofitClientKt instance = new RetrofitClientKt();
    private static final int TIMEOUT = 60;
    private OkHttpClient client;
    private Retrofit restAdapter;
    private Retrofit.Builder restBuilder;

    private RetrofitClientKt() {
        restBuilder = new Retrofit.Builder();
        client = new OkHttpClient();
        restBuilder.addConverterFactory(GsonConverterFactory.create());
//        restBuilder.addCallAdapterFactory(new ObserveOnMainCallAdapterFactory(Schedulers.io(), AndroidSchedulers.mainThread()));
//        restBuilder.addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.newThread()));
    }

    public OkHttpClient getClient() {
        return client;
    }

    public void setClient(OkHttpClient client) {
        this.client = client;
    }

    public static RetrofitClientKt getInstance() {
        if (null == instance)
            instance = new RetrofitClientKt();
        return instance;
    }

    public RetrofitClientKt addCookieManager(Context context) {
        //添加Cookie管理
        CookieHandler cookieHandler = new CookieManager(new PersistentCookieStore(context),
                CookiePolicy.ACCEPT_ALL);
        client = client.newBuilder().cookieJar(new JavaNetCookieJar(cookieHandler)).
                connectTimeout(TIMEOUT * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(TIMEOUT * 1000, TimeUnit.MILLISECONDS)
                .writeTimeout(TIMEOUT * 1000, TimeUnit.MILLISECONDS)//增加，超时时间暂设为60秒
                .cookieJar(new JavaNetCookieJar(cookieHandler)).build();
        return instance;
    }

    public RetrofitClientKt addhostnameVerifier() {
        client = client.newBuilder().hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        }).build();
        return instance;
    }

    /**
     * @Desc: 设定系统域名，注意：如果非第一次调用，则要继续调用{@link #build()}重新初始化
     * @Author: zg
     * @Time: 2016/1/19 16:33
     */
    public RetrofitClientKt domain(String domain) throws IllegalArgumentException {
        restBuilder.baseUrl(domain);
        return instance;
    }

    public RetrofitClientKt converter(Converter.Factory converter) {
        restBuilder.addConverterFactory(converter);
        return instance;
    }

    public RetrofitClientKt addInterceptor(Interceptor interceptor) {
        client = client.newBuilder().addInterceptor(interceptor).build();
        return instance;
    }

    public RetrofitClientKt removeInterceptor(Interceptor interceptor) {
        OkHttpClient.Builder builder = client.newBuilder();
        builder.interceptors().remove(interceptor);
        client = builder.build();
        return instance;
    }

    public RetrofitClientKt addNetworkInterceptor(Interceptor interceptor) {
        client = client.newBuilder().addNetworkInterceptor(interceptor).build();
        return instance;
    }

    public Retrofit build() {
        restBuilder.client(client);
        restAdapter = restBuilder.build();
        return restAdapter;
    }

    /**
     * @Desc: 必须要在执行过{}{@link #build()}后调用
     * @Author: zg
     * @Time: 2016/1/19 16:32
     */
    public static <T> T createApi(Class<T> clazz) {
        if (null == getInstance().restAdapter) {
            throw new ExceptionInInitializerError("restAdapter 并没有初始化");
        }
        return getInstance().restAdapter.create(clazz);
    }


    /**
     * 网络请求静态方法
     */
}
