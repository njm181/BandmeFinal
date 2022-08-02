package com.bandme.bandmefinal.data

import com.bandme.bandmeapp.data.dto.Request.ValidateEmailRequest
import com.bandme.bandmeapp.data.dto.Request.ValidateLoginRequest
import com.bandme.bandmeapp.data.dto.Response.ValidateEmailResponse
import com.bandme.bandmeapp.data.dto.Response.ValidateLoginResponse
import com.bandme.bandmefinal.data.Request.ConfirmAccountRequest
import com.bandme.bandmefinal.data.Request.CreateAccountRequest
import com.bandme.bandmefinal.data.Response.ConfirmAccountResponse
import com.bandme.bandmefinal.data.Response.CreateAccountResponse
import com.bandme.bandmefinal.data.Response.GetUserProfileResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface LoginApiService {

    @POST("validate/email")
    suspend fun validateEmail(
        @Body email: ValidateEmailRequest
    ) : Response<ValidateEmailResponse>

    @POST("validate/login")
    suspend fun validateLogin(
        @Body loginRequest: ValidateLoginRequest
    ) : Response<ValidateLoginResponse>

    @POST("create/account")
    suspend fun createAccount(
        @Body createAccountRequest: CreateAccountRequest
    ) : Response<CreateAccountResponse>

    @POST("confirm/account")
    suspend fun confirmAccount(
        @Body confirmAccountRequest: ConfirmAccountRequest
    ) : Response<ConfirmAccountResponse>

}