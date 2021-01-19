package com.example.http_common.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.http_common.BaseEntityKt
import com.example.http_common.BaseRepository

open class CommonViewModel: ViewModel() {

    var mRepository: BaseRepository = BaseRepository()

//    init {
//        mRepository = BaseRepository()
//    }

    var httpLiveData: MutableLiveData<Boolean> = MutableLiveData()

    protected suspend fun <T : Any> getData(
            data: BaseEntityKt<T>,
            successBlock: (() -> Unit)? = null,
            errorBlock: (() -> Unit)? = null,
            isShowLoading: Boolean? = true
    ): T {
        val callRequest2 = mRepository.callRequest2 {
            if (isShowLoading != null && isShowLoading) {
                httpLiveData.postValue(true)
            }
            val handleResponse2 = mRepository.handleResponse3(data, successBlock, errorBlock)

            if (isShowLoading != null && isShowLoading) {
                httpLiveData.postValue(false)
            }
            handleResponse2

        }
        return callRequest2.data
    }

    override fun onCleared() {
        super.onCleared()

    }



}