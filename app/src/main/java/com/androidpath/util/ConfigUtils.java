package com.androidpath.util;

import android.content.Context;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/9 14:58 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class ConfigUtils {
    private static String ConfigFileName = "configfilename";
    private static String APPLanguage = "applanguage";

    public static void setAppLanguage(Context context, int index) {
        ShareUtils shareUtils = new ShareUtils();
        shareUtils.setInt(context, ConfigFileName, APPLanguage, index);
        shareUtils.commit();
    }

    public static int getAPPLanguage(Context context) {
        ShareUtils shareUtils = new ShareUtils();
        return shareUtils.getInt(context, ConfigFileName, APPLanguage, 0);
    }
}
