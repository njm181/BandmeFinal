package com.bandme.bandmeapp.data.dto.Request

import com.google.gson.annotations.SerializedName

data class ValidateEmailRequest(
    @SerializedName("email")
    val email: String,
)
