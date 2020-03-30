package com.example.mycalc.view_model

import androidx.lifecycle.ViewModel
import com.example.mycalc.bean.CostBean
import com.example.mycalc.dao.CostDao
import io.reactivex.Completable
import io.reactivex.Flowable

class CostBeanViewModel() : ViewModel() {

    lateinit var costDao: CostDao;

    constructor(costDao: CostDao) : this() {
        this.costDao = costDao;
        println("this is init constructor");
    }

    init {
        println("this is init method");
    }

    fun getAllCost(): List<CostBean> {
        return costDao.loadAllSimple();
    }

    fun getFirstItem(): Flowable<CostBean?>? {
        return costDao.getFirstItem()
    }

    fun insertCost(costBean: CostBean): Completable {
        return costDao.insert(costBean)
    }
}