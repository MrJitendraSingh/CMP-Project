package com.example.shopeapp

import android.app.Application
import com.example.shopeapp.data.pref.createDataStore
import com.example.shopeapp.di.initKoin
import org.koin.android.ext.koin.androidContext

class ShopApp: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@ShopApp)
        }
    }
}