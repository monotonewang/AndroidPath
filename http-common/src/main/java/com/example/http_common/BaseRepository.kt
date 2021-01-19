package com.example.http_common


import kotlinx.coroutines.*

public class BaseRepository {
    constructor()

    suspend fun <T : Any> callRequest2(
            call: suspend () -> BaseEntityKt<T>
    ): BaseEntityKt<T> {
        return try {
            call()
        } catch (e: Exception) {
            //这里统一处理异常
            e.printStackTrace()
//            NetResult.Error2(DealException.handlerException(e))
            val handlerException = DealException.handlerException(e)
            val baseEntityKt = BaseEntityKt<T>()
            baseEntityKt.exception = handlerException;
            baseEntityKt
        }
    }

    fun <T : Any> handleResponse3(
            response: BaseEntityKt<T>,
            successBlock: (() -> Unit)? = null,
            errorBlock: (() -> Unit)? = null
    ): BaseEntityKt<T> {
        return if (response.code == "200") {
            successBlock?.let { it() }
            response
        } else {
            errorBlock?.let { it() }
            throw ResultException("20", if(response!=null) response.toString() else "")
//            response
        }
    }


    suspend fun <T : Any> handleResponse2(
            response: BaseEntityKt<T>,
            successBlock: (suspend CoroutineScope.() -> Unit)? = null,
            errorBlock: (suspend CoroutineScope.() -> Unit)? = null
    ): BaseEntityKt<T> {
        return coroutineScope {
            if (response.code == "200") {
                successBlock?.let { it() }
                response
            } else {
                errorBlock?.let { it() }
                response
            }
        }
    }

    /*
    suspend fun <T : Any> callRequest(
         call: suspend () -> NetResult<T>
     ): NetResult<T> {
         return try {
             call()
         } catch (e: Exception) {
             //这里统一处理异常
             e.printStackTrace()
             NetResult.Error(DealException.handlerException(e))
         }
     }

     suspend fun <T : Any> handleResponse(
         response: BaseModel<T>,
         successBlock: (suspend CoroutineScope.() -> Unit)? = null,
         errorBlock: (suspend CoroutineScope.() -> Unit)? = null
     ): NetResult<T> {
         return coroutineScope {
             if (response.code == "200") {
                 errorBlock?.let { it() }
                 NetResult.Error(
                     ResultException(
                         response.code.toString(),
                         response.message
                     )
                 )
             } else {
                 successBlock?.let { it() }
                 NetResult.Success(response.data)
             }
         }
     }
     */


}