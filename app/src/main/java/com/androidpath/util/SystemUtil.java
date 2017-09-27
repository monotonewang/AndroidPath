package com.androidpath.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;

import java.io.File;
import java.util.UUID;

import static android.text.TextUtils.isEmpty;
import static com.androidpath.AndroidApplication.context;

/**
 * Created by ubuntu on 17-9-27.
 */

public class SystemUtil {

    public static String getVersionCode() {
        Context mContext = context.getApplicationContext();

        String version = "1";
        try {
            PackageInfo pi = mContext.getApplicationContext().getPackageManager().getPackageInfo(mContext.getPackageName(), PackageManager.GET_CONFIGURATIONS);
            version = pi.versionName;
            version = version.split("-")[0];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return version;
    }



    public static String getPhoneMode() {
        return Build.MODEL;
    }

    public static String getSystemVersion() {
        return "Android" + android.os.Build.VERSION.RELEASE;
    }

    public static String getPhoneModelWithManufacturer() {
        return Build.MANUFACTURER + " " + android.os.Build.MODEL;
    }


    //获得独一无二的Psuedo ID
    public static String getDeviceUUID() {
        Context mContext = context.getApplicationContext();
        String serial;
        String shot = "35" +
                Build.BOARD.length() % 10 + Build.BRAND.length() % 10 +
                Build.DEVICE.length() % 100 +
                Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 +
                Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 +
                Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 +
                Build.TAGS.length() % 10 + Build.TYPE.length() % 10 +
                Build.USER.length() % 10;                                  //13 位

        try {
            //wifi mac地址
            WifiManager wifi = (WifiManager) mContext.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = wifi.getConnectionInfo();


            serial = info.getMacAddress() ;

            if (!isEmpty(serial)) {
                return new UUID(shot.hashCode(), serial.hashCode()).toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        serial = Build.SERIAL;
        //使用硬件信息拼凑出来的15位号码
        return new UUID(shot.hashCode(), serial.hashCode()).toString();
    }



    /**
     * 判断手机是否ROOT
     */
    public static boolean isRoot() {
        boolean root = false;
        try {
            if ((!new File("/system/bin/su").exists())
                    && (!new File("/system/xbin/su").exists())) {
                root = false;
            } else {
                root = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            root = false;
        }
        return root;
    }

}
