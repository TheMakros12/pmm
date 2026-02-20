package com.example.ejemploexamen.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ejemploexamen.api.Character

@Database(entities = [Character::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun characterDao(): CharacterDao

}