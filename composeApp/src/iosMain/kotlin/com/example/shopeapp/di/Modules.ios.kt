package com.example.shopeapp.di

import com.example.shopeapp.data.pref.createDataStoreIos
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single {
        createDataStoreIos()
    }
}