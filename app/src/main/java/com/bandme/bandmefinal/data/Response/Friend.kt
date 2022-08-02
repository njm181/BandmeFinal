package com.bandme.bandmefinal.data.Response

import com.google.gson.annotations.SerializedName

data class Friend(
    @SerializedName("_id")
    val _id: String,
    @SerializedName("first_name")
    val first_name: String,
    @SerializedName("isPremium")
    val isPremium: Boolean,
    @SerializedName("last_name")
    val last_name: String,
    @SerializedName("post_list")
    val post_list: List<String>,
    @SerializedName("profile_photo")
    val profile_photo: String
)