package com.bandme.bandmefinal.domain

import com.bandme.bandmefinal.data.Response.UserProfile

interface ProfileRepository {

    suspend fun getUserProfile(): UserProfile
}