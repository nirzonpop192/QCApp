package com.foodibd.rider.data.remote.api

import com.rmg.qc.data.entity.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInApi {

    @POST("Auth/Authenticate")
    suspend fun login(@Body hashMap: Map<String, String>): Response<LoginResponse>
}