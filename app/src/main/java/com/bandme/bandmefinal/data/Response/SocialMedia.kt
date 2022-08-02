package com.bandme.bandmefinal.data.Response

import com.google.gson.annotations.SerializedName

data class SocialMedia(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)