package com.androidpath.activity.adlistview.listviewjoke90;

import android.os.AsyncTask;

import com.androidpath.activity.adlistview.listviewjoke90.bean.Joke;
import com.androidpath.activity.adlistview.listviewjoke90.util.MyHttpUtil;
import com.androidpath.activity.adlistview.listviewjoke90.util.MyParserUtil;

import java.util.ArrayList;
import java.util.List;


public class DowloadDataAsyncTask extends AsyncTask<String, Void, List<Joke>> {

    public interface OnDownloadJokeCompleteListener {
        void OnDownloadJokeComplete(List<Joke> list);
    }


    private OnDownloadJokeCompleteListener onDownloadJokeCompleteListener;


    @Override
    protected List<Joke> doInBackground(String... params) {
        List<Joke> list = new ArrayList<>();
        String urlString = params[0];
        //下载数据
        String jsonString = MyHttpUtil.dowloadString(urlString);
//		Log.e("jsonString", jsonString);

        //进行解析
        list.addAll(MyParserUtil.parseJson(jsonString));

        return list;
    }


    @Override
    protected void onPostExecute(List<Joke> result) {
        //下载完成后，回调客户端的监听接口中的方法
        onDownloadJokeCompleteListener.OnDownloadJokeComplete(result);
    }


    public void setOnDownloadJokeCompleteListener(
            OnDownloadJokeCompleteListener onDownloadJokeCompleteListener) {
        // TODO Auto-generated method stub
        this.onDownloadJokeCompleteListener = onDownloadJokeCompleteListener;
    }

}
