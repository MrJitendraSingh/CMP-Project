package com.example.shopeapp.data.repositoryImp

import com.example.shopeapp.data.room.AppDao
import com.example.shopeapp.data.room.entity.UserLoginEntity
import com.example.shopeapp.domain.model.UserLoginModel
import com.example.shopeapp.domain.repository.UserLoginRepository


class UserLoginRepositoryImp(val dao: AppDao): UserLoginRepository {
    override fun getAllUsers(): List<UserLoginModel> {
        TODO("Not yet implemented")
    }

    override fun getUserById(id: Long): UserLoginModel {
        TODO("Not yet implemented")
    }

    override fun insertUser(user: UserLoginModel) {
        dao.insert(UserLoginEntity(user.id, user.username, user.password))
    }

    override fun updateUser(user: UserLoginModel) {
        TODO("Not yet implemented")
    }

    override fun deleteUser(id: Long) {
        dao.delete(id)
    }

}