package com.androidpath.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/12/19 10:17 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class NetWorkUtils {
    public static boolean checkNetworkConnection(Context context) {
        ConnectivityManager connMgr = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        boolean isConnected = false;
        if (networkInfo != null && (isConnected = networkInfo.isConnected())) {
            // show "Connected" & type of network "WIFI or MOBILE"

        }
        return isConnected;
    }

    /**
     * 通过域名获取ip
     */
    public static String getIP(String name) {
        InetAddress address = null;
        try {
            address = InetAddress.getByName(name);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            System.out.println("获取失败");
        }
        String ip = address.getHostAddress().toString();
        System.out.println(ip);
        return ip;
    }
}
