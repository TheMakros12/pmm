package com.example.ejemploroom2.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ejemploroom2.dao.EquipoDao
import com.example.ejemploroom2.entities.EquipoEntity
import com.example.ejemploroom2.entities.JugadorEntity

@Database(entities = [EquipoEntity::class, JugadorEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun equipoDao(): EquipoDao

}