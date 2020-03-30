package com.example.mycalc.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mycalc.dao.CostDao

class ViewModelFactory() :ViewModelProvider.Factory{

    lateinit var costDao: CostDao;

    constructor(costDao: CostDao) : this() {
        this.costDao = costDao;
        println("this is ViewModelFactory init constructor");
    }

    init {
        println("this is ViewModelFactory init method");
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CostBeanViewModel::class.java)){
            return CostBeanViewModel(costDao) as T;
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}