package com.example.reto4_dura_marcos.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Libro::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun libroDao(): LibroDao
}
