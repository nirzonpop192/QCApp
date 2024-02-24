package com.rmg.qc.service

import com.rmg.qc.Config
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

     private  val TIME_OUT = 60L
     private  val CONNECTION_TIME_OUT = 30L
     private fun provideRetrofit() : Retrofit.Builder{
          return Retrofit.Builder().baseUrl(Config.BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
     }

     private fun getLogInterceptors(): Interceptor {
          return HttpLoggingInterceptor().apply {
               level = if (Config.DEBUG) HttpLoggingInterceptor.Level.BODY
               else HttpLoggingInterceptor.Level.NONE
          }
     }

     private fun provideOKHttpClient(): OkHttpClient{
          return OkHttpClient.Builder()
              // .connectionPool(ConnectionPool(0, 1, TimeUnit.NANOSECONDS))
              // .protocols(listOf(Protocol.HTTP_1_1))
               .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
               .readTimeout(TIME_OUT, TimeUnit.SECONDS)
               .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
               .addInterceptor(getLogInterceptors())
               .followRedirects(false)
               .followSslRedirects(false)
               .build()
     }

     private fun providesAPI(retrofitBuilder: Retrofit.Builder, okHttpClient: OkHttpClient): ApiService {
          return retrofitBuilder.client(okHttpClient).build().create(ApiService::class.java)
     }
     fun create():ApiService{
          return providesAPI(provideRetrofit(),provideOKHttpClient())
     }
}