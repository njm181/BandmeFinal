package com.bandme.bandmefinal.data.Request

import com.google.gson.annotations.SerializedName

data class ConfirmAccountRequest(
    @SerializedName("code")
    val code: String
)
