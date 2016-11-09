package com.androidpath.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/9 14:35 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class ShareUtils {
    private static SharedPreferences preferences;
    private static SharedPreferences.Editor editor;

    @SuppressLint("CommitPrefEdits")
    private  void initSharePreference(Context context, String spFileName) {
        preferences = context.getSharedPreferences(spFileName, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public String getString(Context context, String spFileName, String key, final String defaultValue) {
        initSharePreference(context, spFileName);
        return preferences.getString(key, defaultValue);
    }

    public void setString(Context context, String spFileName, final String key, final String value) {
        initSharePreference(context, spFileName);
        editor.putString(key, value);
    }

    public boolean getBoolean(Context context, String spFileName, final String key, final boolean defaultValue) {
        initSharePreference(context, spFileName);
        return preferences.getBoolean(key, defaultValue);
    }

    public void setBoolean(Context context, String spFileName, final String key, final boolean value) {
        initSharePreference(context, spFileName);
        editor.putBoolean(key, value);
    }

    public void setInt(Context context, String spFileName, final String key, final int value) {
        initSharePreference(context, spFileName);
        editor.putInt(key, value);
    }

    public int getInt(Context context, String spFileName, final String key, final int defaultValue) {
        initSharePreference(context, spFileName);
        return preferences.getInt(key, defaultValue);
    }

    public void setFloat(Context context, String spFileName, final String key, final float value) {
        initSharePreference(context, spFileName);
        editor.putFloat(key, value);
    }


    public float getFloat(Context context, String spFileName, final String key, final float defaultValue) {
        initSharePreference(context, spFileName);
        return preferences.getFloat(key, defaultValue);
    }

    public void setLong(Context context, String spFileName, final String key, final long value) {
        initSharePreference(context, spFileName);
        editor.putLong(key, value);
    }

    public long getLong(Context context, String spFileName, final String key, final long defaultValue) {
        initSharePreference(context, spFileName);
        return preferences.getLong(key, defaultValue);
    }

    /**
     * 提交修改(同步)
     */
    public void commit() {
        if (null != editor) {
            editor.commit();
        }
    }

    /**
     * 提交修改(异步)
     */
    public void apply() {
        if (null != editor) {
            editor.apply();
        }
    }

    /**
     * 删除keys`
     *
     * @param keys 删除的键值对
     */
    public void removeKeys(String... keys) {
        if (null != preferences && keys != null && keys.length > 0) {
            final SharedPreferences.Editor editor = preferences.edit();

            for (int i = 0; i < keys.length; i++) {
                if (!TextUtils.isEmpty(keys[i])) {
                    editor.remove(keys[i]);
                }
            }

            editor.commit();
        }
    }

    /**
     * 清除SharedPreferences所有数据
     *
     * @param context 上下文
     */
    public void clearPreference(Context context) {
        if (null != preferences) {
            final SharedPreferences.Editor editor = preferences.edit();
            editor.clear();
            editor.apply();
        }
    }
}
