package com.example.mycalc.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mycalc.bean.CostBean
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface CostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(costBean: List<CostBean>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(costBean: CostBean): Completable

    @Query("SELECT * FROM costs")
    fun loadAll(): Flowable<List<CostBean?>?>?

    @Query("SELECT * FROM costs")
    fun loadAllSimple(): List<CostBean>

    @Query("SELECT * FROM costs LIMIT 1")
    fun getFirstItem(): Flowable<CostBean?>?

    //删除所有的数据
    @Query("DELETE FROM costs")
    fun deleteAll()

//    @Query("select * from costs where id = :costId")
//    fun loadCost(costId: Int): CostDao
}


