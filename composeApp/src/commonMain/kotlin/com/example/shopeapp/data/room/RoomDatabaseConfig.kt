package com.example.shopeapp.data.room

import androidx.room.RoomDatabase

interface RoomDatabaseConfig {

    fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase>
}