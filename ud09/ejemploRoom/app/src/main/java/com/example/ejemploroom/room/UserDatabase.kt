package com.example.ejemploroom.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ejemploroom.dao.IUserDAO
import com.example.ejemploroom.entitites.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao(): IUserDAO

}