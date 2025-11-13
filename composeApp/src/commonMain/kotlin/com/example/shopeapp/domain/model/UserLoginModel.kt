package com.example.shopeapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


data class UserLoginModel (
    val id: Long = 0,
    var username: String,
    var password: String
)
