package com.example.shopeapp.data.repositoryImp

import com.example.shopeapp.data.room.AppDatabase
import com.example.shopeapp.data.room.mapper.toEntity
import com.example.shopeapp.data.room.mapper.toModel
import com.example.shopeapp.domain.model.UserModel
import com.example.shopeapp.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImp(appDatabase: AppDatabase): UserRepository {

    private val userDao = appDatabase.getUserDao()

    override suspend fun registerUser(user: UserModel) {
        userDao.insertUser(user.toEntity())
    }

    override fun isUserRegistered(email: String): Flow<Boolean> = userDao.isUserRegistered(email)

    override suspend fun insertUser(user: UserModel): Long {
        return userDao.insertUser(user.toEntity())
    }

    override fun getAllUsers(): Flow<List<UserModel>> {
        return userDao.getAllUsers().map { list ->
            list.map { it.toModel() }
        }
    }

    override fun getUserById(id: Long): Flow<UserModel?> = userDao.getUserById(id).map { it?.toModel() }

    override fun getUserByEmail(email: String): Flow<UserModel?> {
        return userDao.getUserByEmail(email).map { it?.toModel() }
    }

    override suspend fun updateUser(user: UserModel) {
        userDao.updateUser(user.toEntity())
    }

    override suspend fun deleteUser(user: UserModel) {
        userDao.deleteUser(user.toEntity())
    }

    override suspend fun deleteUserById(id: Long) {
        userDao.deleteUserById(id)
    }
}
