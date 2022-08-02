package com.bandme.bandmeapp.data.dto.Response

import com.google.gson.annotations.SerializedName

data class UserAuthenticated(
    @SerializedName("email")
    val email: String = "",
    @SerializedName("jwt")
    var jwt: String = ""
)