package com.example.reto_libreria.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.reto_libreria.dao.LibroDao
import com.example.reto_libreria.data.Libro

@Database(
    entities = [Libro::class],
    version = 1
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun libroDao(): LibroDao

}