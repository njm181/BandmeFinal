package com.bandme.bandmeapp.data.dto.Response

import com.google.gson.annotations.SerializedName

data class ValidateLoginResponse(
    @SerializedName("isAuthenticated")
    val isAuthenticated: Boolean,
    @SerializedName("user_data")
    val user_data: UserData
)