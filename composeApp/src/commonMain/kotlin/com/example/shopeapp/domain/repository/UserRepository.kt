package com.example.shopeapp.domain.repository

import com.example.shopeapp.domain.model.UserModel
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    suspend fun registerUser(user: UserModel)
    fun isUserRegistered(email: String): Flow<Boolean>
    // Create
    suspend fun insertUser(user: UserModel): Long

    // Read
    fun getAllUsers(): Flow<List<UserModel>>
    fun getUserById(id: Long): Flow<UserModel?>
    fun getUserByEmail(email: String): Flow<UserModel?>

    // Update
    suspend fun updateUser(user: UserModel)

    // Delete
    suspend fun deleteUser(user: UserModel)
    suspend fun deleteUserById(id: Long)
}
