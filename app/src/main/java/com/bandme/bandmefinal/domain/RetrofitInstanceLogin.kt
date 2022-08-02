package com.bandme.bandmefinal.domain

import com.bandme.bandmefinal.data.LoginApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstanceLogin {
    companion object {
        var retrofitService: LoginApiService? = null
        fun getInstance() : LoginApiService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://bandme-login-api.herokuapp.com/api/v1/login/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(LoginApiService::class.java)
            }
            return retrofitService!!
        }

    }
}