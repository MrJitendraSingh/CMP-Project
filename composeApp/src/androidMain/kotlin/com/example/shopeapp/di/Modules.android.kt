package com.example.shopeapp.di

import com.example.shopeapp.data.pref.createDataStore
import com.example.shopeapp.data.pref.createDataStoreAndroid
import com.example.shopeapp.data.room.AndroidRoomConfig
import com.example.shopeapp.data.room.RoomDatabaseConfig
import org.koin.androidx.compose.get
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

actual val platformModule: Module = module {
    single{
        createDataStoreAndroid(get())
    }
    single<RoomDatabaseConfig> { AndroidRoomConfig(get()) }
}