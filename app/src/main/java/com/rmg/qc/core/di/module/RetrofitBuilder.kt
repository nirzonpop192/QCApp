package com.foodibd.rider.module
//
//import com.foodibd.rider.core.Constants
//import okhttp3.OkHttpClient
//import retrofit2.Retrofit
//import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
//import retrofit2.converter.gson.GsonConverterFactory
//import java.util.concurrent.TimeUnit
//
//object RetrofitBuilder {
//
//    private const val connectionTimeOut: Long = 120
//    private const val readTimeout: Long = 120
//    private const val writeTimeout: Long = 120
//    private const val callTimeout: Long = 120
//
//    var okHttpClient: OkHttpClient = OkHttpClient.Builder()
//        .connectTimeout(connectionTimeOut, TimeUnit.SECONDS)
//        .readTimeout(readTimeout, TimeUnit.SECONDS)
//        .writeTimeout(writeTimeout, TimeUnit.SECONDS)
//        .callTimeout(callTimeout, TimeUnit.SECONDS)
//        .build()
//
//    fun getRetrofit():Retrofit{
//        return Retrofit.Builder()
//            .baseUrl(Constants.BASE_URL)
//            // .addConverterFactory(GsonConverterFactory.create())
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .client(okHttpClient)
//            .build()
//    }
//
//
//
//
//    fun getRetrofitWithInterceptor():Retrofit{
//        val clintWithInterceptor = okHttpClient
//        return Retrofit.Builder()
//            .baseUrl(Constants.BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .client(clintWithInterceptor)
//            .build()
//    }
//}