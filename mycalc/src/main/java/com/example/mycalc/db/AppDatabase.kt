package com.example.mycalc.db

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mycalc.bean.CostBean
import com.example.mycalc.dao.CostDao

@Database(entities = [CostBean::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    private val mIsDatabaseCreated = MutableLiveData<Boolean>()

    abstract fun costDao(): CostDao;

    companion object {

        val DATABASE_NAME = "basic-sample-db"

        private var sInstance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (sInstance == null) {
                synchronized(AppDatabase::class.java) {
                    if (sInstance == null) {
                        sInstance = buildDatabase(context.applicationContext)

                        println("xxxxx sInstance=" + sInstance)
                        sInstance?.updateDatabaseCreated(context.applicationContext)
                    }
                }
            }
            return sInstance!!
        }

        fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build();
        }


    }

    private fun updateDatabaseCreated(context: Context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setDatabaseCreated()
        }
    }

    fun setDatabaseCreated() {
        mIsDatabaseCreated.postValue(true)
    }


}