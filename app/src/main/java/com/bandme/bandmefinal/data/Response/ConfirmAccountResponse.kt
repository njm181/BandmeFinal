package com.bandme.bandmefinal.data.Response

import com.google.gson.annotations.SerializedName

data class ConfirmAccountResponse(
    @SerializedName("isConfirm")
    val isConfirm: Boolean,
    @SerializedName("jwt")
    val jwt: String,
    @SerializedName("message")
    val message: String
)