package com.example.mycalc

import android.app.Application
import android.content.Context
import com.example.mycalc.db.AppDatabase

class AppApplication : Application() {

    override fun getApplicationContext(): Context {
        return super.getApplicationContext()
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext;
    }

    companion object {
        lateinit var context: Context;
        fun getApplicationContext(): Context {
            return context;
        }

        fun getDatabase(): AppDatabase {
            return AppDatabase.getInstance(AppApplication.getApplicationContext());
        }

    }


}