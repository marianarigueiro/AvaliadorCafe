package com.example.avaliadorcafe

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class CafeApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // segue o tema do celular automaticamente
        AppCompatDelegate.setDefaultNightMode(
            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        )
    }
}