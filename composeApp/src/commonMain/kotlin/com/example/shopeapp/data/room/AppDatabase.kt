package com.example.shopeapp.data.room

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.example.shopeapp.data.room.dao.UserDao
import com.example.shopeapp.data.room.entity.UserEntity
import com.example.shopeapp.data.room.entity.UserLoginEntity

@Database(entities = [UserLoginEntity::class, UserEntity::class], version = 1)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getDao(): AppDao
    abstract fun getUserDao(): UserDao
}

@Suppress("KotlinNoActualForExpect")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}