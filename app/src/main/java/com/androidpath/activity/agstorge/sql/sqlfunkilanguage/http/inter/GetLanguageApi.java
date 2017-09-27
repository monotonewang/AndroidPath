package com.androidpath.activity.agstorge.sql.sqlfunkilanguage.http.inter;

import com.androidpath.activity.agstorge.sql.sqlfunkilanguage.entity.LanguageResponse;

import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * Created by ubuntu on 17-9-27.
 */

public interface GetLanguageApi {

    @POST("/v_1_0/operation/language/get")
    Observable<LanguageResponse> getLanguage();

}
