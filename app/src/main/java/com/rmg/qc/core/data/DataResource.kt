package com.foodibd.rider.core.data

import androidx.lifecycle.viewmodel.ktx.R


sealed class DataResource<T>(

    val data: T? = null,
    val message: String? = null,
    val errorCode: Int? = null,
    val responseCode:Int?=null,
    val status: ResponseStatus
) {
    class Success<T>(data: T,responseCode: Int?) : DataResource<T>(status = ResponseStatus.SUCCESS,data = data,responseCode = responseCode)

    /**
     * if i need error type I will do it
     */
    class Error<T>(message: String, data: T? = null, responseCode:Int?) : DataResource<T>(status = ResponseStatus.ERROR,data=data, message=message,responseCode=responseCode)
    class Loading<T>(data: T? = null) : DataResource<T>(status = ResponseStatus.LOADING,data=data)
}

enum class ResponseStatus {
    SUCCESS, ERROR, LOADING
}

enum class ErrorType {
    NETWORK, IO, UNKNOWN, API
}

