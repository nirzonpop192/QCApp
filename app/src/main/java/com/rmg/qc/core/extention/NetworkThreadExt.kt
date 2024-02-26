package com.rmg.qc.core.extention

import com.foodibd.rider.core.data.DataResource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): DataResource<*>  {
    return withContext(dispatcher) {
        try {
            val response = apiCall.invoke()
            response as Response<*>
            if (response.isSuccessful) {
                DataResource.Success(
                    data = response.body(),
                    serverCode =  response.code()
                )
            } else {
                response.errorBody().toString().responseLog()
                response.errorBody().errorMessage?.let {
                    DataResource.Error(
                        message = it.message,
                        responseCode = response.code(),
                        data = it
                    )
                } ?: kotlin.run {
                    DataResource.Error(
                       // errorType = ErrorType.UNKNOWN,
                        responseCode = response.code(),
                        message = "Unkonwn Error"
                    )
                }
            }
        } catch (throwable: Throwable) {
            throwable.toString().responseLog()
            when (throwable) {
                is IOException -> {
                    DataResource.Error(

                        message = throwable.localizedMessage,
                        data = null,
                        responseCode = null

                    )
                }
                is HttpException -> {
                    DataResource.Error(
                        //errorType = ErrorType.NETWORK,
                        message = throwable.localizedMessage,
                        data = null,
                        responseCode = null
                    )
                }
                else -> {
                    DataResource.Error(
                        //errorType = ErrorType.UNKNOWN,
                        message = throwable.localizedMessage,
                        data = null,
                        responseCode = null
                    )
                }
            }
        }
    }
}