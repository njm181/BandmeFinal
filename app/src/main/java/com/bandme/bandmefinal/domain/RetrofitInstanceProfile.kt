package com.bandme.bandmefinal.domain

import com.bandme.bandmefinal.data.ProfileApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstanceProfile {
    companion object {
        var retrofitService: ProfileApiService? = null
        fun getInstance() : ProfileApiService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://bandme-api-profile.herokuapp.com/api/v1/profile/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(ProfileApiService::class.java)
            }
            return retrofitService!!
        }

    }
}