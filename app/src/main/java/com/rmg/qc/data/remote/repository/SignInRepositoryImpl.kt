package com.rmg.qc.data.remote.repository

import android.net.http.NetworkException
import com.foodibd.rider.data.remote.api.SignInApi
import com.foodibd.rider.domain.remote.repository.SignInRepository
import com.rmg.qc.data.entity.request.SignInRequest
import com.rmg.qc.util.extention.debugLog
import com.rmg.qc.util.extention.warnLog
import javax.inject.Inject

class SignInRepositoryImpl @Inject constructor(
    private val apiService: SignInApi): SignInRepository{

    private val tag = "httpRepository"

    fun fetchAllCurrencies(request: SignInRequest): Map<String, String> {

       "fetching currencies from api...".debugLog(tag)


        val request =
            apiService.signIn(request)

        val response = request.execute()

        if (!response.isSuccessful) {

                "a network error occurred during comunication, throwing a NetworkException ${response.errorBody()}".warnLog(tag)

            throw NetworkException()
        }

        val responseBody = response.body()
        if (responseBody == null) {
            Log.w(
                tag,
                "an unexpected error occurred during comunication, throwing a GenericException ${response.errorBody()}"
            )
            throw GenericException()
        }

        Log.d(tag, "call executhed, response body: $responseBody")

        return responseBody
    }
}