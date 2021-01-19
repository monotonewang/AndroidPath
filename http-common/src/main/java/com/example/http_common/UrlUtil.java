package com.example.http_common;

import android.text.TextUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @desc:
 * @author：zg
 * @date:17/10/25
 * @time:下午4:45
 */
public class UrlUtil {

    public final static String HTTPMETHOD_GET = "GET";
    public final static String HTTPMETHOD_POST = "POST";
    public final static String HTTPMETHOD_PUT = "PUT";
    public final static String HTTPMETHOD_DELETE = "DELETE";
    public final static String HTTPMETHOD_PATCH = "PATCH";


    /**
     * 解析请求参数
     *
     * @param request
     * @return
     */
    public static Map<String, String> parseParams(Request request) {
        //GET POST DELETE PUT PATCH
        String method = request.method();
        Map<String, String> params = null;
        if (HTTPMETHOD_GET.equals(method)) {
            params = doGet(request);
        } else if ((isOtherHttpMethod(method))) {
            RequestBody body = request.body();
            if (body != null && body instanceof FormBody) {
                params = doForm(request);
            }
        }
        return params;
    }

    /**
     * 获取get方式的请求参数
     *
     * @param request
     * @return
     */
    private static Map<String, String> doGet(Request request) {
        Map<String, String> params = null;
        HttpUrl url = request.url();
        Set<String> strings = url.queryParameterNames();
        if (strings != null) {
            Iterator<String> iterator = strings.iterator();
            params = new HashMap<>();
            int i = 0;
            while (iterator.hasNext()) {
                String name = iterator.next();
                String value = url.queryParameterValue(i);
                params.put(name, value);
                i++;
            }
        }
        return params;
    }

    /**
     * 获取表单的请求参数
     *
     * @param request
     * @return
     */
    private static Map<String, String> doForm(Request request) {
        Map<String, String> params = null;
        FormBody body = null;
        try {
            body = (FormBody) request.body();
        } catch (ClassCastException c) {
        }
        if (body != null) {
            int size = body.size();
            if (size > 0) {
                params = new HashMap<>();
                for (int i = 0; i < size; i++) {
                    params.put(body.name(i), body.value(i));
                }
            }
        }
        return params;
    }

    /**
     * 其他的 http方式
     *
     * @param method 传入的Http方式
     * @return
     */
    public static boolean isOtherHttpMethod(String method) {
        return HTTPMETHOD_POST.equals(method)
                || HTTPMETHOD_PUT.equals(method)
                || HTTPMETHOD_DELETE.equals(method)
                || HTTPMETHOD_PATCH.equals(method);
    }


    public static String map2QueryStr(Map<String, String> map) {
        if (null == map) {
            map = new HashMap<>();
        }
        StringBuffer sb = new StringBuffer();
        Set<String> keys = map.keySet();
        for (String key : keys) {
            sb.append(key).append("=").append(map.get(key)).append("&");
        }
        String result = sb.toString();
        if (result.length() > 0) {
            result = result.substring(0, result.length() - 1);
        }
        return result;
    }

    public static String requestUrl(String url,Request request) {
        Map<String, String> params = parseParams(request);
        if (params == null) {
            params = new HashMap<>();
        }
        StringBuilder sb = new StringBuilder(url + request.url().encodedPath());
//        StringBuilder sb = new StringBuilder( request.url().encodedPath());
        sb.append("?").append(UrlUtil.map2QueryStr(params));
        return sb.toString();
    }

    /**
     * 添加路由结尾问号
     *
     * @param url
     * @return
     */
    public static String addHttpPathEnd(String url) {
        if (!TextUtils.isEmpty(url) && !url.contains("?")) {
            url += "?";
        }
        return url;
    }

}
