package com.rmg.qc.core.service

import com.google.gson.GsonBuilder
import com.rmg.qc.Config
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiClient {

     private  val TIME_OUT = 60L
     private  val CONNECTION_TIME_OUT = 30L

//     @Provides
//     private fun provideRetrofit() : Retrofit.Builder{
//          return Retrofit.Builder().baseUrl(Config.BASE_URL)
//               .addConverterFactory(GsonConverterFactory.create())
//     }
     @Provides
     private fun provideLogInterceptors(): Interceptor {
          return HttpLoggingInterceptor().apply {
               level = if (Config.DEBUG) HttpLoggingInterceptor.Level.BODY
               else HttpLoggingInterceptor.Level.NONE
          }
     }
     @Provides
     private fun provideOKHttpClient(interceptor: Interceptor): OkHttpClient{
          return OkHttpClient.Builder()
              // .connectionPool(ConnectionPool(0, 1, TimeUnit.NANOSECONDS))
              // .protocols(listOf(Protocol.HTTP_1_1))
               .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
               .readTimeout(TIME_OUT, TimeUnit.SECONDS)
               .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
               .addInterceptor(interceptor)
               .followRedirects(false)
               .followSslRedirects(false)
               .build()
     }

     @Provides
     @Singleton
     fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
          return Retrofit.Builder()
               .baseUrl(Config.BASE_URL)
               .addConverterFactory(
                    GsonConverterFactory.create(
                         GsonBuilder().serializeNulls().create()
                    )
               )
               .client(okHttpClient)
               .build()
     }


}