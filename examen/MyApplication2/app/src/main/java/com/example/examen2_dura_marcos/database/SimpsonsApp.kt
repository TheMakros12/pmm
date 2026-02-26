package com.example.examen2_dura_marcos.database

import android.app.Application
import androidx.room.Room

class SimpsonsApp : Application() {

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "AppDatabase").build()
    }
}