package com.bandme.bandmeapp.data.dto.Response

import com.google.gson.annotations.SerializedName

data class ValidateEmailResponse(
    @SerializedName("exist_email")
    val exist_email: Boolean,
    @SerializedName("jwt")
    val jwt: String,
    @SerializedName("message")
    val message: String
)