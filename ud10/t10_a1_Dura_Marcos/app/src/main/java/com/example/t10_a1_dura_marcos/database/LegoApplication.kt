package com.example.t10_a1_dura_marcos.database

import android.app.Application
import androidx.room.Room

class LegoApplication : Application() {

    companion object {
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "AppDatabase").build()
    }

}