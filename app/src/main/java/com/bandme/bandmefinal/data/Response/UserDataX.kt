package com.bandme.bandmefinal.data.Response

import com.google.gson.annotations.SerializedName

data class UserDataX(
    @SerializedName("email")
    val email: String,
    @SerializedName("userType")
    val userType: String
)