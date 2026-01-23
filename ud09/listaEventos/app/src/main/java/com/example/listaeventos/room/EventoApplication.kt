package com.example.listaeventos.room

import android.app.Application
import androidx.room.Room

class EventoApplication: Application() {

    companion object {
        lateinit var database: EventoDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            context = this,
            klass = EventoDatabase::class.java,
            name = "EventoDatabase").build()
    }
}