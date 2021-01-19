package com.example.a2021basic.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.a2021basic.model.MeMainNumModel
import com.example.a2021basic.service.UserServiceKt
import com.example.http_common.RetrofitClientKt
import com.example.http_common.viewmodel.CommonViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel : CommonViewModel() {

    val mutableLiveData = MutableLiveData<MeMainNumModel>()

    fun login() {
        val map = HashMap<String,String>()
        GlobalScope.launch {
            val data =
                    getData(RetrofitClientKt.createApi(UserServiceKt::class.java).login(map), {

                    }, {

                    })
            mutableLiveData.postValue(data)
            return@launch
        }

    }

}