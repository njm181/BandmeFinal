package com.bandme.bandmefinal.data

import com.bandme.bandmeapp.data.dto.Request.ValidateEmailRequest
import com.bandme.bandmeapp.data.dto.Request.ValidateLoginRequest
import com.bandme.bandmefinal.data.Request.ConfirmAccountRequest
import com.bandme.bandmefinal.data.Request.CreateAccountRequest
import com.bandme.bandmefinal.domain.LoginRespository
import com.bandme.bandmefinal.domain.LoginUser
import com.bandme.bandmefinal.domain.RetrofitInstanceLogin

class LoginRepositoryImpl(): LoginRespository {

    private var loginApiService: LoginApiService = RetrofitInstanceLogin.getInstance()


    override suspend fun validateEmail(email: String): Boolean? {
        val response = loginApiService.validateEmail(ValidateEmailRequest(email))
        var resp = false
        resp = if (response.isSuccessful){
            response.body()?.exist_email == true
        } else {
            false
        }
        return resp
    }

    override suspend fun validateLogin(email: String, password: String): LoginUser? {
        val response = loginApiService.validateLogin(ValidateLoginRequest(email = email, password = password))
        var loginUser: LoginUser = if (response.isSuccessful){
            LoginUser(
                isAuthenticated = response.body()?.isAuthenticated,
                jwt = response.body()?.user_data?.userAuthenticated?.jwt!!,
                email = response.body()?.user_data?.userAuthenticated?.email!!
            )
        } else {
            LoginUser(isAuthenticated = false, jwt = "999")
        }
        return loginUser
    }

    override suspend fun createAccount(
        email: String,
        password: String,
        userType: String,
        provider: String,
        firstName: String?,
        lastName: String?,
        profilePhoto: String?
    ): Boolean {
        val response = loginApiService.createAccount(CreateAccountRequest(
            email = email,
            password = password,
            userType = userType,
            provider = provider,
            firstName = firstName.orEmpty(),
            lastName = lastName.orEmpty(),
            profilePhoto = profilePhoto.orEmpty()
        ))
        var isAccountCreated = false
        isAccountCreated = if (response.isSuccessful){
            response.body()?.accountCreated!!
        }else{
            false
        }
        return isAccountCreated
    }

    override suspend fun confirmAccount(code: String): LoginUser? {
        val response = loginApiService.confirmAccount(ConfirmAccountRequest(code = code))
        var loginUser: LoginUser = if (response.isSuccessful){
            LoginUser(isConfirm = response.body()?.isConfirm, jwt = response.body()?.jwt!!)

        } else {
            LoginUser(isConfirm = false, jwt = "999")
        }
        return loginUser
    }


}