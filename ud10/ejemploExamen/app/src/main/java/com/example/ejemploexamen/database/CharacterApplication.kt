package com.example.ejemploexamen.database

import android.app.Application
import androidx.room.Room

class CharacterApplication : Application() {

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "RickMortyDB"
        ).build()
    }
}