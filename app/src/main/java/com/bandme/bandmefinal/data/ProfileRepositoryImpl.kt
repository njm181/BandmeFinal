package com.bandme.bandmefinal.data

import com.bandme.bandmefinal.data.Response.UserProfile
import com.bandme.bandmefinal.domain.ProfileRepository
import com.bandme.bandmefinal.domain.RetrofitInstanceProfile
import com.bandme.bandmefinal.presentation.BaseApp

class ProfileRepositoryImpl(): ProfileRepository {

    private var profileApiService: ProfileApiService = RetrofitInstanceProfile.getInstance()

    override suspend fun getUserProfile(): UserProfile {
        val response = profileApiService.getUserProfile(authorization = BaseApp.prefs.token.toString())
        var userProfile: UserProfile = if(response.isSuccessful){
            response.body()?.user_profile.let {
                UserProfile(
                    account_status = it?.account_status!!,
                    description = it.description,
                    email = it.email,
                    first_name = it.first_name,
                    friend_list = it.friend_list,
                    isPremium = it.isPremium,
                    last_name = it.last_name,
                    post_list = it.post_list,
                    profile_photo = it.profile_photo,
                    social_media = it.social_media,
                    user_type = it.user_type
                )
            }
        }else{
            UserProfile()
        }
        return userProfile
    }


}