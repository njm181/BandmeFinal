package com.bandme.bandmefinal.data.Response

import com.google.gson.annotations.SerializedName

data class CreateAccountResponse(
    @SerializedName("accountCreated")
    val accountCreated: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("payload")
    val payload: Payload
)