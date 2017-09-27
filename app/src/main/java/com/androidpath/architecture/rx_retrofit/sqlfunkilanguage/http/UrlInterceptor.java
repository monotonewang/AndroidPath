package com.androidpath.architecture.rx_retrofit.sqlfunkilanguage.http;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ubuntu on 17-9-27.
 */

public class UrlInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();


        HttpUrl url = request.url();

        String scheme = url.scheme();
        String host = url.host();
        URI uri = url.uri();
        URL url1 = url.url();
        System.out.println("-----------------url="+url+"scheme="+scheme+"host="+host);
        System.out.println("/n-----------------uri="+uri.toString()+"url1="+url1.toString());

        Request.Builder builder = request.newBuilder();


        Response response = chain.proceed(builder.build());

        return response;
    }

}
