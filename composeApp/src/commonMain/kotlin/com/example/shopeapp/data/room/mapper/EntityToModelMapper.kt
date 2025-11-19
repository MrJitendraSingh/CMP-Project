package com.example.shopeapp.data.room.mapper

import com.example.shopeapp.data.room.entity.UserEntity
import com.example.shopeapp.domain.model.UserModel

fun UserEntity.toModel(): UserModel {
    return UserModel(
        id = this.id,
        firstName = this.firstName,
        lastName = this.lastName,
        phoneNumber = this.phoneNumber,
        gender = this.gender,
        email = this.email,
        password = this.password,
        confirmPassword = this.confirmPassword,
        termsAndConditions = this.termsAndConditions
    )
}

