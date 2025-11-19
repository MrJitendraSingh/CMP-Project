package com.example.shopeapp.di

import com.example.shopeapp.data.pref.createDataStoreIos
import com.example.shopeapp.data.room.IosRoomConfig
import com.example.shopeapp.data.room.RoomDatabaseConfig
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module = module {
    single {
        createDataStoreIos()
    }
    single<RoomDatabaseConfig> { IosRoomConfig() }
}