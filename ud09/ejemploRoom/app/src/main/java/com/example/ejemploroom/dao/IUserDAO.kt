package com.example.ejemploroom.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.ejemploroom.entitites.UserEntity

@Dao
interface IUserDAO {

    @Insert
    fun insert(user: UserEntity)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUsers(users: List<UserEntity>)

    @Query("SELECT * FROM usuarios")
    fun getAll(): List<UserEntity>
    @Update
    fun update(vararg users: UserEntity)
    @Delete
    fun delete(user: UserEntity)
    @Delete
    fun deleteUsers(vararg users: UserEntity)

}