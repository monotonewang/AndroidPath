package com.androidpath.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/19 10:17 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class NetWorkUtils {
    public  static  boolean checkNetworkConnection(Context context) {
        ConnectivityManager connMgr = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        boolean isConnected = false;
        if (networkInfo != null && (isConnected = networkInfo.isConnected())) {
            // show "Connected" & type of network "WIFI or MOBILE"

        }
        return isConnected;
    }
}
