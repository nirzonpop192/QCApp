package com.foodibd.rider.module

import com.foodibd.rider.data.remote.api.SignInApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SignInModule {

//    @Provides
//    @Singleton
//    fun provideSignInApi(): SignInApi {
//        return RetrofitBuilder
//            .getRetrofit()
//            .create(SignInApi::class.java)
//    }
    @Provides
    fun provideAuthApiService(retrofit: Retrofit): SignInApi {
        return retrofit.create(SignInApi::class.java)
    }
}