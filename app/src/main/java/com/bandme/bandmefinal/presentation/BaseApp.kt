package com.bandme.bandmefinal.presentation

import android.app.Application
//import com.bandme.bandmefinal.domain.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApp: Application() {

    companion object {
        lateinit var prefs: SharedPref
    }

    override fun onCreate() {
        super.onCreate()
        /*startKoin {
            androidContext(this@BaseApp)
            modules(appModules)
        }*/
        prefs = SharedPref(applicationContext)
    }
}