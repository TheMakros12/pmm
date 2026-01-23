package com.example.listaeventos.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.listaeventos.dao.EventoDao
import com.example.listaeventos.entities.Evento

@Database(entities = [Evento::class], version = 1)
abstract class EventoDatabase: RoomDatabase() {

    abstract fun eventoDao(): EventoDao

}