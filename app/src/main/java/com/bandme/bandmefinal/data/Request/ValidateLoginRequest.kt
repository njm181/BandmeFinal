package com.bandme.bandmeapp.data.dto.Request

import com.google.gson.annotations.SerializedName

data class ValidateLoginRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)