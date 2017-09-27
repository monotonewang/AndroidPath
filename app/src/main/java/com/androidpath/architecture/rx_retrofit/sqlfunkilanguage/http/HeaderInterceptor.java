package com.androidpath.architecture.rx_retrofit.sqlfunkilanguage.http;

import com.androidpath.util.SystemUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ubuntu on 17-9-27.
 */

public class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        String temporaryAccessToken = "eyd0b2tlbl90eXBlJzogJ2FjY2VzcycsICd0eXAnOiAnSldUJ30=.eyJpbWVpIjogInNkc3NzZGRkc3Nzc3MiLCAic3RhdHVzIjogMCwgImV4cGlyZXMiOiAxNTA1ODgzNTQzLjYyMzE4MiwgInVzZXJJZCI6IDB9.67010de2c5fbc94a1eb76878a68d00a93099165cd0725469453a42348e3213cd";
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();

        builder.addHeader("funkiSystem", "androidFunki");
        builder.addHeader("softwareName", "androidFunki");
        builder.addHeader("imei", SystemUtil.getDeviceUUID());
        builder.addHeader("session", "");
        builder.addHeader("system", SystemUtil.getSystemVersion());
        builder.addHeader("deviceName", SystemUtil.getPhoneMode());
        builder.addHeader("deviceType", "android");
        builder.addHeader("ip", "" );
        builder.addHeader("geo",  "");
        builder.addHeader("isBreak", SystemUtil.isRoot() ? "0" : "1");
        builder.addHeader("funkiVersion", SystemUtil.getVersionCode());

        builder.addHeader("token", temporaryAccessToken);
//                .addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
//                .addHeader("Accept-Encoding", "gzip, deflate")
//                .addHeader("Connection", "keep-alive")
//                .addHeader("Accept", "*/*")
//                .addHeader("Cookie", "add cookies here")
        Response response = chain.proceed(builder.build());

        return response;
    }




}


