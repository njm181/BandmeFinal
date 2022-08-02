package com.bandme.bandmefinal.data.Response

import com.google.gson.annotations.SerializedName

data class GetUserProfileResponse(
    @SerializedName("exist")
    val exist: Boolean,
    @SerializedName("message")
    val message: String,
    @SerializedName("user_profile")
    val user_profile: UserProfile
)