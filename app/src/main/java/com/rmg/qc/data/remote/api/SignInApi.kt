package com.foodibd.rider.data.remote.api

import com.rmg.qc.data.entity.LoginResponse
import com.rmg.qc.data.entity.request.SignInRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInApi {

    @POST("Auth/Authenticate")
    suspend fun signIn(@Body request: SignInRequest): Response<LoginResponse>
}