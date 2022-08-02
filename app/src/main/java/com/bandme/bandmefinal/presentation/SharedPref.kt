package com.bandme.bandmefinal.presentation

import android.content.Context
import android.content.SharedPreferences

class SharedPref (context: Context){
    val PREFS_NAME = "credenciales"
    val SHARED_NAME = "token"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, 0)
    var token: String?
        get() = prefs.getString(SHARED_NAME, "")
        set(value) = prefs.edit().putString(SHARED_NAME, value).apply()
}