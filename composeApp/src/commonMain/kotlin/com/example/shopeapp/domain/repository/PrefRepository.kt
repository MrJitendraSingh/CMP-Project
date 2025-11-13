package com.example.shopeapp.domain.repository




interface PrefRepository {

    suspend fun getUsername(): String

    suspend fun setUsername(username: String)

    suspend fun getPassword(): String

    suspend fun setPassword(password: String)

}