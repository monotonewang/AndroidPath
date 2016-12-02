package com.androidpath.library.retrofitxxx.inter;

import com.androidpath.library.retrofitxxx.utils.Constants;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/2 18:07 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public interface MyRetrofitService {
    @GET(Constants.urlGet)
    Call<ResponseBody> getFirstJson();

    @GET(Constants.urlGetnum)
    Call<ResponseBody> getJsonByParam(@Query("num") int num);

    @HTTP(method = "get" ,path = "users/{user}/repos",hasBody = false)
    Call<ResponseBody>  getJsonByHttp(@Path("user")String user);

    @GET("users/{user}/repos")
    Call<ResponseBody> getJsonByNum(@Path("user") String user);

    @POST(Constants.urlPost)
    Call<ResponseBody> getJsonByPost();

    @POST(Constants.urlGetnum)
    Call<ResponseBody> getJsonByQueryMap(@QueryMap Map<String,String> params);
}
