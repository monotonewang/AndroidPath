package com.androidpath.library.retrofit.inter;

import com.androidpath.library.retrofit.data.Person;
import com.androidpath.library.retrofit.utils.Constants;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

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

    @POST(Constants.insertPerson)
    Call<ResponseBody> postPersonJson(@Body Person person);

    @POST(Constants.gitUrl)
    Call<ResponseBody> getJsonByQueryMap(@QueryMap Map<String,String> params);

    @FormUrlEncoded
    @POST(Constants.urlGetnum)
    Call<ResponseBody> getJsonByFiledMap(@FieldMap() Map<String,String> params);

    @GET
    Call<ResponseBody> getByURL(@Url String url);

    @GET(Constants.cardUrl)
    Call<ResponseBody> getCardUrl();

    @GET(Constants.personUrl)
    Call<ResponseBody> getPerson(@QueryMap HashMap<String,String>  hashMap);

    @GET(Constants.getByDown)//small file download
    Call<ResponseBody> getImageDownload();

    @Streaming//big file download ,must run in child thread
    @GET(Constants.getByDown)
    Call<ResponseBody> getBigFileDownload();

    @Streaming
    @GET(Constants.fileDownload)
    Call<ResponseBody> getMap3Download();

    @Multipart
    @POST("/image/uploadImages")
    Call<ResponseBody> uploadFiles(@PartMap Map<String, RequestBody> maps);

    @Multipart
    @POST("/image/uploads")
    Call<ResponseBody> uploadImageMore(@Part MultipartBody.Part file);

    @Multipart
    @POST("/image/upload")
    Call<ResponseBody> uploadFile(@Part("description") RequestBody description, @Part MultipartBody.Part file);
}
