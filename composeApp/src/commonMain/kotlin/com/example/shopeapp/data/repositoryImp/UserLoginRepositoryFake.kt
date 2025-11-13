package com.example.shopeapp.data.repositoryImp

import com.example.shopeapp.data.room.AppDao
import com.example.shopeapp.data.room.entity.UserLoginEntity
import com.example.shopeapp.domain.model.UserLoginModel
import com.example.shopeapp.domain.repository.UserLoginRepository


class UserLoginRepositoryFake(): UserLoginRepository {

    var list = mutableListOf<UserLoginModel>(
        UserLoginModel(1, "user1", "password1"),
        UserLoginModel(2, "user2", "password2"),
        UserLoginModel(3, "user3", "password3")
    )
    override fun getAllUsers(): List<UserLoginModel> {
        // adding dummy data list
        return list
    }

    override fun getUserById(id: Long): UserLoginModel {
        return list.first { it.id == id }
    }

    override fun insertUser(user: UserLoginModel) {
        list.add(user)
    }

    override fun updateUser(user: UserLoginModel) {

    }

    override fun deleteUser(id: Long) {
        list.forEach {
            if(it.id == id) list.remove(it)
        }
    }

}