/*
package com.bandme.bandmefinal

import com.bandme.bandmefinal.data.LoginApiService
import com.bandme.bandmefinal.data.ProfileApiService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModuleLogin = module {
    single { provideOkHttpClient() }
    single { provideRetrofitLogin(get()) }
    single { provideLoginApiService(get(), LoginApiService::class.java) }
}

fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

fun provideRetrofitLogin(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder().baseUrl("https://bandme-login-api.herokuapp.com/api/v1/login/")
        .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()

fun provideLoginApiService(retrofit: Retrofit, loginApiService: Class<LoginApiService>) =
    createService(retrofit, loginApiService)

fun <T> createService(retrofit: Retrofit, serviceClass: Class<T>): T = retrofit.create(serviceClass)
//===*/
