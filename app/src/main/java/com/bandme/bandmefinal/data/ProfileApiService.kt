package com.bandme.bandmefinal.data

import com.bandme.bandmefinal.data.Response.GetUserProfileResponse
import com.bandme.bandmefinal.presentation.BaseApp
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers

interface ProfileApiService {

    @GET("user-profile")
    suspend fun getUserProfile(@Header("auth-token") authorization: String) : Response<GetUserProfileResponse>
}