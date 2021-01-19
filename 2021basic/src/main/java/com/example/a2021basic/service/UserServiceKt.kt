package com.example.a2021basic.service

import com.example.a2021basic.model.HttpModel
import com.example.a2021basic.model.HttpQuestionnaire
import com.example.a2021basic.model.MeMainNumModel
import com.example.http_common.BaseEntityKt
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface UserServiceKt {

    /**
     * 课程搜索结果
     *
     * @param map
     * @return
     */
    @GET("/v2/user/course/search")
    suspend fun getUserSearchResult2(@QueryMap map: HashMap<String,String>?): HttpModel<List<HttpQuestionnaire>>

    @GET("/v1/user/course/numstat")
    suspend fun login(@QueryMap map: HashMap<String,String>?): BaseEntityKt<MeMainNumModel>

}