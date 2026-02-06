package com.example.reto_libreria.database

import android.app.Application
import androidx.room.Room

class LibroApplication: Application() {

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "AppDatabase").build()
    }

}