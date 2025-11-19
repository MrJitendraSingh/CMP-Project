package com.example.shopeapp.data.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

class AndroidRoomConfig(private val context: Context) : RoomDatabaseConfig {
    override fun getDatabaseBuilder(): RoomDatabase.Builder<AppDatabase> {
        val appContext = context.applicationContext
        val dbFile = appContext.getDatabasePath("shop_app.db")
        return Room.databaseBuilder<AppDatabase>(
            context = appContext,
            name = dbFile.absolutePath
        )
    }
}