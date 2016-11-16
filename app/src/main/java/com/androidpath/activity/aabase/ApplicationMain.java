package com.androidpath.activity.aabase;

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
    //application pass value
    private String name, age, gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

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

    public static int getActivityListSize() {
        if (mActivityList != null) {
            return mActivityList.size();
        }
        return 0;
    }


}
