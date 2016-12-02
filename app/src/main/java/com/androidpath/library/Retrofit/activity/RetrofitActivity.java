package com.androidpath.library.retrofit.activity;

import android.os.Bundle;
import android.util.Log;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;
import com.androidpath.library.retrofit.inter.MyRetrofitService;
import com.androidpath.library.retrofit.utils.Constants;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends BaseActivity {

    private Retrofit retrofit;
    private String TAG = "RetrofitActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.url)
//                .baseUrl(Constants.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
//        getMethodTest();
//        getJsonByParam();
//        getJsonByHttp();
        getJsonByPost();
//        getGitHubData();

    }

    private void getJsonByPost() {
        MyRetrofitService service = retrofit.create(MyRetrofitService.class);
        Call<ResponseBody> jsonByPost = service.getJsonByPost();
        jsonByPost.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.e(TAG, response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }

    //PATH用法
    private void getGitHubData() {
        MyRetrofitService service = retrofit.create(MyRetrofitService.class);
        Call<ResponseBody> repos = service.listRepos("montotone");
        repos.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                Log.e("APP",response.body().source().toString());
                try {
                    Log.e(TAG, response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, t.getMessage());
            }
        });
    }

    private void getJsonByHttp() {
        MyRetrofitService myRetrofitService = retrofit.create(MyRetrofitService.class);
        Call<ResponseBody> jsonByHttp = myRetrofitService.getJsonByHttp("montotone");
        jsonByHttp.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String s1 = null;
                try {
                    s1 = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.e(TAG, "onResponse: " + "s1=" + s1);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "t.getMessage()");
            }
        });
    }

    //Query使用方法
    private void getJsonByParam() {
        MyRetrofitService myRetrofitService = retrofit.create(MyRetrofitService.class);

        Call<ResponseBody> jsonByParam = myRetrofitService.getJsonByParam(9);

        jsonByParam.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String s1 = null;
                try {
                    s1 = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.e(TAG, "onResponse: " + "s1=" + s1);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "t.getMessage()");
            }
        });
    }

    /**
     * Get方法测试
     */
    private void getMethodTest() {

        MyRetrofitService service = retrofit.create(MyRetrofitService.class);
        Call<ResponseBody> firstJson = service.getFirstJson();
        firstJson.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    System.out.println(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
    }

}
