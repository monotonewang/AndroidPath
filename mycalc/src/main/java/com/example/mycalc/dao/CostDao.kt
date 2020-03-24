package com.example.mycalc.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mycalc.bean.CostBean
import io.reactivex.Flowable

@Dao
interface CostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(products: List<CostBean>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(products: CostBean)

    @Query("SELECT * FROM costs")
    fun loadAll(): Flowable<List<CostBean?>?>?

    @Query("SELECT * FROM costs")
    fun loadAllSimple(): List<CostBean>

//    @Query("select * from costs where id = :costId")
//    fun loadCost(costId: Int): CostDao
}


