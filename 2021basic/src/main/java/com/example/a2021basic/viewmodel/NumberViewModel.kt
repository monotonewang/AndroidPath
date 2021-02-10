package com.example.a2021basic.viewmodel

import android.content.Context
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NumberViewModel : ViewModel {

    constructor() {}
    constructor(context: Context?) {}

    private var mutableLiveDataA1 = MutableLiveData<Int>()


    fun setA1(count: Int) {
        this.mutableLiveDataA1.value = count
    }

    fun getA1(): MutableLiveData<Int> {
//        mutableLiveDataA1.value = 12;
        return mutableLiveDataA1;
    }

}