package com.example.shopeapp.data.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val gender: String,
    val email: String,
    var password: String,
    val confirmPassword: String,
    val termsAndConditions: Boolean
)