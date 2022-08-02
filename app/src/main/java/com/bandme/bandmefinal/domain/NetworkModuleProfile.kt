/*
package com.bandme.bandmefinal.domain

import com.bandme.bandmefinal.data.ProfileApiService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModuleProfile = module {
    single { provideOkHttpClientProfile() }
    single { provideRetrofitProfile(get()) }
    single { provideProfileApiService(get(), ProfileApiService::class.java) }
}

fun provideOkHttpClientProfile(): OkHttpClient = OkHttpClient.Builder().build()

fun provideRetrofitProfile(okHttpClient: OkHttpClient): Retrofit =
    Retrofit.Builder().baseUrl("https://bandme-api-profile.herokuapp.com/api/v1/profile/")
        .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()

fun provideProfileApiService(retrofit: Retrofit, profileApiService: Class<ProfileApiService>) =
    createServiceProfile(retrofit, profileApiService)

fun <T> createServiceProfile(retrofit: Retrofit, serviceClass: Class<T>): T = retrofit.create(serviceClass)
*/
