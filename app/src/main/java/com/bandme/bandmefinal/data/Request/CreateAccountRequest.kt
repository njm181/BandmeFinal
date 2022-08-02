package com.bandme.bandmefinal.data.Request

import com.google.gson.annotations.SerializedName

data class CreateAccountRequest(
    @SerializedName("email")
    val email: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("profilePhoto")
    val profilePhoto: String,
    @SerializedName("provider")
    val provider: String,
    @SerializedName("userType")
    val userType: String
)