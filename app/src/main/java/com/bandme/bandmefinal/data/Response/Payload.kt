package com.bandme.bandmefinal.data.Response

import com.google.gson.annotations.SerializedName

data class Payload(
    @SerializedName("user_data")
    val user_data: UserDataX
)