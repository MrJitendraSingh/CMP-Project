package com.example.shopeapp.data.repositoryImp

import com.example.shopeapp.data.room.AppDao
import com.example.shopeapp.data.room.AppDatabase
import com.example.shopeapp.data.room.entity.UserLoginEntity
import com.example.shopeapp.domain.model.UserLoginModel
import com.example.shopeapp.domain.repository.UserLoginRepository


class UserLoginRepositoryImp(private val appDatabase: AppDatabase): UserLoginRepository {
    val dao: AppDao = appDatabase.getDao()
    override fun getAllUsers(): List<UserLoginModel> {
        TODO("Not yet implemented")
    }

    override fun getUserById(id: Long): UserLoginModel {
        val user = dao.getUserById(id)
        return UserLoginModel(user.id, user.username, user.email, user.password)
    }

    override fun insertUser(user: UserLoginModel) {
        dao.insert(UserLoginEntity(user.id, user.username, user.email, user.password))
    }

    override fun updateUser(user: UserLoginModel) {
        TODO("Not yet implemented")
    }

    override fun deleteUser(id: Long) {
        dao.delete(id)
    }

}

