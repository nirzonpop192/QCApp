package com.rmg.qc.data.remote.repository

import android.net.http.NetworkException
import com.foodibd.rider.core.data.DataResource
import com.foodibd.rider.core.data.ResponseStatus
import com.foodibd.rider.data.remote.api.SignInApi
import com.foodibd.rider.domain.remote.repository.SignInRepository
import com.rmg.qc.data.entity.request.SignInRequest
import com.rmg.qc.core.extention.debugLog
import com.rmg.qc.core.extention.safeApiCall
import com.rmg.qc.core.extention.warnLog
import com.rmg.qc.data.entity.LoginResponse
import kotlinx.coroutines.Dispatchers
import okhttp3.Dispatcher
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val apiService: SignInApi): SignInRepository{

    private val tag = "httpRepository"

    suspend fun signIn(request: SignInRequest):  DataResource<*>  {

       "fetching currencies from api...".debugLog(tag)




        val data = safeApiCall(Dispatchers.IO) {
            apiService.signIn(request)
        }
        when (data.status) {
            ResponseStatus.SUCCESS -> {
                val responseData: LoginResponse =
                    (data.data as? LoginResponse) ?: return DataResource.Error(
                        responseCode = 0,
                        message = "error",
                        data = null
                    )
                return DataResource.Success(data = responseData,responseCode=data.responseCode)
            }

            ResponseStatus.ERROR -> {
                return DataResource.Error(

                    responseCode = 0,
                    message = "error",
                    data = null
                )
            }

            ResponseStatus.LOADING -> {
                return data
            }
        }



    }
}