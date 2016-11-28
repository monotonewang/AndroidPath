package com.androidpath.library.Retrofit.activity;

import android.os.Bundle;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;
import com.androidpath.library.Retrofit.utils.Constants;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public class RetrofitActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        getMethodTest();

    }

    /**
     * Get方法测试
     */
    private void getMethodTest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.url)
                .build();

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


    public interface MyRetrofitService {
        @GET(Constants.urlGet)
        Call<ResponseBody> getFirstJson();
    }
}
