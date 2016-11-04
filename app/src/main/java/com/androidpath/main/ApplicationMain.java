package com.androidpath.main;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;

import java.util.LinkedList;
import java.util.List;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/4 17:32 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */

public class ApplicationMain extends Application {

    private static List<AppCompatActivity> mActivityList = new LinkedList<>();

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public static void addActivity(AppCompatActivity appCompatActivity) {
        if (mActivityList != null) {
            mActivityList.add(appCompatActivity);
        }
    }

    public static void finishAllActivity() {
        if (mActivityList != null) {
            for (AppCompatActivity appCompatActivity : mActivityList) {
                appCompatActivity.finish();
            }
        }
    }
    public static int getActivityListSize(){
        if(mActivityList!=null){
            return mActivityList.size();
        }
        return 0;
    }
}
