package com.bandme.bandmefinal.domain

interface LoginRespository {
    suspend fun validateEmail(email: String): Boolean?

    suspend fun validateLogin(email: String, password: String): LoginUser?

    suspend fun createAccount(
        email: String,
        password: String,
        userType: String,
        provider: String,
        firstName: String?,
        lastName: String?,
        profilePhoto: String?
    ) : Boolean

    suspend fun confirmAccount(code: String): LoginUser?
}