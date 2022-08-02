package com.bandme.bandmefinal.data.Response

import com.google.gson.annotations.SerializedName

data class UserProfile(
    @SerializedName("account_status")
    val account_status: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("email")
    val email: String = "",
    @SerializedName("first_name")
    val first_name: String = "",
    @SerializedName("friend_list")
    val friend_list: List<Friend> = listOf(),
    @SerializedName("isPremium")
    val isPremium: Boolean = false,
    @SerializedName("last_name")
    val last_name: String = "",
    @SerializedName("post_list")
    val post_list: List<String> = listOf(),
    @SerializedName("profile_photo")
    val profile_photo: String = "",
    @SerializedName("social_media")
    val social_media: List<SocialMedia> = listOf(),
    @SerializedName("user_type")
    val user_type: String  = ""
)