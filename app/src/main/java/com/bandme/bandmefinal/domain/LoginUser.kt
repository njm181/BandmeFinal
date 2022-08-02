package com.bandme.bandmefinal.domain

import com.google.gson.annotations.SerializedName

data class LoginUser(
    @SerializedName("isAuthenticated")
    var isAuthenticated: Boolean? = null,
    @SerializedName("jwt")
    var jwt: String,
    @SerializedName("email")
    var email: String = "",
    @SerializedName("isConfirm")
    var isConfirm: Boolean? = null,
)
