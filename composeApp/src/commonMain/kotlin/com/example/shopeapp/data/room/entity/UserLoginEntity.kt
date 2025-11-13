package com.example.shopeapp.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_login")
data class UserLoginEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val username: String,
    var password: String
)
