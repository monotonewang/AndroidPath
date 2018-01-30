package com.androidpath.library.retrofit.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.androidpath.R;
import com.androidpath.activity.aabase.BaseActivity;
import com.androidpath.library.retrofit.inter.MyRetrofitService;
import com.androidpath.library.retrofit.utils.Constants;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends BaseActivity {

    private Retrofit retrofit;

    private String TAG = "RetrofitActivity";
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        //创建一个Retrofit对象
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.homeUrl)
//                .baseUrl(Constants.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
//        getMethodTest();
//        getJsonByParam();
//        getJsonByHttp();
//        getJsonByPost();
//        getGitHubData();
//        getJsonByQueryMap();
//        getJsonByFiledMap();
//        getByURL();
//        imageView = (ImageView) findViewById(R.id.imageviewre);
//        getImageDownload();
//        getMap3Download();

//        List<File> files=new ArrayList<>();
//        files.add(new File(""));
//        uploadFiles(files);

        uploadFile(new File(""));
    }

    /**
     * 上传单个文件
     *
     * @param file
     */
    private void uploadFile(File file) {
        if (file == null) {
            Log.e(TAG, "uploadFile: " + "is null");
            return;
        }
        RequestBody requestBody = RequestBody.create(MultipartBody.FORM, file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
        String descriptionString = "";
        RequestBody description = RequestBody.create(MediaType.parse("multipart/form-data"), descriptionString);
        //third
        MyRetrofitService service = retrofit.create(MyRetrofitService.class);
        Call<ResponseBody> mp3 = service.uploadFile(description, part);
        mp3.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    /**
     * 上传多个文件
     *
     * @param files
     */
    private void uploadFiles(List<File> files) {

        Map<String, RequestBody> partMapBody = new HashMap<>();
        for (int i = 0; i < files.size(); i++) {
            RequestBody requestBody = RequestBody.create(MultipartBody.FORM, files.get(i));
            String fileName = files.get(i).getName();
            int i1 = fileName.lastIndexOf(".");
            String suffix = fileName.substring(i1, fileName.length());
            String newFileName = UUID.randomUUID().toString() + System.currentTimeMillis() + suffix;
            Log.e(TAG, "uploadFile: " + newFileName);
            partMapBody.put("files\";filename=\"" + newFileName, requestBody);
        }

        MyRetrofitService service = retrofit.create(MyRetrofitService.class);
        Call<ResponseBody> mp3 = service.uploadFiles(partMapBody);
        mp3.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void getMap3Download() {
        MyRetrofitService service = retrofit.create(MyRetrofitService.class);
        Call<ResponseBody> mp3 = service.getMap3Download();
        mp3.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                InputStream inputStream = response.body().byteStream();
                if (inputStream != null) {
                    try {
                        byte[] bytes = new byte[inputStream.available()];
                        int read = inputStream.read(bytes);
                        Log.e(TAG, "onResponse: " + read);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                } else {
                    Log.e(TAG, "onResponse:  the inputstream is null,");
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    //down image
    private void getImageDownload() {
        MyRetrofitService service = retrofit.create(MyRetrofitService.class);
        Call<ResponseBody> imageDownload = service.getImageDownload();
        imageDownload.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                String name = Thread.currentThread().getName();
                InputStream inputStream = response.body().byteStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);
                Log.e(TAG, "onResponse: " + name);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void getJsonByFiledMap() {
        MyRetrofitService service = retrofit.create(MyRetrofitService.class);
        Map<String, String> map = new HashMap<>();
        map.put("username", "zhangsan");
        map.put("password", "test");
        Call<ResponseBody> jsonByQueryMap = service.getJsonByFiledMap(map);
        jsonByQueryMap.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.e(TAG, "onResponse: " + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    //@URL baseurl not use
    private void getByURL() {
        MyRetrofitService service = retrofit.create(MyRetrofitService.class);
        Call<ResponseBody> byURL = service.getByURL(Constants.Url);
        byURL.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.e(TAG, "onResponse: " + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void getJsonByQueryMap() {
        MyRetrofitService service = retrofit.create(MyRetrofitService.class);
        Map<String, String> map = new HashMap<>();
        map.put("username", "zhangsan");
        map.put("password", "test");
        Call<ResponseBody> jsonByQueryMap = service.getJsonByQueryMap(map);
        jsonByQueryMap.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.e(TAG, "onResponse: " + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    private void getJsonByPost() {
        MyRetrofitService service = retrofit.create(MyRetrofitService.class);
        Call<ResponseBody> jsonByPost = service.getJsonByPost();
        jsonByPost.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String name = Thread.currentThread().getName();
                    //主线程
                    Log.e(TAG, response.body().string() + "threadname=" + name);
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
        Call<ResponseBody> repos = service.getJsonByNum("montotone");
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
        Retrofit retrofit = new Retrofit.Builder()
                .client(new OkHttpClient())//设置底层请求库
                .baseUrl(Constants.homeUrl)
                .build();

        MyRetrofitService service = retrofit.create(MyRetrofitService.class);

//        Call<ResponseBody> firstJson = service.getFirstJson();
//        firstJson.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    Log.e(TAG, "onResponse: "+ response.body().string());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Log.e(TAG, "onFailure: "+ t.getMessage());
//            }
//        });
        Call<ResponseBody> call = service.getJsonByNum("3 ");
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.e(TAG, "onResponse: " + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
