package com.example.a2021basic.application

import android.app.Application
import android.util.Log
import com.example.a2021basic.BuildConfig
import com.example.http_common.BaseHttpParamInterceptor
import com.example.http_common.HttpLoggingInterceptor
import com.example.http_common.RetrofitClientKt
import okhttp3.Interceptor
import java.util.*

class MainApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        initHttpClient()
    }

    private fun initHttpClient() {
        val paramInterceptor: Interceptor = object : BaseHttpParamInterceptor(BuildConfig.UrlAddress) {
            override fun changedParams(): Map<String, String>? {
                val params: MutableMap<String, String> = HashMap()
                //这里为公共的参数
                params["platform"] = "android"
//                params["version"] = java.lang.String.valueOf(AppTool.getVersionName(MainApplication.getContext()))
//                if (Pub.isStringNotEmpty(Config.getToken())) {
//                    params["token"] = Config.getToken()
//                }
//                if (Pub.isStringNotEmpty(Config.getOrganization_id())) {
//                    params["organization_id"] = Config.getOrganization_id()
//                    //暂时安卓 先独自添加一个 是否是企业端的字段
//                    params["is_organization"] = "1"
//                }
//                if (!Config.isCompany() && Config.getCompany() != null &&
//                        Pub.isStringNotEmpty(Config.getUserOrganization_id()) &&
//                        Pub.isStringEmpty(params["user_organization_id"])) {
//                    params["user_organization_id"] = Config.getUserOrganization_id()
//                }
                return params
            }
        }
        val loggingInterceptor = HttpLoggingInterceptor(BuildConfig.UrlAddress,object : HttpLoggingInterceptor.Logger {
            override fun log(message: String?) {
                if (null != message) {
                    Log.e("okhttp-log_url", "/--------------start----------------\\")
                    Log.e("okhttp-log_url", message)
                    Log.e("okhttp-log_url", "\\--------------end----------------/")
                }
            }
        })

        RetrofitClientKt.getInstance()
                .addCookieManager(this)
                .domain("https://test2019.jiheapp.com") //                .converter(gsonConverterFactoryKt)
                .addInterceptor(paramInterceptor)
                .addInterceptor(loggingInterceptor)
                .build()
    }
}