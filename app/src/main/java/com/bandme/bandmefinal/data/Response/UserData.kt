package com.bandme.bandmeapp.data.dto.Response

import com.google.gson.annotations.SerializedName

data class UserData(
    @SerializedName("userAuthenticated")
    val userAuthenticated: UserAuthenticated
)