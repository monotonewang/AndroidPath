package com.androidpath.activity.acasync.networkconn;

import android.os.AsyncTask;
import android.util.Log;

import com.androidpath.util.ConstantsUrlUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/19 10:38 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class HTTPAsyncTask extends AsyncTask<String, Void, String> {
    private onDownLoadListener loadListener;
    private String TAG = "HTTPAsyncTask";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.e(TAG, "onPreExecute: ");
    }

    @Override
    protected String doInBackground(String... params) {
        String stringHTTPGet = getStringHTTPGet(ConstantsUrlUtils.STRING_URL);
        Log.e(TAG, "doInBackground: " + stringHTTPGet);
        return stringHTTPGet;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        loadListener.OnDownLoadComplete(s);
    }

    String getStringHTTPGet(String urlString) {
        InputStream inputStream = null;
        String result = null;
        try {
            URL url = new URL(urlString);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            inputStream = urlConnection.getInputStream();
            if (inputStream != null) {
                byte[] bs = convertInputStreamToString(inputStream);
                result = new String(bs, "utf-8");
            } else {
               result="can not load data";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * convertInputStreamToString
     *
     * @param inputStream
     * @return
     */
    private byte[] convertInputStreamToString(InputStream inputStream) {
        byte b[] = new byte[1024];
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int len = 0;
        try {
            while ((len = inputStream.read(b)) != -1) {
                out.write(b, 0, len);
            }
            return out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    interface onDownLoadListener {
        void OnDownLoadComplete(String str);
    }

    public void setOnDownLoadListener(onDownLoadListener onDownLoadListener) {
        this.loadListener = onDownLoadListener;
    }
}
