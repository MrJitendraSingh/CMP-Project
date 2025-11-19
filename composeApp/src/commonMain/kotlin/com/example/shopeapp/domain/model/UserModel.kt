package com.example.shopeapp.domain.model


data class UserModel (
    val id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var phoneNumber: String = "",
    var gender: String = "",
    var email: String = "",
    var password: String = "",
    var confirmPassword: String = "",
    val dateOfBirth: String = "",
    var termsAndConditions: Boolean = false
)