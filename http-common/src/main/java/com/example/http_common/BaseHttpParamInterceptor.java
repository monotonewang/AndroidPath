package com.example.http_common;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;


/**
 * @desc: okhttp请求拦截器，用于修改请求时的参数
 * @author：zg
 * @date:17/10/25
 * @time:下午5:00
 */
public abstract class BaseHttpParamInterceptor implements Interceptor {

    String urlAddress="";

    public BaseHttpParamInterceptor(@NotNull String urlAddress) {
        this.urlAddress=urlAddress;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(handlerRequest(chain.request()));
    }

    /**
     * 需要修改、增加的参数集合
     *
     * @return
     */
    protected abstract Map<String, String> changedParams();


    public Request handlerRequest(Request request) {
        Map<String, String> params = UrlUtil.parseParams(request);
        if (params == null) {
            params = new HashMap<>();
        }
        Map<String, String> changedParams = changedParams();
        if (null != changedParams) {
            Set<String> changedKeys = changedParams.keySet();
            for (String key : changedKeys) {
                params.put(key, changedParams.get(key));
            }
        }
        String method = request.method();
        if ("GET".equals(method)) {
            StringBuilder sb = new StringBuilder(this.urlAddress + request.url().encodedPath());
//            StringBuilder sb = new StringBuilder( request.url().encodedPath());
            sb.append("?").append(UrlUtil.map2QueryStr(params));
            return request.newBuilder().url(sb.toString()).build();
        } else if (UrlUtil.isOtherHttpMethod(method)) {
            if (request.body() instanceof FormBody) {
                FormBody.Builder bodyBuilder = new FormBody.Builder();
                Set<String> keys = params.keySet();
                for (String key : keys) {
                    if (params.get(key) != null) {
                        bodyBuilder.add(key, params.get(key));
                    }
                }
                return request.newBuilder().method(method, bodyBuilder.build()).build();
            }
        }
        return request;
    }




}
