package com.androidpath;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.multidex.MultiDexApplication;
import androidx.work.Configuration;

import com.androidpath.db.BasicRoomDatabase;
import com.androidpath.executors.AppExecutors;
import com.androidpath.library.room.dao.DataRepository;

import java.util.LinkedList;
import java.util.List;

/**
 * deso: AndroidPath TODO<br/>
 * time: 2016/11/4 17:32 <br/>
 * author: 7 <br/>
 * since: V ${version} <br/>
 */
//zgjxfuqingwang@gmail.com
public class AndroidApplication extends MultiDexApplication implements Configuration.Provider {

    private AppExecutors mAppExecutors;

    public static Context context;

    private static List<AppCompatActivity> mActivityList = new LinkedList<>();
    //application pass value
    private String name, age, gender;
//    private RefWatcher refWatcher;

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

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        mAppExecutors = new AppExecutors();
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            return;
//        }
//        enabledStrictMode();
//        refWatcher = LeakCanary.install(this);

    }

    public BasicRoomDatabase getDatabase() {
        return BasicRoomDatabase.getInstance(this, mAppExecutors);
    }

    public DataRepository getRepository() {
        return DataRepository.getInstance(getDatabase());
    }


//    public staticfactory RefWatcher getRefWatcher(Context context){
//        AndroidApplication applicationContext = (AndroidApplication) context.getApplicationContext();
//        return applicationContext.refWatcher;
//    }
//
//    private void enabledStrictMode() {
//        if (SDK_INT >= GINGERBREAD) {
//            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
//                    .detectAll() //
//                    .penaltyLog() //
//                    .penaltyDeath() //
//                    .build());
//        }
//    }

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


    @NonNull
    @Override
    public Configuration getWorkManagerConfiguration() {
        return new Configuration.Builder().setMinimumLoggingLevel(Log.VERBOSE).build();
    }
}
