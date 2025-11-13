package com.example.shopeapp.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.shopeapp.data.room.entity.UserLoginEntity

@Dao
interface AppDao {
    @Query("SELECT * FROM user_login")
    fun getAll(): List<UserLoginEntity>

    @Insert
    fun insert(appEntity: UserLoginEntity)

    @Query("SELECT * FROM user_login WHERE id = :id")
    fun getUserById(id: Long): UserLoginEntity

    @Query("DELETE FROM user_login WHERE id = :id")
    fun delete(id: Long)

}