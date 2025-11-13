package com.example.shopeapp.domain.repository

import com.example.shopeapp.domain.model.UserLoginModel

interface UserLoginRepository {

    fun getAllUsers(): List<UserLoginModel>

    fun getUserById(id: Long): UserLoginModel

    fun insertUser(user: UserLoginModel)

    fun updateUser(user: UserLoginModel)

    fun deleteUser(id: Long)

}